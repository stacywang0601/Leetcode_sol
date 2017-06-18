package B06_18;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 **/
public class Leet438FindAllAnagramsinaString {
	/**
	 * the sum of all hash[i] is always >=0;
	 * count is the sum of all positive hash[i];
	 * therefore, every hash[i] is zero if and only if count is 0.
	 **/
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (s == null || p == null || s.length() == 0 || p.length() == 0) {
			return res;
		}
		// lowercase
		int[] hash = new int[26];
		for (char c : p.toCharArray()) {
			hash[c - 'a']++;
		}
		int left = 0, right = 0, count = 0;
		while (right < s.length()) {
			char rr = s.charAt(right);
			// has it in hash, could use it
			if (hash[rr - 'a'] > 0) {
				count++;
			}
			// update valid count for this char --!!!
			hash[rr - 'a']--;
			// move to right
			right++;

			// since count is only valid count
			if (count == p.length()) {
				res.add(left);
			}

			// when winLen == plength
			if (right - left == p.length()) {
				char ll = s.charAt(left);
				if (hash[ll - 'a'] >= 0) {
					count--;
				}
				hash[ll - 'a']++;
				left++;
			}
		}
		return res;
	}
}

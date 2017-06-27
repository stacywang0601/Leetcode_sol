package B06_27;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so
 * that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * 
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet336PalindromePairs {
	/**
	 * word2 + s1 + s2 is palindrome
	 * s1 + s2 + word2 is palindrome
	 * 
	 * The <= in for (int j=0; j<=words[i].length(); j++) is aimed to handle empty string in the
	 * input. Consider the test case of ["a", ""];
	 * 
	 * Since we now use <= in for (int j=0; j<=words[i].length(); j++) instead of <. There may be
	 * duplicates in the output (consider test case ["abcd", "dcba"]). Therefore I put a
	 * str2.length()!=0 to avoid duplicates.
	 */
	public List<List<Integer>> palindromePairs(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++)
			map.put(words[i], i);

		List<List<Integer>> ret = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j <= words[i].length(); j++) { // Note j=[0..len]: s1="",s2=word ->
				                                           // s1=word,s2=""
				String s1 = words[i].substring(0, j);
				String s2 = words[i].substring(j);
				if (isPalindrome(s1)) { // word2 + s1 + s2 is palindrome
					String t = new StringBuilder(s2).reverse().toString();
					if (map.getOrDefault(t, i) != i)
						ret.add(Arrays.asList(map.get(t), i));
				}
				if (isPalindrome(s2) && !s2.isEmpty()) { // s1 + s2 + word2 is palindrome (avoid
					                                     // duplicate)
					String t = new StringBuilder(s1).reverse().toString();
					if (map.getOrDefault(t, i) != i)
						ret.add(Arrays.asList(i, map.get(t)));
				}
			}
		}
		return ret;
	}

	private boolean isPalindrome(String str) {
		for (int l = 0, r = str.length() - 1; l <= r; l++, r--) {
			if (str.charAt(l) != str.charAt(r)) {
				return false;
			}
		}
		return true;
	}
}
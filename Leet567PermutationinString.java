package B07_11;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of
 * s1. In other words, one of the first string's permutations is the substring of the second string.
 * 
 * Example 1:
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * Note:
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class Leet567PermutationinString {
	/**
	 * map (Character -> Count) abba ->{a:2, b:2}. lower case letters-->array to represent the map.
	 * sliding window with length of s1,
	 * When a character moves in from right of the window,
	 * we subtract 1 to that character count from the map.
	 * When a character moves out from left of the window, we add 1 to that character count.
	 * So once we see all zeros in the map, meaning equal numbers of every characters between s1 and
	 * the substring in the sliding window, we know the answer is true.
	 */
	public boolean checkInclusion(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if (len1 > len2)
			return false;

		int[] count = new int[26];
		for (int i = 0; i < len1; i++) {
			count[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < len2; i++) {
			count[s2.charAt(i) - 'a']--;
			if (i - len1 >= 0)
				count[s2.charAt(i - len1) - 'a']++;
			if (allZero(count))
				return true;
		}

		return false;
	}

	private boolean allZero(int[] count) {
		for (int i = 0; i < 26; i++) {
			if (count[i] != 0)
				return false;
		}
		return true;
	}
}
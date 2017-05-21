package B04_06;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 **/
public class Leet005LongestPalindromicSubstring {
		/**
		 * private lo maxlen, share!
		 * i,i-->odd， i,i+1-->even
		 * update lo and maxlen
		 * len = end - start +1
		 * len = (k-1) - (j+1) + 1 = k-j-1
		 */

		private int lo, maxLen;

		public String longestPalindrome(String s) {
				int len = s.length();
				if (len < 2) {
						return s;
				}
				for (int i = 0; i < len; i++) {
						findPali(s, i, i);
						findPali(s, i, i + 1);
				}
				// string not String
				return s.substring(lo, lo + maxLen);
		}

		public void findPali(String s, int j, int k) {
				// debug while not if!!!!!!!
				while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
						j--;
						k++;
				}
				// (k-1) - (j+1) + 1 = k-j-1
				if (maxLen < k - j - 1) {
						lo = j + 1;
						maxLen = k - j - 1;
				}
		}

}

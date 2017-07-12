package B07_11;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to
 * word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class Leet072EditDistance {
	/**
	 * add 1 since null null is 00
	 * dp[i+1][j+1] to be the min operations to convert word1[0..i] to word2[0..j]
	 * 
	 * Boundary case: convert a string to an empty string(null)
	 * dp[i][0] = i;
	 * dp[0][j] = j.
	 * 
	 * 1.Replace word1[i] by word2[j]
	 * dp[i+1][j+1] = dp[i][j] + 1
	 * 2.Delete word1[i] and word1[0..i - 1] = word2[0..j]
	 * dp[i+1][j+1] = dp[i][j+1] + 1
	 * 3.Insert word2[j] to word1[0..i] and word1[0..i] + word2[j] = word2[0..j]
	 * dp[i+1][j+1] = dp[i+1][j] + 1
	 */

	public int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 1; i <= len1; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j <= len2; j++) {
			dp[0][j] = j;
		}

		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (word1.charAt(i) == word2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					dp[i + 1][j + 1] = Math.min(dp[i][j] + 1, Math.min(dp[i + 1][j] + 1, dp[i][j + 1] + 1));
				}
			}
		}
		return dp[len1][len2];

	}
}

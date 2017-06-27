package B06_02;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the !!!preceding!!! element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class Leet010RegularExpressionMatching {
	/**
	 * dp[i+1][j+1] means if s[0...i] match p[0...j]
	 * 
	 * 1. If p.charAt(j) == s.charAt(i) : dp[i+1][j+1] = dp[i][j];
	 * 2. If p.charAt(j) == '.' : dp[i+1][j+1] = dp[i][j];
	 * 
	 * 3. If p.charAt(j) == '*':
	 * here are two sub conditions:
	 * 3-1. if p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'
	 * dp[i+1][j+1] = dp[i+1][j-1] //in this case, a* only counts as empty
	 * 
	 * 3-2. if p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.':
	 * dp[i+1][j+1] = dp[i+1][j-1] // * counts as empty
	 * dp[i+1][j+1] = dp[i+1][j] // * counts as single a
	 * dp[i+1][j+1] = dp[i][j+1] //* counts as multiple a !!!!
	 * 
	 * s: a b b
	 * p: a b *
	 */
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		// null to null
		dp[0][0] = true;
		/**
		 * S: []
		 * P: _ A * b * c
		 * dp T F T F T F
		 * at this moment * counts as empty since s is null
		 */
		for (int j = 1; j < p.length(); j++) {
			// i-1
			if (p.charAt(j) == '*' && dp[0][j - 1]) {
				// i+1
				dp[0][j + 1] = true;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == '.') {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == s.charAt(i)) {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else {
						dp[i + 1][j + 1] = (dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1]);
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
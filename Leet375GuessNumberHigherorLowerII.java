package B07_06;

/**
 * We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * 
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game
 * when you guess the number I picked.
 * 
 * Example:
 * 
 * n = 10, I pick 8.
 * 
 * First round: You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round: You guess 9, I tell you that it's lower. You pay $9.
 * 
 * Game over. 8 is the number I picked.
 * 
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class Leet375GuessNumberHigherorLowerII {
	/**
	 * dp[i][j]: minimum number of money to guarantee win for subproblem [i, j].
	 * Equation: we can choose k (i<=k<=j) as our guess, and pay price k.
	 * After our guess, the problem is divided into two subproblems.
	 * Notice we do not need to pay the money for both subproblems. We only need to pay the worst
	 * case (because the system will tell us which side we should go) to guarantee win.
	 * So dp[i][j] = min (i<=k<=j) { k + max(dp[i][k-1], dp[k+1][j])
	 * }
	 */
	public int getMoneyAmount(int n) {
		if (n == 1)
			return 0;
		int[][] dp = new int[n + 1][n + 1];
		for (int len = 1; len < n; len++) {
			for (int from = 1; from <= n - len; from++) {
				int to = from + len;
				int ans = Integer.MAX_VALUE;
				// ??? right half
				for (int k = from + (len >> 1); k < to; k++) {
					ans = Math.min(ans, k + Math.max(dp[from][k - 1], dp[k + 1][to]));
				}
				dp[from][to] = ans;
			}
		}
		return dp[1][n];
	}

	public int getMoneyAmount2(int n) {
		int[][] dp = new int[n + 1][n + 1];
		return guessHelper(1, n, dp);
	}

	private int guessHelper(int start, int end, int[][] dp) {
		if (start >= end) {
			return 0;
		}
		// 3numbers--mid; 2numbers--start
		if (end - start <= 2) {
			return end - 1;
		}

		if (dp[start][end] > 0) {
			return dp[start][end];
		}

		int mid = start + (end - start) / 2;
		int minimax = Integer.MAX_VALUE;
		// right half???
		for (int i = mid; i < end; i++) {
			int left = guessHelper(start, i - 1, dp);
			int right = guessHelper(i + 1, end, dp);
			minimax = Math.min(minimax, i + Math.max(left, right));
			if (left >= right) {
				break;
			}
		}
		dp[start][end] = minimax;
		return minimax;
	}
}
package B04_05;

import java.util.Arrays;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * Note: Given n will be a positive integer.
 **/
public class Leet070ClimbingStairs {

	/**
	 * update 06-16,
	 * Method1--from top to bottom, recursion with memo!
	 */
	private int[]	res;

	public int climbStairs(int n) {
		res = new int[n + 1];
		// -1 to check if update
		Arrays.fill(res, -1);
		return helper(n);
	}

	public int helper(int n) {
		// base case
		if (n == 1 || n == 2) {
			return n; // dp[1] = 1, dp[2] =2
		}
		// return directly if it has been updated
		if (res[n] != -1) {
			return res[n];
		}
		res[n] = helper(n - 1) + helper(n - 2);
		return res[n];
	}

	/**
	 * Method2: Dynamic Programming
	 * From bottom to up
	 */
	public int climbStairs2(int n) {
		int[] res = new int[n + 1];
		res[1] = 1;
		res[2] = 2;
		// form bottom to up
		for (int i = 3; i < n + 1; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}
		return res[n];
	}

	/** Method3: recursion: TLE **/
	public int climbStairs1(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return climbStairs1(n - 1) + climbStairs1(n - 2);
	}
}

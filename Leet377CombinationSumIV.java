package B06_08;

import java.util.Arrays;

/**
 * Given an integer array with all positive numbers and no duplicates, find the
 * number of possible combinations that add up to a positive integer target.
 * 
 * Example:
 * 
 * nums = [1, 2, 3]
 * target = 4
 * 
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 
 * Note that different sequences are counted as different combinations.
 * 
 * Therefore the output is 7.
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */
public class Leet377CombinationSumIV {
	/**
	 * Method: dfs with memo
	 * -1 means not update!!! cannot use 0 since some target may cannnot find so return 0
	 * nums = [1, 2, 3]
	 * target = 4
	 * comb[4] = comb[4-1] + comb[4-2] + comb[4-3] = comb[3] + comb[2] + comb[1]
	 * res += dfs(nums, memo, target - nums[i]);
	 */
	public int combinationSum4(int[] nums, int target) {
		int[] memo = new int[target + 1];
		// !!!!-1
		Arrays.fill(memo, -1);
		int res = dfs(nums, memo, target);
		return res;

	}

	public int dfs(int[] nums, int[] memo, int target) {
		if (memo[target] != -1) {
			return memo[target];
		}
		/*
		 * since target >= nums[i] in last round
		 * if (target < 0) {
		 * return 0;
		 * }
		 */
		if (target == 0) {
			return 1;
		}
		int res = 0;
		// all from 0
		for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i]) {
				res += dfs(nums, memo, target - nums[i]);
			}
		}
		// if cannot find any res = 0, memo[target] = 0
		memo[target] = res;
		return res;
	}
}

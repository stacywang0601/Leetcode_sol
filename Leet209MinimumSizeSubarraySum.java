package B05_21;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a
 * contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class Leet209MinimumSizeSubarraySum {
			/*
			 * Since the given array contains only positive integers, the subarray sum can only increase
			 * by including more elements. Therefore, you don't have to include more elements once the
			 * current subarray already has a sum large enough. This gives the linear time complexity
			 * solution by maintaining a minimum window with a two indices.
			 */
			public int minSubArrayLen(int s, int[] nums) {
						int sum = 0, from = 0, win = Integer.MAX_VALUE;
						for (int i = 0; i < nums.length; i++) {
									sum += nums[i];
									while (sum >= s) {
												win = Math.min(win, i - from + 1);
												sum -= nums[from];
												from++;
									}
						}
						return win == Integer.MAX_VALUE ? 0 : win;

			}
}

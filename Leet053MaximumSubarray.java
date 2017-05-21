package B05_21;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the
 * largest sum. For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6. More practice: If you have figured out the O(n) solution, try
 * coding another solution using the divide and conquer approach, which is more subtle.
 */

public class Leet053MaximumSubarray {
			/*
			 * Method1 DP:
			 * sub problem: maxSubArray(int A[], int i), which means the maxSubArray for
			 * A[0:i] which must has A[i] as the end element.
			 */
			public int maxSubArray(int[] nums) {
						int[] dp = new int[nums.length];
						// dp[i] means the maximum subarray ending with A[i];
						dp[0] = nums[0];
						int max = dp[0];

						for (int i = 1; i < nums.length; i++) {
									dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
									max = Math.max(max, dp[i]);
						}
						return max;
			}

			/*
			 * Method2 local and global:
			 * maxEndhere tracks max locally
			 * maxSofar tracks max globally
			 * The key point is reset when the maxEndhere is negative
			 */
			public int maxSubArray2(int[] nums) {
						int maxSofar = nums[0];
						int maxEndhere = nums[0];

						for (int i = 1; i < nums.length; i++) {
									maxEndhere = Math.max(maxEndhere + nums[i], nums[i]);
									maxSofar = Math.max(maxSofar, maxEndhere);
						}
						return maxSofar;
			}

}

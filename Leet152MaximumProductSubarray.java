package B05_21;

/**
 * Find the contiguous subarray within an array (containing at least one
 * number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class Leet152MaximumProductSubarray {
			/*
			 * Each time remember the max and min value for the previous product, the most important thing
			 * is to update the max and min value: we have to compare among max * A[i], min * A[i] as well
			 * as A[i]!!! since this is product, a negative * negative could be positive.
			 */
			public int maxProduct(int[] nums) {
						int maxPro = nums[0];
						int minPro = nums[0];
						int max = nums[0];

						for (int i = 1; i < nums.length; i++) {
									int temp = maxPro;
									maxPro = Math.max(Math.max(maxPro * nums[i], minPro * nums[i]), nums[i]);
									minPro = Math.min(Math.min(temp * nums[i], minPro * nums[i]), nums[i]);
									max = Math.max(max, maxPro);
						}
						return max;

			}
}

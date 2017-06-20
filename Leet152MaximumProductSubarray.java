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
						//from nums[0], not Integer.MIN_VALUE
						int maxPro = nums[0];
						int minPro = nums[0];
						int max = nums[0];
						
						//from 1
						for (int i = 1; i < nums.length; i++) {
									//save maxPro
									int temp = maxPro;
									//need to compare with nums[i] to update to nums[i] when nums[i-1] =0
									//eg {1,0,9,2} after num[1] maxPro = minPro =0;
									maxPro = Math.max(Math.max(maxPro * nums[i], minPro * nums[i]), nums[i]);
									minPro = Math.min(Math.min(temp * nums[i], minPro * nums[i]), nums[i]);
									//so far!
									max = Math.max(max, maxPro);
						}
						return max;

			}
}

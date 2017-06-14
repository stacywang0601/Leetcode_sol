package B06_13;

import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its
 * sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed
 * integer range.
 */
public class Leet164MaximumGap {
	/**
	 * n elements, maximum gap will be no smaller than ceiling[(max - min ) / (n - 1)].
	 * 
	 * [if buckets smaller or equal to gap, any gaps within the same bucket is not the
	 * amount we are looking for, so we are safe to look only for the inter-bucket gaps]
	 * 
	 * Let gap = ceiling[(max - min ) / (n - 1)] and n-1 buckets,
	 * where kth bucket contains all numbers in [min + (k-1)gap, min + k*gap).
	 * Since there are n-2 numbers that are not equal min or max and there are n-1 buckets,
	 * At least one of the buckets are empty.
	 * Store the largest number and the smallest number in each bucket.
	 * 
	 * Put all the numbers into the buckets.
	 * Scan the buckets sequentially and get the max inner-bucket gap
	 */
	public int maximumGap(int[] num) {
		if (num == null || num.length < 2)
			return 0;
		// get the max and min value of the array
		int min = num[0];
		int max = num[0];
		for (int i : num) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		// the minimum possible gap, ceiling of the integer division
		int gap = (int) Math.ceil((double) (max - min) / (num.length - 1));
		int[] bucketsMIN = new int[num.length - 1]; // store the min value in that bucket
		int[] bucketsMAX = new int[num.length - 1]; // store the max value in that bucket
		Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
		Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
		// put numbers into buckets
		for (int i : num) {
			if (i == min || i == max)
				continue;
			int idx = (i - min) / gap; // index of the right position in the buckets
			bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
			bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
		}
		// scan the buckets for the max gap
		int maxGap = Integer.MIN_VALUE;
		int previous = min;
		for (int i = 0; i < num.length - 1; i++) {
			if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
				// empty bucket
				continue;
			// min value minus the previous value is the current gap
			maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
			// update previous bucket value
			previous = bucketsMAX[i];
		}
		maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
		return maxGap;
	}
}
package B05_26;

// @Author : Stacy Wang
/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class Leet042TrappingRainWater {
	/**
	 * Method1: 2 int arrays and 3 traverses
	 * Time: O(n), Space:O(n)
	 * left[i]: the max height of [0,i]
	 * right[i]:the max height of[i, len-1]
	 * the bar could trap water (Math.min(left[i], right[i]) - height[i])* width(here is 1)
	 */
	public static int trap(int[] height) {
		int len = height.length;
		int[] left = new int[len];
		int[] right = new int[len];

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			left[i] = Math.max(height[i], max);
			max = left[i];
		}
		max = Integer.MIN_VALUE;
		for (int i = len - 1; i >= 0; i--) {
			right[i] = Math.max(height[i], max);
			max = right[i];
		}
		int total = 0;
		for (int i = 0; i < len; i++) {
			int temp = Math.min(left[i], right[i]) - height[i];
			total += temp;
		}
		return total;

	}

	/**
	 * Update:simiular to candy problem
	 * Date :2017-06-12
	 * remove max variable,update left[i] based on left[i-1],right[i] based on right[i+1]
	 */
	public int trap2(int[] height) {
		int len = height.length;
		int[] left = new int[len];
		int[] right = new int[len];
		if (height == null || height.length == 0) {
			return 0;
		}

		left[0] = height[0];
		for (int i = 1; i < len; i++) {
			left[i] = Math.max(height[i], left[i - 1]);
		}

		right[len - 1] = height[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			right[i] = Math.max(height[i], right[i + 1]);
		}

		int total = 0;
		for (int i = 0; i < len; i++) {
			int temp = Math.min(left[i], right[i]) - height[i];
			total += temp;
		}
		return total;

	}

}

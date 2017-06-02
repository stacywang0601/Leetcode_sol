package B06_02;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar
 * is 1, find the area of largest rectangle in the histogram.
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 */

import java.util.Stack;

public class Leet084LargestRectangleinHistogram {
	/**
	 * use a stack to track the first smaller left side,
	 * the right side when it decrease
	 * FOR i = 2 the max is 5 * (4 - 1 - 1)= 10。
	 * FOR i = 3 the max is 6 * (4 - 2 - 1) = 6。
	 */
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i <= height.length; i++) {
			// last
			int curt = (i == height.length) ? -1 : height[i];
			// when less than top, calculate
			while (!stack.isEmpty() && curt <= height[stack.peek()]) {
				int h = height[stack.pop()];
				// peek() is pop() - 1
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, h * w);
			}
			stack.push(i);
		}

		return max;

	}
}
package B05_26;

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
	 * Method2: 2 pointers
	 * Time: O(n), Space:O(1)
	 * if(leftmax<rightmax) then, at least (leftmax-A[a]) water can definitely be stored no matter
	 * what happens between [a,b] since there is a barrier at the rightside
	 * */

	public int trap2(int[] A) {
		int n = A.length;
		int left = 0;
		int right = n - 1;
		int res = 0;
		int maxleft = 0, maxright = 0;
		while (left <= right) {
			if (A[left] <= A[right]) {
				// increasing : update max
				if (A[left] >= maxleft)
					maxleft = A[left];
				else
					// decreasing add to res
					res += maxleft - A[left];
				left++;
			} else {
				if (A[right] >= maxright)
					maxright = A[right];
				else
					res += maxright - A[right];
				right--;
			}
		}
		return res;

	}

	public static void main(String[] args) {
		int[] A = { 2, 0, 2 };
		System.out.print(trap(A));

	}

}

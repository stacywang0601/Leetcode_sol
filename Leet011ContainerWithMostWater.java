package B06_08;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 */
public class Leet011ContainerWithMostWater {
	/**
	 * Set two pointers at both ends of the array.
	 * Every time move the smaller value pointer to inner array.
	 * When two pointers meet, all possible max cases have been
	 * scanned and the max situation is 100% reached somewhere in the scan
	 */
	public int maxArea(int[] height) {
		int len = height.length;
		int max = 0;
		int l = 0;
		int r = len - 1;
		while (l < r) {
			max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return max;
	}
}

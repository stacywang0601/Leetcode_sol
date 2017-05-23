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
	 * Method1: O(n) SMALL WINDOW
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

	/*
	 * Method2: O(nlogn), sum[] + binary search
	 * How does one get an ordered array then? Since all elements are positive, the cumulative sum
	 * must be strictly increasing. Then, a subarray sum can expressed as the difference between
	 * two cumulative sum. Hence, given a start index for the cumulative sum array, the other end
	 * index can be searched using binary search.
	 */
	public int minSubArrayLen2(int s, int[] nums) {
		int m = nums.length + 1;
		int[] sum = new int[m];
		sum[0] = 0;
		int minLen = Integer.MAX_VALUE;
		for (int i = 1; i < m; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
		}

		for (int i = 0; i < m; i++) {
			// from i
			int end = greaterOrEqual(i, m - 1, sum, s + sum[i]);
			// break!!! since increasing so the number after this i won't find any result either
			if (end == -1)
				break;
			minLen = Math.min(minLen, end - i);
		}
		// check if no update at all
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	private int greaterOrEqual(int l, int h, int[] num, int k) {

		while (l < h) {
			int m = (l + h) / 2;
			if (num[m] >= k) {
				h = m;
			} else {
				l = m + 1;
			}
		}

		return (num[l] >= k) ? l : -1;
	}
}

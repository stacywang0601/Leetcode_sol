package B07_12;

/**
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 * 
 * You need to return the number of important reverse pairs in the given array.
 * 
 * Example1:
 * 
 * Input: [1,3,2,3,1]
 * Output: 2
 * Example2:
 * 
 * Input: [2,4,3,5,1]
 * Output: 3
 * Note:
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 */
public class Leet493ReversePairs {
	/** merge sort same as 327 */
	int	count	= 0;

	public int reversePairs(int[] nums) {
		int[] helper = new int[nums.length];
		mergesort(nums, helper, 0, nums.length - 1);
		return count;
	}

	private void mergesort(int[] nums, int[] helper, int low, int high) {
		// recursive: low<high
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergesort(nums, helper, low, mid);
			mergesort(nums, helper, mid + 1, high);
			merge(nums, helper, low, mid, high);
		}
	}

	private void merge(int[] nums, int[] helper, int low, int mid, int high) {
		int right = mid + 1;
		int cur = low;
		int left = low;
		// right side
		int k = mid + 1;
		int j = mid + 1;

		for (left = low; left <= mid; left++) {
			while (k <= high && nums[left] > 2L * nums[k]) {
				k++;
			}
			count += k - (mid + 1);
			// find num in the right side less than this num,
			// copy them to helper in correct order
			while (right <= high && nums[right] < nums[left]) {
				helper[cur++] = nums[right++];
			}
			// also copy this num
			helper[cur++] = nums[left];
		}
		for (int i = low; i < right; i++) {
			nums[i] = helper[i];
		}
	}
}
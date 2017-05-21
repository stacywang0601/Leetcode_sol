package B05_21;

/**
 * Given an integer array nums, return the number of range sums that lie in
 * [lower, upper] inclusive. Range sum S(i, j) is defined as the sum of the
 * elements in nums between indices i and j (i ≤ j), inclusive.
 * 
 * Note: A naive algorithm of O(n2) is trivial. You MUST do better than that.
 * 
 * Example: Given nums = [-2, 5, -1], lower = -2, upper = 2, Return 3. The three
 * ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 */
public class Leet327CountofRangeSum {
		/**
		 * Sum[i] = Sum(0, i) The merge sort based solution counts the answer
		 * while doing the merge. During the merge stage, we have already
		 * sorted the left half [start, mid) and right half [mid, end)
		 * 
		 * in the [left half] find index left.
		 * in the [right half] find two indices k and j
		 * 
		 * j is the first index satisfy sums[j] - sums[left] > upper k is the
		 * first index satisfy sums[k] - sums[left] >= lower Then the number
		 * of sums in [lower, upper] is j-k. We also use another index cur to
		 * copy the elements to a helper in order to complete the merge sort.
		 */
		// share global variable
		int count = 0;
		int lower;
		int upper;

		public int countRangeSum(int[] nums, int lower, int upper) {
				long[] sum = new long[nums.length + 1];
				long[] helper = new long[nums.length + 1];
				sum[0] = 0;
				this.lower = lower;
				this.upper = upper;
				// debug <=!!!
				for (int i = 1; i <= nums.length; i++) {
						sum[i] = sum[i - 1] + nums[i - 1];
				}
				mergesort(sum, helper, 0, sum.length - 1);
				return count;
		}

		private void mergesort(long[] sum, long[] helper, int low, int high) {
				// recursive: low<high
				if (low < high) {
						int mid = (low + high) / 2;
						mergesort(sum, helper, low, mid);
						// mid+1
						mergesort(sum, helper, mid + 1, high);
						merge(sum, helper, low, mid, high);
				}
		}

		private void merge(long[] sum, long[] helper, int low, int mid, int high) {
				int right = mid + 1;
				int cur = low;
				int left = low;
				// right side
				int k = mid + 1;
				int j = mid + 1;

				// <=
				for (left = low; left <= mid; left++) {
						// <=
						while (k <= high && sum[k] - sum[left] < lower)
								k++;
						while (j <= high && sum[j] - sum[left] <= upper)
								j++;
						// find num in the right side less than this num,
						// copy them to helper in right order
						while (right <= high && sum[right] < sum[left]) {
								helper[cur++] = sum[right++];
						}
						// also copy this num
						helper[cur++] = sum[left];
						count += j - k;
				}
				// copy number left to helper
				while (right <= high) {
						helper[cur++] = sum[right++];
				}
				// copu back to sum
				for (int i = low; i <= high; i++) {
						sum[i] = helper[i];
				}

		}
}

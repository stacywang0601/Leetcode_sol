package B07_06;

/**
 * Given an array which consists of non-negative integers and an integer m, you can split the array
 * into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these
 * m subarrays.
 * 
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * 
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples:
 * 
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * 
 * Output:
 * 18
 * 
 * Explanation:
 * There are four ways to split nums into two sub-arrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two sub-arrays is only 18.
 */
public class Leet410SplitArrayLargestSum {
	/**
	 * Binary search
	 * l = max number of array;
	 * r = sum of all numbers in the array;
	 * Every time we do mid = (l + r) / 2;
	 * 
	 * For example, given array A [1, 2, 3, 4, 5]. 2 cuts
	 * the range of the possible value of the Largest sum of sub-arrays is [5, 15].
	 * Two results: divide the array into more than m sub-arrays(invlid) or not(valid)
	 * If invalid, the mid is too small--> l = mid + 1;
	 * If valid, it is either we successfully divide the array into m parts and the sum of each
	 * part is less than mid, or we used up all numbers before we reach m. Both of them mean that we
	 * should lower mid because we need to find the minimum one. This leads to r = mid - 1;
	 **/
	public int splitArray(int[] nums, int m) {
		int max = 0;
		long sum = 0;
		for (int num : nums) {
			max = Math.max(num, max);
			sum += num;
		}
		if (m == 1)
			return (int) sum;
		// binary search
		long l = max;
		long r = sum;
		while (l <= r) {
			long mid = (l + r) / 2;
			if (valid(mid, nums, m)) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return (int) l;
	}

	public boolean valid(long target, int[] nums, int m) {
		int count = 1;
		long total = 0;
		for (int num : nums) {
			total += num;
			if (total > target) {
				total = num;
				count++;
				if (count > m) {
					return false;
				}
			}
		}
		return true;
	}

}
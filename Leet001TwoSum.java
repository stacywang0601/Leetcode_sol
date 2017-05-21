package B11_09;

import java.util.Arrays;
/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
import java.util.HashMap;

public class leet001TwoSum {
		/** Method1 -- hashmap  */
		public int[] twoSum1(int[] nums, int target) {
				HashMap<Integer, Integer> hm = new HashMap<>();
				int[] res = new int[2];
				for (int i = 0; i < nums.length; i++) {
						int x = nums[i];
						if (hm.containsKey(target - x)) {
								res[0] = hm.get(target - x);
								res[1] = i;
								return res;
						}
						// !if not contains key,just put into map
						hm.put(x, i);
				}
				return res;
		}

		/** Method2--sort and two pointers */
		public int[] twoSum2(int[] nums, int target) {
				int N = nums.length;
				int[] sorted = new int[N];
				// last para is length
				System.arraycopy(nums, 0, sorted, 0, N);
				Arrays.sort(sorted);
				int begin = 0;
				int end = N - 1;

				while (begin < end) {
						// continue
						if (sorted[begin] + sorted[end] < target) {
								begin++;
								continue;
						} else if (sorted[begin] + sorted[end] > target) {
								end--;
								continue;
						} else {
								// when equals break
								break;
						}
				}
				int num1 = sorted[begin];
				int num2 = sorted[end];
				// to check
				int[] res = { -1, -1 };
				// find index
				for (int i = 0; i < N; i++) {
						if (nums[i] == num1 || nums[i] == num2) {
								if (res[0] == -1) {
										res[0] = i;
								} else {
										res[1] = i;
								}
						}
				}
				return res;
		}

}

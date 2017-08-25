package B08_25;

import java.util.HashMap;
import java.util.Map;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one
 * of the numbers in the set got duplicated to another number in the set, which results in
 * repetition of one number and loss of another number.
 * 
 * Given an array nums representing the data status of this set after the error. Your task is to
 * firstly find the number occurs twice and then find the number that is missing. Return them in the
 * form of an array.
 * 
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 */
class Leet645SetMismatch {
	/**
	 * Method1: map
	 * Time: O(n). Space O(n)
	 * */
	public int[] findErrorNums(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int dup = -1, missing = 1;
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		for (int i = 1; i <= nums.length; i++) {
			if (map.containsKey(i)) {
				if (map.get(i) == 2)
					dup = i;
			} else
				missing = i;
		}
		return new int[] { dup, missing };
	}

	/**
	 * Method2: nums array are positive, and lie in the range 1 to n only
	 * index = Math.abs(i) - 1
	 * Time: O(n). Space O(1)
	 */
	public static int[] findErrorNums2(int[] nums) {
		int[] res = new int[2];
		for (int i : nums) {
			if (nums[Math.abs(i) - 1] < 0)
				res[0] = Math.abs(i);
			else
				nums[Math.abs(i) - 1] *= -1;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				res[1] = i + 1;
		}
		return res;
	}
}
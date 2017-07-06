package B07_06;

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
import java.util.Map;

public class Leet001TwoSum {

	public int[] twoSum1(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = map.get(target - nums[i]);
				res[1] = i;
				break;
			}
			// !if not contains key,just put into map
			map.put(nums[i], i);
		}
		return res;
	}
}
package B01_25;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤
 * c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet015ThreeSum {
	/**
	 * sort
	 * two pointers
	 * de-duplicate
	 * */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				if (nums[start] + nums[end] < -nums[i]) {
					start++;
				} else if (nums[start] + nums[end] > -nums[i]) {
					end--;
				} else {
					res.add(Arrays.asList(nums[i], nums[start], nums[end]));
					// update
					start++;
					end--;
					// deduplicate again start < end
					while (start < end && nums[end] == nums[end + 1]) {
						end--;
					}
					while (start < end && nums[start] == nums[start - 1]) {
						start++;
					}
				}
			}
		}
		return res;
	}

}

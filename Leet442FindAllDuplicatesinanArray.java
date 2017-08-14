package B08_14;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 */
import java.util.ArrayList;
import java.util.List;

public class Leet442FindAllDuplicatesinanArray {
	/** O(1) space */
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums == null)
			return result;
		for (int i = 0; i < nums.length; i++) {
			int location = Math.abs(nums[i]) - 1;
			if (nums[location] < 0) {
				result.add(Math.abs(nums[i]));
			} else {
				nums[location] = -nums[location];
			}
		}
		// restore the nums
		for (int i = 0; i < nums.length; i++)
			nums[i] = Math.abs(nums[i]);

		return result;
	}

	/** O(n) space */
	public List<Integer> findDuplicates2(int[] nums) {

		boolean[] arr = new boolean[nums.length + 1];
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {

			if (!arr[nums[i]]) {
				arr[nums[i]] = true;
			} else {
				list.add(nums[i]);
			}
		}

		return list;

	}
}
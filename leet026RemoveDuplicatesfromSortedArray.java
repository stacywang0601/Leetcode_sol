package B08_10;

import java.util.HashSet;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length. Do not allocate extra space for
 * another array, you must do this in place with constant memory. For example:
 * Given input array A = [1,1,2], Your function should return length = 2, and A
 * is now [1,2].
 */
public class leet026RemoveDuplicatesfromSortedArray {
	/**
	 * Method1-- new pointer count
	 * since sorted, only check it same as last one
	 **/
	public int removeDuplicates1(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1])
				nums[count++] = nums[i];
		}
		return count;
	}

	/** Method2--hashset */
	public int removeDuplicates2(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i])) {
				set.add(nums[i]);
				nums[count++] = nums[i];
			}
		}
		return count;
	}
}

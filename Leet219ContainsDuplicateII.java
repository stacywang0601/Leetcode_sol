package B06_17;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i
 * and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at
 * most k.
 **/
public class Leet219ContainsDuplicateII {
	/**
	 * It iterates over the array using a sliding window.
	 * The front of the window is at i, the rear of the window is k steps back.
	 * The elements within that window are maintained using a set.
	 * While adding new element to the set, if add() returns false, it means the element already
	 * exists in the set. At that point, we return true. If the control reaches out of for loop, it
	 * means that inner return true never executed, meaning no such duplicate element was found.
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k)
				set.remove(nums[i - k - 1]);
			if (!set.add(nums[i]))
				return true;
		}
		return false;
	}
}
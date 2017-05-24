package B05_24;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is
 * only one duplicate number, find the duplicate one.
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated
 * more than once.
 */
public class Leet287FindtheDuplicateNumber {
	/**
	 * Method1: Two pointers O(n)
	 * The constraint in the problem "each integer is between 1 and n (inclusive)"
	 * makes the array an abstracted linked list: n[x] -> y. Now since integer cannot
	 * be 0, item 0 is guarenteed to be a "node" outside any cycle because n[x] must be
	 * larger than 0.
	 * Like leet142 Linked List Cycle II
	 */

	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;
		// do while since slow =fast at the beginning
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}

	/**
	 * Method2:Binary Search O(nlogn)
	 * range [1,n], m = (l + h) /2, count all the numbers equal to or less than mid.
	 * if count is less than or equal to mid, the search space will be [mid+1 n].
	 * otherwise [1 mid]
	 */
	public int findDuplicate2(int[] nums) {
		int l = 0, h = nums.length - 1;
		while (l < h) {
			int m = (l + h) / 2;
			// m not nums[m]
			int count = getCount(nums, m);
			// not only one duplicate number, so maybe less than
			if (count <= m) {
				l = m + 1;
			} else {
				h = m;
			}
		}
		return l;

	}

	private int getCount(int[] nums, int key) {
		int count = 0;
		for (int n : nums) {
			if (n <= key) {
				count++;
			}
		}
		return count;
	}

}

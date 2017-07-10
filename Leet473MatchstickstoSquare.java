package B07_10;

/**
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little
 * match girl has, please find out a way you can make one square by using up all those matchsticks.
 * You should not break any stick, but you can link them up, and each matchstick must be used
 * exactly
 * one time.
 * 
 * Your input will be several matchsticks the girl has, represented with their stick length. Your
 * output will either be true or false, to represent whether you could make one square using all the
 * matchsticks the little match girl has.
 * 
 * Example 1:
 * Input: [1,1,2,2,2]
 * Output: true
 * 
 * Explanation: You can form a square with length 2, one side of the square came two sticks with
 * length 1.
 * Example 2:
 * Input: [3,3,3,3,4]
 * Output: false
 * 
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * Note:
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * The length of the given matchstick array will not exceed 15.
 */
import java.util.Arrays;
import java.util.HashSet;

public class Leet473MatchstickstoSquare {
	/**
	 * DFS
	 * Sorting: DESC
	 * If no solution, trying a longer matchstick first will get to negative conclusion earlier.
	 * HashSet track target : in case repeated search
	 * visited[] use -num[i]
	 * */
	public boolean makesquare(int[] nums) {
		if (nums == null || nums.length < 4)
			return false;
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		if (sum % 4 != 0)
			return false;
		int target = sum / 4;
		Arrays.sort(nums);

		if (nums[(nums.length - 1)] > target)
			return false;

		for (int i = 0; i < 3; i++) {
			if (!match(nums, nums.length - 1, target, new HashSet<>()))
				return false;
		}
		return true;
	}

	private boolean match(int[] nums, int i, int target, HashSet<Integer> set) {

		if (set.contains(target) || i < 0)
			return false;

		if (target == 0)
			return true;

		if (nums[i] > 0 && nums[i] <= target) {
			nums[i] = -nums[i];
			if (match(nums, i - 1, target + nums[i], set))
				return true;
			nums[i] = -nums[i];
		}
		if (match(nums, i - 1, target, set))
			return true;
		set.add(target);
		return false;

	}
}
package B08_12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements
 * sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 */
public class Leet128LongestConsecutiveSequence {
	/**
	 * map O(n)
	 * See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence
	 * next to n. Variables left and right will be the length of those two sequences, while 0 means
	 * there is no sequence and n will be the boundary point later. Store (left + right + 1) as the
	 * associated value to key n into the map.
	 * Use left and right to locate the other end of the sequences to the left and right of n
	 * respectively, and replace the value with the new length.
	 */
	public int longestConsecutive(int[] num) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int n : num) {
			if (!map.containsKey(n)) {
				int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
				int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
				// sum: length of the sequence n is in
				int sum = left + right + 1;
				map.put(n, sum);

				// keep track of the max length
				res = Math.max(res, sum);

				// extend the length to the boundary(s)
				// of the sequence
				// will do nothing if n has no neighbors
				map.put(n - left, sum);
				map.put(n + right, sum);
			} else {
				// duplicates
				continue;
			}
		}
		return res;
	}

	/** sort O(nlogn) */
	public int longestConsecutive2(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int max = 1, tp = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] + 1 == nums[i + 1]) {
				tp++;
				max = Math.max(max, tp);
			} else if (nums[i] == nums[i + 1]) {
				continue;
			} else {
				tp = 1;
			}
		}
		return max;
	}
}
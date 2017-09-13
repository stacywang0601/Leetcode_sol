package B09_13;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the
 * second number.
 * 
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs
 * can be formed in this fashion.
 * 
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all
 * the given pairs. You can select pairs in any order.
 * 
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 **/
class Leet646MaximumLengthofPairChain {
	public int findLongestChain(int[][] pairs) {
		if (pairs == null || pairs.length == 0)
			return 0;
		Arrays.sort(pairs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});

		int curEnd = pairs[0][1];
		int count = 1;
		for (int[] pair : pairs) {
			if (pair[0] > curEnd) {
				count++;
				curEnd = pair[1];
			}
		}

		return count;

	}
}
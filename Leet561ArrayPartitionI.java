package B07_21;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say
 * (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large
 * as possible.
 * 
 * Example 1:
 * Input: [1,4,3,2]
 * 
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 */
import java.util.Arrays;

public class Leet561ArrayPartitionI {
	/**
	 * Assume in each pair i, bi >= ai.
	 * Denote Sm = min(a1, b1) + min(a2, b2) + ... + min(an, bn). The biggest Sm is the answer of
	 * this problem. Given 1, Sm = a1 + a2 + ... + an.
	 * Denote Sa = a1 + b1 + a2 + b2 + ... + an + bn. Sa is constant for a given input.
	 * Denote di = |ai - bi|. Given 1, di = bi - ai. Denote Sd = d1 + d2 + ... + dn.
	 * So Sa = a1 + a1 + d1 + a2 + a2 + d2 + ... + an + an + di = 2Sm + Sd => Sm = (Sa - Sd) / 2. To
	 * get the max Sm, given Sa is constant, we need to make Sd as small as possible.
	 * So this problem becomes finding pairs in an array that makes sum of di (distance between ai
	 * and bi) as small as possible. Apparently, sum of these distances of adjacent elements is the
	 * smallest. If that's not intuitive enough, see attached picture. Case 1 has the smallest Sd.
	 **/
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int result = 0;
		for (int i = 0; i < nums.length; i += 2) {
			result += nums[i];
		}
		return result;
	}

}
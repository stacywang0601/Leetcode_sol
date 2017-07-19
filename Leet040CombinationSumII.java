package B07_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * !!!Each number in C may only be used once in the combination.
 * Note:All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class Leet040CombinationSumII {
	public static List<List<Integer>> combinationSum2(int[] c, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (c == null || c.length == 0) {
			return res;
		}
		Arrays.sort(c);
		dfs(c, 0, target, new ArrayList<Integer>(), res);
		return res;

	}

	public static void dfs(int[] c, int start, int target, ArrayList<Integer> item, List<List<Integer>> res) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for (int i = start; i < c.length; i++) {
			/**
			 * delete duplicate
			 **/
			if (i > start && c[i] == c[i - 1]) {
				continue;
			}
			item.add(c[i]);
			dfs(c, i + 1, target - c[i], item, res);
			item.remove(item.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] c = { 1, 2, 7, 6, 1 };
		int t = 4;
		combinationSum2(c, t);
	}
}

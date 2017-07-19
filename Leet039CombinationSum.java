package B07_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates)and a target number (T), find all unique
 * combinations in C
 * where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * 1.All numbers (including target) will be positive integers.
 * 2.Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤
 * ak).
 * 3.The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class Leet039CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		dfs(candidates, 0, target, new ArrayList<Integer>(), res);
		return res;
	}

	public void dfs(int[] c, int start, int target, ArrayList<Integer> cur, List<List<Integer>> res) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = start; i < c.length; i++) {
			cur.add(c[i]);
			dfs(c, i, target - c[i], cur, res);
			cur.remove(cur.size() - 1);
		}
	}

}

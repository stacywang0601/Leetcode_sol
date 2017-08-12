package B08_12;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations. For example,
 * [1,2,3] have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1],
 * [3,1,2], and [3,2,1].
 */
public class Leet046Permutations {

	/** DFS **/
	public List<List<Integer>> permute3(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		dfs2(nums, list, res);
		return res;
	}

	public void dfs2(int[] nums, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
		}
		for (int j = 0; j < nums.length; j++) {
			if (list.contains(nums[j])) {
				continue;
			}
			list.add(nums[j]);
			dfs2(nums, list, res);
			list.remove(list.size() - 1);
		}
	}

	/**
	 * Method4--通过 boolean[] since list.contains(num) is o(n) but check boolean[] is o(1)
	 * 空间换时间
	 **/
	public List<List<Integer>> permute4(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		dfs2(nums, new boolean[nums.length], list, res);
		return res;
	}

	public void dfs2(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
		}
		for (int j = 0; j < nums.length; j++) {
			if (!used[j]) {
				used[j] = true;
				list.add(nums[j]);
				dfs2(nums, used, list, res);
				list.remove(list.size() - 1);
				used[j] = false;
			}
		}
	}
}

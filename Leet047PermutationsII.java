package B08_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [ [1,1,2],
 * [1,2,1], [2,1,1] ]
 **/
public class Leet047PermutationsII {
	/**
	 * sort!!!
	 * de duplicate
	 * i > 0 && nums[i] == nums[i - 1] && used[i - 1]
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		dfs(nums, new boolean[nums.length], res, new ArrayList<Integer>());
		return res;
	}

	public void dfs(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> list) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
				continue;
			}
			used[i] = true;
			list.add(nums[i]);
			dfs(nums, used, res, list);
			list.remove(list.size() - 1);
			used[i] = false;
		}

	}

}

package B08_14;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leet437PathSumIII {
	/**
	 * If the difference between the current sum and the target value exists in the map, there must
	 * exist a node in the middle of the path, such that from this node to the current node, the sum
	 * is equal to the target value.
	 * 
	 * restore the map, as the recursion goes from the bottom to the top
	 */
	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		return findPathSum(root, 0, sum, map);
	}

	private int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) {
		if (curr == null) {
			return 0;
		}
		// update the prefix sum by adding the current val
		sum += curr.val;
		// get the number of valid path, ended by the current node
		int numPathToCurr = map.getOrDefault(sum - target, 0);
		// update the map with the current sum, so the map is good to be passed to the next
		// recursion
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		// add the 3 parts discussed in 8. together
		int res = numPathToCurr + findPathSum(curr.left, sum, target, map)
		            + findPathSum(curr.right, sum, target, map);
		// restore the map, as the recursion goes from the bottom to the top
		map.put(sum, map.get(sum) - 1);
		return res;
	}
}
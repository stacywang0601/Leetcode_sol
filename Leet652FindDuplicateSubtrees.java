package B08_03;

/**
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only
 * need to return the root node of any one of them.
 * 
 * Two trees are duplicate if they have the same structure with same node values.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Leet652FindDuplicateSubtrees {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		serialize(getRoot(root), map, list);
		return list;
	}

	private TreeNode getRoot(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.left != null && root.right != null) {
			return root;
		}
		if (root.left != null) {
			return getRoot(root.left);
		}
		return getRoot(root.right);
	}

	private String serialize(TreeNode curr, Map<String, Integer> map, List<TreeNode> res) {
		if (curr == null) {
			return "#";
		}
		String key = curr.val + "," + serialize(curr.left, map, res) + "," + serialize(curr.right, map, res);
		if (map.getOrDefault(key, 0) == 1) {
			res.add(curr);
		}
		map.put(key, map.getOrDefault(key, 0) + 1);
		return key;
	}

	public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
		List<TreeNode> res = new LinkedList<>();
		postorder(root, new HashMap<>(), res);
		return res;
	}

	public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
		if (cur == null)
			return "#";
		String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
		if (map.getOrDefault(serial, 0) == 1)
			res.add(cur);
		map.put(serial, map.getOrDefault(serial, 0) + 1);
		return serial;
	}
}
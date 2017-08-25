package B08_25;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the
 * original BST is changed to the original key plus sum of all keys greater than the original key in
 * BST.
 */
class Leet538ConvertBSTtoGreaterTree {
	/** reverse in-order traverse */
	public TreeNode convertBST(TreeNode root) {
		dfs(root, 0);
		return root;
	}

	// sum : all nodes which we have traversed thus far
	// return: root.val + sum of all nodes greater than root
	private int dfs(TreeNode root, int sum) {
		if (root == null)
			return sum;
		int rsum = dfs(root.right, sum);
		root.val += rsum;
		return dfs(root.left, root.val);
	}
}
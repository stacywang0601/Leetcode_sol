package B07_06;

/**
 * 09-05 Given a binary tree, find its maximum depth. The maximum depth is the
 * number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 */
class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leet104MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return (left > right ? left + 1 : right + 1);

	}
}

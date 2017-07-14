package B07_14;

/** Invert a binary tree.镜像对称 */
class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leet226InvertBinaryTree {
	/** recursive */
	public TreeNode invertTree(TreeNode root) {
		// null checking
		if (root == null) {
			return null;
		} else {
			// Top-down!
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;

			invertTree(root.left);
			invertTree(root.right);
			return root;
		}
	}
}

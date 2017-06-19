package B03_31;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next node of
 * a pre-order traversal.
 */
class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leet114FlattenBinaryTreetoLinkedList {
	/**
	 * Metho1- recursive--29.08%
	 * post order traversal, all the way down! from the end
	 */
	private TreeNode	pre	= null;

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		// right first!
		flatten(root.right);
		flatten(root.left);
		root.right = pre;
		// change to null
		root.left = null;
		pre = root;

	}

	/**
	 * Method2--iteratively--29.08
	 * find the rightmost of the left children
	 **/
	public void flatten2(TreeNode root) {
		if (root == null) {
			return;
		}
		// ||
		while (root.left != null || root.right != null) {
			// left not null
			if (root.left != null) {
				TreeNode right = root.left;
				TreeNode rightmost = root.left;
				TreeNode tmp = root.right;
				while (rightmost.right != null) {
					rightmost = rightmost.right;
				}
				rightmost.right = tmp;
				root.right = right;
				// null!!!
				root.left = null;
			}
			root = root.right;
		}

	}
}

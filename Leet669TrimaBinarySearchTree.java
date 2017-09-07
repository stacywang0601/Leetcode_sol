package B09_07;

/**
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so
 * that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so
 * the result should return the new root of the trimmed binary search tree.
 * 
 * Example 1:
 * Input:
 * 1
 * / \
 * 0 2
 * 
 * L = 1
 * R = 2
 * 
 * Output:
 * 1
 * \
 * 2
 */
class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

class Leet669TrimaBinarySearchTree {
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) {
			return null;
		}
		// within the range, just recursive and connect and return root
		if (root.val >= L && root.val <= R) {
			root.left = trimBST(root.left, L, R);
			root.right = trimBST(root.right, L, R);
			return root;
		} else {
			// not in the range, recursive and return one of the children
			TreeNode ll = trimBST(root.left, L, R);
			TreeNode rr = trimBST(root.right, L, R);
			if (ll == null && rr == null) {
				return null;
			} else {
				return ll == null ? rr : ll;
			}
		}
	}

	/** more concise */
	public TreeNode trimBST2(TreeNode root, int L, int R) {
		if (root == null)
			return null;
		/** since binary tree, if root < L then only go right **/
		if (root.val < L)
			return trimBST(root.right, L, R);
		if (root.val > R)
			return trimBST(root.left, L, R);

		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);

		return root;
	}
}
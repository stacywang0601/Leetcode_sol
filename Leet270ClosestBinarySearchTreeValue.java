package B08_11;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is
 * closest to the target.
 */
class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leet270ClosestBinarySearchTreeValue {
	/**
	 * Recursive
	 * Closest is either the root's value (a) or the closest in the appropriate subtree (b).
	 */
	public int closestValue(TreeNode root, double target) {
		int a = root.val;
		TreeNode kid = target < a ? root.left : root.right;
		if (kid == null)
			return a;
		int b = closestValue(kid, target);
		return Math.abs(a - target) < Math.abs(b - target) ? a : b;
	}

	/** Iterative */
	public int closestValue2(TreeNode root, double target) {
		double diff = Double.MAX_VALUE;
		int val = 0;
		while (root != null) {
			double d = target - root.val;
			if (d == 0.0) {
				return root.val;
			} else if (d > 0.0) {
				if (d < diff) {
					diff = d;
					val = root.val;
				}
				root = root.right;
			} else {
				if (-d < diff) {
					diff = -d;
					val = root.val;
				}
				root = root.left;
			}
		}
		return val;
	}
}

package B06_18;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a
 * number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 * 1
 * / \
 * 2 3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */
public class Leet129SumRoottoLeafNumbers {
	public class TreeNode {
		int		 val;
		TreeNode	left;
		TreeNode	right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	public int sum(TreeNode n, int cur) {
		// final stop
		if (n == null)
			return 0;
		cur = cur * 10 + n.val;
		// final return
		if (n.right == null && n.left == null)
			return cur;
		// recursive
		return sum(n.left, cur) + sum(n.right, cur);
	}

}

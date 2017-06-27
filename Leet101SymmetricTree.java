/**
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * But the following [1,2,2,null,3,null,3] is not:
 **/

package B06_26;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leet101SymmetricTree {
	/**
	 * 1--Iterative way --3ms
	 * time is O(n)
	 * space is O(n) -- queue.
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> left = new LinkedList<>();
		Queue<TreeNode> right = new LinkedList<>();
		left.add(root.left);
		right.add(root.right);
		while (!left.isEmpty() && !right.isEmpty()) {
			TreeNode t1 = left.poll();
			TreeNode t2 = right.poll();
			// continue until both empty!
			if (t1 == null && t2 == null) {
				continue;
			} else if (t1 == null || t2 == null) {
				return false;
			} else {
				if (t1.val != t2.val) {
					return false;
				}
				left.add(t1.left);
				left.add(t1.right);
				right.add(t2.right);
				right.add(t2.left);
			}
		}
		return true;
	}

	/**
	 * 2-－Recursive way－－0ms
	 * time is O(n)
	 * space is O(n)
	 * The number of recursive calls is bound by the height of the tree. In
	 * the worst case, the tree is linear and the height is in O(n)
	 * Therefore,
	 * space complexity due to recursive calls on the stack is O(n)in the
	 * worst case.
	 **/
	public boolean isSymmetric2(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isMirror(root.left, root.right);
	}

	public boolean isMirror(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null || t2 == null) {
			return false;
		}
		// 又是判断作为return
		return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);

	}

}

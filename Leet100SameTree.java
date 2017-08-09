package B08_09;

/**
 * 100. Same Tree
 * Given two binary trees, write a function to check if they are
 * equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 **/

class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leet100SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		} else if (p == null && q == null) {
			return true;
		} else if (p.val == q.val) {// 别忘了值先相等再比较下面
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}
}

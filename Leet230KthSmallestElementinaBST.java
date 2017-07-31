package B07_31;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * 
 * Note:
 * You may assume k is always valid, 1 ? k ? BST's total elements.
 * 
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth
 * smallest frequently? How would you optimize the kthSmallest routine?
 * 
 */
import java.util.Stack;

class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leet230KthSmallestElementinaBST {
	/** inorder traverse +index check */
	/** iterative */
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();

		TreeNode p = root;
		int res = 0;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.left;

			} else {
				k--;
				p = stack.pop();
				if (k == 0) {
					res = p.val;
					break;
				}
				p = p.right;
			}
		}
		return res;
	}

	/** Method2:recursive */
	int	count	= 0;
	int	result	= Integer.MIN_VALUE;

	public int kthSmallest2(TreeNode root, int k) {
		traverse(root, k);
		return result;
	}

	public void traverse(TreeNode root, int k) {
		if (root == null)
			return;
		traverse(root.left, k);
		count++;
		if (count == k)
			result = root.val;
		traverse(root.right, k);
	}
}
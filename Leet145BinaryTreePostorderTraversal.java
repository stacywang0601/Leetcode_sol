package B06_10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Leet145BinaryTreePostorderTraversal {
	/**
	 * Method1--iterative 1
	 * Go to right first then left
	 * right children are pushed into stack FIRST
	 * AddFIRST before going to children
	 * root->right->left but addFIRST, so left->right->root in result
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		// the first one must be LinkedList as well
		LinkedList<Integer> res = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				res.addFirst(p.val);// Reverse the process of preorder
				p = p.right;// Reverse the process of preorder
			} else {
				p = stack.pop();
				p = p.left;// Reverse the process of preorder
			}
		}
		return res;
	}

	/**
	 * Method2--iterative 2
	 * Put left and right, but left will be processed later
	 * So put left first--processed later
	 * no need p,check null
	 */

	public List<Integer> postorderTraversal2(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			// pop
			root = stack.pop();
			// add first
			res.addFirst(root.val);
			// left first
			if (root.left != null)
				stack.push(root.left);
			if (root.right != null)
				stack.push(root.right);
		}
		return res;
	}

	/** Method3--recursive **/
	public List<Integer> postorderTraversal3(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		dfs(root, res);
		return res;
	}

	public void dfs(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		dfs(root.left, res);
		dfs(root.right, res);
		res.add(root.val);
	}

	/**
	 * Method4: Use prev to track the last processed node
	 * so when left child is null
	 * 1.if right child is null OR right child had been processed: processed this node
	 * 2.else, go right
	 * */
	public List<Integer> postorderTraversal4(TreeNode root) {
		TreeNode p = root, prev = null;
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<Integer>();
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode node = stack.peek();
				// left and right children both null OR right child had been processed
				if (node.right == null || node.right == prev) {
					res.add(node.val);
					prev = node;
					stack.pop();
				} else {
					p = node.right;
				}
			}
		}
		return res;

	}
}
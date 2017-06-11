package B06_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet144BinaryTreePreorderTraversal {
	/**
	 * Method1--iterative 1
	 * Go to left first then right
	 * Left children are pushed into stack FIRST
	 * Add before going to children
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				res.add(p.val);// Add before going to children
				p = p.left;
			} else {
				p = stack.pop();
				p = p.right;
			}
		}
		return res;
	}

	/**
	 * Method2--iterative 2
	 * Put left and right, but right will be processed later
	 * So put right first--processed later
	 * no need p,check null
	 */
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			// pop
			TreeNode node = stack.pop();
			res.add(node.val);
			// push right first
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return res;
	}

	/** Method3--recursive **/
	public List<Integer> preorderTraversal3(TreeNode root) {
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
		res.add(root.val);
		dfs(root.left, res);
		dfs(root.right, res);
	}

}

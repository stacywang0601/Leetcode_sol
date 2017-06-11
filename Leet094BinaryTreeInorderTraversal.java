package B06_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leet094BinaryTreeInorderTraversal {
	/**
	 * Method1 -- iterative 1
	 * Go to left first then right
	 * Left children are pushed into stack FIRST
	 * Add after all left children
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			// if it is not null, push to stack and go down the tree to left
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				// if no left child pop stack, process the node, then go right
				TreeNode node = stack.pop();
				res.add(node.val);  // Add after all left children
				p = node.right;
			}
		}
		return res;
	}

	/** Method 3-- recursive */
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		helper(root, res);
		return res;
	}

	public void helper(TreeNode root, List<Integer> res) {
		if (root.left != null) {
			helper(root.left, res);
		}
		res.add(root.val);
		if (root.right != null) {
			helper(root.right, res);
		}
	}

}

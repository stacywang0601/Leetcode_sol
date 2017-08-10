package B08_10;

import java.util.Stack;

class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leet173BinarySearchTreeIterator {
	/**
	 * Use Stack to store directed left children from root.
	 * When next() be called, I just pop one element and process its right child as new root.
	 * The code is pretty straightforward.
	 * 
	 * So this can satisfy O(h) memory, hasNext() in O(1) time,
	 * But next() is O(h) time.
	 */
	private Stack<TreeNode>	stack	= new Stack<TreeNode>();

	public Leet173BinarySearchTreeIterator(TreeNode root) {
		pushAll(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode tmpNode = stack.pop();
		pushAll(tmpNode.right);
		return tmpNode.val;
	}

	private void pushAll(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}
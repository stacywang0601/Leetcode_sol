package B08_25;

/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the
 * preorder traversing way.
 * 
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all
 * the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the
 * string and the original binary tree.
 */
class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

class Leet606ConstructStringfromBinaryTree {
	/**
	 * Only the right child exists for the current node. In this case, we need to consider the empty
	 * braces for the left child.
	 */
	public String tree2str(TreeNode t) {
		StringBuilder sb = new StringBuilder();
		tree2str(t, sb);
		return sb.toString();
	}

	public void tree2str(TreeNode t, StringBuilder sb) {
		if (t == null)
			return;
		sb.append(t.val);
		if (t.left == null && t.right == null)
			return;
		sb.append("(");
		if (t.left != null)
			tree2str(t.left, sb);
		sb.append(")");
		if (t.right != null) {
			sb.append("(");
			tree2str(t.right, sb);
			sb.append(")");
		}
	}
}
package B12_21;

import java.util.Arrays;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 */
public class Leet105ConstructBinaryTreefromPreorderandInorderTraversal {
	public class TreeNode {
		int		 val;
		TreeNode	left;
		TreeNode	right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * pre[0]==root
	 * in: left, (root), right
	 * 
	 * Arrays.copyOfRange(short[] original, int from, int to)
	 * from:inclusive.
	 * to :exclusive.
	 * 
	 * recursive
	 * root.left = build()
	 * root.right = build()
	 **/
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 && inorder.length == 0) {
			return null;
		}
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				index = i;
				break;
			}
		}

		TreeNode root = new TreeNode(inorder[index]);
		/*
		 * debug!!!
		 * copyOfRange(short[] original, int from, int to)
		 * from:inclusive.
		 * to :exclusive.
		 */
		int[] inorder1 = Arrays.copyOfRange(inorder, 0, index);
		int[] inorder2 = Arrays.copyOfRange(inorder, index + 1, inorder.length);

		int[] preorder1 = Arrays.copyOfRange(preorder, 1, index + 1);
		int[] preorder2 = Arrays.copyOfRange(preorder, index + 1, preorder.length);

		root.left = buildTree(preorder1, inorder1);
		root.right = buildTree(preorder2, inorder2);
		return root;

	}
}

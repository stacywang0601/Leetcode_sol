package B09_07;

class Leet671SecondMinimumNodeInaBinaryTree {

	public int findSecondMinimumValue(TreeNode root) {
		if (root == null)
			return -1;
		if (root.left == null && root.right == null)
			return -1;
		int left = root.left.val;
		int right = root.right.val;
		if (root.left.val == root.val)
			left = findSecondMinimumValue(root.left);
		if (root.right.val == root.val)
			right = findSecondMinimumValue(root.right);
		if (left != -1 && right != -1)
			return Math.min(left, right);
		else
			return left != -1 ? left : right;
	}

	public int findSecondMinimumValue2(TreeNode root) {
		if (root == null)
			return -1;
		int res = dfsHelper(root);
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public int dfsHelper(TreeNode root) {
		if (root == null)
			return -1;
		if (root.left == null && root.right == null)
			return Integer.MAX_VALUE;

		int left = root.left.val;
		int right = root.right.val;

		if (root.left.val == root.val)
			left = dfsHelper(root.left);
		if (root.right.val == root.val)
			right = dfsHelper(root.right);

		return Math.min(left, right);
	}
}

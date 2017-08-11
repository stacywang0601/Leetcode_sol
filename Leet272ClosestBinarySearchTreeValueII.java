package B08_11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are
 * closest to the target.
 */
public class Leet272ClosestBinarySearchTreeValueII {
	/**
	 * The idea is to compare the predecessors and successors of the closest node to the target, we
	 * can use two stacks to track the predecessors and successors, then like what we do in merge
	 * sort, we compare and pick the closest one to the target and put it to the result list.
	 * 
	 * As we know, inorder traversal gives us sorted predecessors, whereas reverse-inorder traversal
	 * gives us sorted successors.
	 */
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> res = new ArrayList<>();

		Stack<Integer> s1 = new Stack<>(); // predecessors
		Stack<Integer> s2 = new Stack<>(); // successors

		inorder(root, target, false, s1);
		inorder(root, target, true, s2);

		while (k-- > 0) {
			if (s1.isEmpty())
				res.add(s2.pop());
			else if (s2.isEmpty())
				res.add(s1.pop());
			else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target))
				res.add(s1.pop());
			else
				res.add(s2.pop());
		}

		return res;
	}

	// inorder traversal
	void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
		if (root == null)
			return;

		inorder(reverse ? root.right : root.left, target, reverse, stack);
		// early terminate, no need to traverse the whole tree
		if ((reverse && root.val <= target) || (!reverse && root.val > target))
			return;
		// track the value of current node
		stack.push(root.val);
		inorder(reverse ? root.left : root.right, target, reverse, stack);
	}

	/** Use LinkedList, only one inorder traverse, new--add last, old--remove first */
	public List<Integer> closestKValues2(TreeNode root, double target, int k) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		find(root, target, k, q);
		return q;
	}

	void find(TreeNode cur, double target, int k, LinkedList<Integer> q) {
		if (cur == null)
			return;
		else {
			find(cur.left, target, k, q);
			if (q.isEmpty() || q.size() < k) {
				q.addLast(cur.val);
				find(cur.right, target, k, q);
			} else {
				if (Math.abs(target - q.getFirst()) > Math.abs(target - cur.val)) {
					q.removeFirst();
					q.addLast(cur.val);
					find(cur.right, target, k, q);
				}
			}
		}
	}
}
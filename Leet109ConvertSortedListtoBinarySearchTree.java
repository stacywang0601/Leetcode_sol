package B07_05;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height
 * balanced BST.
 */
class ListNode {
	int	     val;
	ListNode	next;

	ListNode(int x) {
		val = x;
	}
}

class TreeNode {
	int	     val;
	TreeNode	left;
	TreeNode	right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leet109ConvertSortedListtoBinarySearchTree {
	/**
	 * find middle(middle after) point, recursive
	 * check null, !!! if only one node--return itself
	 * pre to check first end, pre.next = null
	 * 
	 * */
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode first = head, slow = head, fast = head;
		ListNode pre = null;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			pre = slow;
			slow = slow.next;
		}
		ListNode second = slow.next;
		pre.next = null;
		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(first);
		root.right = sortedListToBST(second);
		return root;

	}
}
package B06_24;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
class ListNode {
	int	     val;
	ListNode	next;

	ListNode(int x) {
		val = x;
	}
}

/**
 * 1 Break list in the middle to two lists (use fast & slow pointers)
 * 2 Reverse the order of the p2 list
 * 3 Merge two list back together
 */
public class Leet143ReorderList {

	public void reorderList(ListNode head) {
		// check null
		if (head == null || head.next == null) {
			return;
		}
		ListNode fast = head;
		ListNode slow = head;
		/**
		 * odd & even
		 **/
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode second = reverseList(slow.next);
		// close first half list
		slow.next = null;

		ListNode p1 = head;
		ListNode p2 = second;
		/**
		 * p1 longer than or equal to p2
		 */
		while (p2 != null) {
			ListNode tmp1 = p1.next;
			ListNode tmp2 = p2.next;
			p1.next = p2;
			p2.next = tmp1;
			p1 = tmp1;
			p2 = tmp2;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}
}

package B07_18;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 **/
class ListNode {
	int	     val;
	ListNode	next;

	ListNode(int x) {
		val = x;
	}
}

public class Leet024SwapNodesinPairs {
	/**
	 * Method1--recursion
	 **/
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		head.next = swapPairs(head.next.next);
		newHead.next = head;
		return newHead;

	}

	/**
	 * Method2--Iterative
	 * dummy head
	 **/
	public ListNode swapPairs2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			cur.next = swap(cur.next, cur.next.next);
			cur = cur.next.next;
		}
		return dummy.next;
	}

	public ListNode swap(ListNode l1, ListNode l2) {
		l1.next = l2.next;
		l2.next = l1;
		return l2;
	}

}

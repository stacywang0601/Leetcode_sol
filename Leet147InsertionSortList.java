package B01_22;

class ListNode {
	int	     val;
	ListNode	next;

	ListNode(int x) {
		val = x;
	}
}

/** Sort a linked list using insertion sort. */
public class Leet147InsertionSortList {
	/**
	 * dummy head
	 * pre->cur->pre.next
	 * 
	 **/
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// fake head for new sorted list
		ListNode sortListHead = new ListNode(0);
		ListNode cur = head;
		while (cur != null) {
			ListNode pre = sortListHead;
			ListNode next = cur.next;// save it in the original list
			// traverse sortedlist to find the right position
			while (pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			// pre->cur->pre.next
			cur.next = pre.next;
			pre.next = cur;
			cur = next;// go back to original list
		}
		return sortListHead.next;

	}
}

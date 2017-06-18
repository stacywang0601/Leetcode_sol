package B06_17;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 **/
public class Leet083RemoveDuplicatesfromSortedList {
	/**
	 * Method1: one pointer
	 * remove one by one
	 **/
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;

		ListNode cur = head;
		while (cur.next != null) {
			// remove if duplicate
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else
				// go to next if not
				cur = cur.next;
		}
		return head;
	}

	/** Method2: recursion */
	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;
	}

	/**
	 * Method3--fast slow
	 * dummy
	 * loop to find the last one in duplicate
	 * remove all duplicates with same value once
	 */
	public ListNode deleteDuplicates3(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = head, slow = dummy;
		while (fast != null) {
			// loop to find the last one in duplicate
			while (fast.next != null && fast.val == fast.next.val) {
				fast = fast.next;
			}
			// found duplicate
			if (slow.next != fast) {
				// delete dup
				slow.next = fast;
			} else {
				// no move to next
				slow = slow.next;
				fast = fast.next;
			}
		}
		return dummy.next;
	}
}

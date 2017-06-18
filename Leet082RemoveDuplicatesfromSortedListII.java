package B06_17;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 **/
class ListNode {
	int	     val;
	ListNode	next;

	ListNode(int x) {
		val = x;
	}
}

public class Leet082RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		/**
		 * Method1:use two pointers, slow - track the node before the dup nodes,
		 * fast - to find the last node of dups.
		 **/
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
				slow.next = fast.next;// remove dups
				fast = slow.next;// reposition fast pointer
			} else {// no dup, move down both pointer.
				slow = slow.next;
				fast = fast.next;
			}
		}
		return dummy.next;
	}

	/** Method2: recursive */
	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		// found duplicate
		if (head.next != null && head.val == head.next.val) {
			while (head.next != null && head.val == head.next.val) {
				head = head.next;
			}
			// delete all nodes before head.next
			return deleteDuplicates(head.next);
		} else {
			// no dup, move to next
			head.next = deleteDuplicates(head.next);
		}
		return head;
	}
}

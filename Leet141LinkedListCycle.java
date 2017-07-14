/**
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 */
package B07_14;

class ListNode {
	int	     val;
	ListNode	next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Leet141LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		ListNode fast = head, slow = head;
		// fast, fast.next
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
}

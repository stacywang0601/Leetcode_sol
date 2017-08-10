package B08_10;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
class ListNode {
	int	     val;
	ListNode	next;

	ListNode(int x) {
		val = x;
	}
}

public class Leet234PalindromeLinkedList {
	/** by reversing the 2nd half and compare the two halves */
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) { // odd nodes: let right half smaller
			slow = slow.next;
		}
		slow = reverse(slow);
		fast = head;

		while (slow != null) {
			if (fast.val != slow.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}

	public ListNode reverse(ListNode cur) {
		ListNode prev = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}
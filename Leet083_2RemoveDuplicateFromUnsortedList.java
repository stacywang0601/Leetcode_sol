package B03_24;

import java.util.HashSet;

/**
 * Given a unsorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example,
 * Given 7->7->2, return 7->2.
 * Given 6->6->2->3->3, return 6->2->3.
 **/
class ListNode {
	int	     val;
	ListNode	next;

	ListNode(int x) {
		val = x;
	}

	public void appendToTail(int d) {
		ListNode end = new ListNode(d);
		ListNode node = this;
		// n.next!!!
		while (node.next != null) {
			node = node.next;
		}
		node.next = end;
	}
}

public class Leet083_2RemoveDuplicateFromUnsortedList {

	/**
	 * Method1- HashSet
	 * time: O(n),space O(n)
	 * pre null!!!
	 * 
	 **/
	public static ListNode deleteDuplicates1(ListNode head) {
		HashSet<Integer> set = new HashSet<>();
		// track previous node
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			if (set.contains(cur.val)) {
				pre.next = cur.next;
			} else {
				set.add(cur.val);
				// update pre
				pre = cur;
			}
			cur = cur.next;
		}
		return head;

	}

	/**
	 * Method2- two pointers
	 * time O(n^2),spaceO(1)
	 */
	public static ListNode deleteDuplicates2(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			ListNode runner = cur;
			while (runner.next != null) {
				// compare with cur
				if (runner.next.val == cur.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			cur = cur.next;
		}
		return head;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.appendToTail(3);
		head.appendToTail(3);
		head.appendToTail(1);
		head.appendToTail(6);
		head.appendToTail(6);
		head.appendToTail(2);
		head.appendToTail(4);
		head.appendToTail(7);

		ListNode current = deleteDuplicates1(head);
		while (current != null) {
			System.out.print(current.val + "->");
			current = current.next;
		}

	}
}

package B07_20;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 */

public class Leet023MergekSortedLists {
	public class ListNode {
		int		 val;
		ListNode	next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * Method2--Binary search O(nlogk)
	 * although s won't greater than e in this situation
	 * we need add else + return
	 * or it shows missing return
	 **/
	public ListNode mergeKLists(ListNode[] lists) {
		return partition(lists, 0, lists.length - 1);

	}

	public ListNode partition(ListNode[] lists, int s, int e) {
		if (s == e) {
			return lists[s];
		}
		int p = (s + e) / 2;
		if (s < e) {
			ListNode l1 = partition(lists, s, p);
			ListNode l2 = partition(lists, p + 1, e);
			return mergeTwoLists2(l1, l2);
		} else {
			return null;
		}

	}

	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode temp = dummy;

		while (l1 != null && l2 != null) {
			if (l2.val < l1.val) {
				temp.next = l2;
				l2 = l2.next;
			} else {
				temp.next = l1;
				l1 = l1.next;
			}
			temp = temp.next;
		}

		if (l1 != null) {
			temp.next = l1;
		} else {
			temp.next = l2;
		}
		return dummy.next;
	}

	/** priorityqueue O(nlogk) **/
	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (ListNode node : lists)
			if (node != null)
				queue.add(node);

		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			if (node.next != null) {
				queue.add(node.next);
			}
			cur.next = node;
			cur = cur.next;
		}
		return dummy.next;
	}

}

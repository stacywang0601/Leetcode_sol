package B07_20;

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
	 * Method2--Binary search
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

	/**
	 * Method3--没什么特别，就是merge也用了recursive
	 * 把merge recursive重新又写了一遍
	 */
	public ListNode mergeKLists3(ListNode[] lists) {
		return partition(lists, 0, lists.length - 1);
	}

	public ListNode partition3(ListNode[] lists, int s, int e) {
		if (s == e) {
			return lists[s];
		}
		int p = (s + e) / 2;
		if (s < e) {
			ListNode l1 = partition3(lists, s, p);
			ListNode l2 = partition3(lists, p + 1, e);
			return mergeTwoLists3(l1, l2);
		} else {
			return null;
		}

	}

	public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists3(l1.next, l2);
			// 别忘了return
			return l1;
		} else {
			l2.next = mergeTwoLists3(l1, l2.next);
			return l2;
		}
	}

}

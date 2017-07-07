package B07_07;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implement a data structure supporting the following operations:
 * 
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed
 * to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an
 * existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be
 * a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty
 * string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty
 * string "".
 * Challenge: Perform all these in O(1) time complexity.
 */
public class Leet432AllOoneDataStructure {
	/**
	 * same as LFU
	 * node with val and linkedhashset<key>
	 * use hashmap to stroe<key, node>
	 * multiple keys corresponding to one node
	 * plus hashset iterator.next O(h/n) while linkedHashSet is O(1)
	 */
	class Node {
		int		    val;
		Node		pre;
		Node		next;
		Set<String>	keys;

		public Node(int val) {
			this.val = val;
			keys = new LinkedHashSet<>();
		}
	}

	private Node	          head;
	private Node	          tail;
	private Map<String, Node>	keyNode;

	/** Initialize your data structure here. */
	public Leet432AllOoneDataStructure() {
		head = new Node(0);
		tail = new Node(-1);
		head.next = tail;
		tail.pre = head;
		keyNode = new HashMap<>();
	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		Node cur = keyNode.get(key);
		if (cur == null) {// no this key, create new node
			if (head.next.val != 1) {// either next node val >1 or is tail
				cur = new Node(1);
				cur.keys.add(key);
				cur.pre = head;
				cur.next = head.next;
				head.next.pre = cur;// this first!
				head.next = cur;
			} else {
				head.next.keys.add(key);
			}

			keyNode.put(key, head.next);// combine two case together

		} else {// have this key, move to next node
			cur.keys.remove(key);
			if (cur.next.val == cur.val + 1) {// next val is one more
				cur.next.keys.add(key);
			} else {// create a new node with val+1
				Node newNode = new Node(cur.val + 1);
				newNode.keys.add(key);
				newNode.next = cur.next;
				newNode.pre = cur;
				cur.next.pre = newNode;
				cur.next = newNode;
			}

			keyNode.put(key, cur.next);

			if (cur.keys.isEmpty()) {
				cur.pre.next = cur.next;
				cur.next.pre = cur.pre;
			}
		}

	}

	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	public void dec(String key) {
		Node cur = keyNode.get(key);
		if (cur != null) {
			cur.keys.remove(key);
			if (cur.val > 1) {// >1
				if (cur.pre.val + 1 == cur.val) {// pre is one less
					cur.pre.keys.add(key);
				} else {
					Node newNode = new Node(cur.val - 1);// new node with val-1
					newNode.keys.add(key);
					newNode.next = cur;
					newNode.pre = cur.pre;
					cur.pre.next = newNode;
					cur.pre = newNode;
				}

				keyNode.put(key, cur.pre);

			} else {// cur.val == 1
				keyNode.remove(key);
			}

			if (cur.keys.isEmpty()) {
				cur.pre.next = cur.next;
				cur.next.pre = cur.pre;
			}
		}
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		if (tail.pre.val != 0) {
			return tail.pre.keys.iterator().next();
		} else {
			return "";
		}
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		if (head.next.val != -1) {
			return head.next.keys.iterator().next();
		} else {
			return "";
		}
	}
}

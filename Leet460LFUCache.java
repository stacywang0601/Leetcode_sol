package B06_13;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 2 Hashmaps + Double Linked List (LinkedHashSet inside the node)
 * 
 * HashMap<Integer, Integer> valueHash store <key, value> pair
 * HashMap<Integer, Node> nodeHash store the <key, node>
 * 
 * Double linked list to keep the frequency(count) of each key
 * Keys with the same frequency(count) are saved LinkedHashSet in a same node
 * Inside the LinkedHashSet the first one is added first which is Least Recently Used
 * 
 * Double linked list:
 * 1.node can remove itself without other reference.
 * 2.constant time to add and remove nodes from the head or tail.
 * 
 * A pseudo head and tail to mark the boundary
 * so that we don't need to check the NULL node during the update.
 */

public class Leet460LFUCache {
	private class Node {
		int		               count	= 0;
		LinkedHashSet<Integer>	keys	= null;
		Node		           pre		= null, next = null;

		Node(int count) {
			this.count = count;
			keys = new LinkedHashSet<Integer>();
		}
	}

	private void addToHead(int key) {
		// has next node whose count >0 or initial one
		if (head.next.count > 0 || head.next.count == -1) {// add node after head
			Node node = new Node(0);
			node.keys.add(key);
			node.pre = head;// connect pre and next
			node.next = head.next;
			head.next.pre = node;
			head.next = node;
		} else {
			head.next.keys.add(key);// the first node after head mean count 0
		}
		nodeHash.put(key, head.next);

	}

	private void remove(Node node) {// no need to check null since pseudo head tail node
		Node pre = node.pre;
		Node next = node.next;
		pre.next = next;
		next.pre = pre;
	}

	private void removeOld() {
		Node node = head.next;
		// if (node == null)// no need to check this null since pseudo tail node
		// return;
		int old = node.keys.iterator().next();// find first one in the Linkedhashset which is the
											  // oldest one
		node.keys.remove(old);
		if (node.keys.size() == 0)
			remove(node);
		nodeHash.remove(old);
		valueHash.remove(old);
	}

	private void increaseCount(int key) {
		Node node = nodeHash.get(key);
		node.keys.remove(key);// first remove from this node, then add to next or new one

		if (node.next.count == node.count + 1) {// add to next one
			node.next.keys.add(key);
		} else {
			Node tmp = new Node(node.count + 1);// new one after
			tmp.keys.add(key);
			tmp.pre = node;// connect
			tmp.next = node.next;
			node.next.pre = tmp;
			node.next = tmp;
		}

		nodeHash.put(key, node.next);
		if (node.keys.size() == 0)// check if this node empty
			remove(node);
	}

	private int	                      capacity, count;
	private HashMap<Integer, Integer>	valueHash	= null;
	private HashMap<Integer, Node>	  nodeHash	  = null;
	private Node	                  head, tail;

	public Leet460LFUCache(int capacity) {
		this.capacity = capacity;
		this.count = 0;
		valueHash = new HashMap<Integer, Integer>();
		nodeHash = new HashMap<Integer, Node>();
		// -1
		head = new Node(-1);// pseudo head and tail node tail = new Node(-1);
		head.next = tail;
		tail.pre = head;

	}

	public int get(int key) {
		if (valueHash.containsKey(key)) {
			increaseCount(key);
			return valueHash.get(key);
		}
		return -1;

	}

	public void put(int key, int value) {
		if (capacity == 0)
			return;
		if (valueHash.containsKey(key)) {
			valueHash.put(key, value);// update if contains the key
		} else {
			if (valueHash.size() < capacity) {// not contain but size < capacity : put directly
				valueHash.put(key, value);
			} else {
				removeOld();// >= capacity, remove first
				valueHash.put(key, value);
			}
			addToHead(key);// not contains, add key after head
		}
		increaseCount(key);// update count

	}
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

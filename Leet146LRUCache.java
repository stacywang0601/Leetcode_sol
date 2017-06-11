package B06_11;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
 * following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache
 * reached its capacity, it should invalidate the least recently used item before inserting a new
 * item.
 * Example:
 * LRUCache cache = new LRUCache( 2 ); capacity
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1); returns 1
 * cache.put(3, 3); evicts key 2
 * cache.get(2); returns -1 (not found)
 * cache.put(4, 4); evicts key 1
 * cache.get(1); returns -1 (not found)
 * cache.get(3); returns 3
 * cache.get(4); returns 4
 */
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
import java.util.HashMap;
import java.util.Map;

/**
 * Hashmap + Double Linked List
 * Hashmap: track key and node pair
 * Double linked list:
 * 1.node can remove itself without other reference.
 * 2.constant time to add and remove nodes from the head or tail.
 * 
 * A pseudo head and tail to mark the boundary
 * so that we don't need to check the NULL node during the update.
 */
public class Leet146LRUCache {
	private class Node {
		int	key, value;
		Node	pre, next;

		Node(int k, int v) {
			this.key = k;
			this.value = v;
		}

		Node() {
			this(0, 0);
		}
	}

	private void add(Node node) {
		node.pre = head;
		node.next = head.next;

		head.next.pre = node;
		head.next = node;

	}

	private void remove(Node node) {
		Node pre = node.pre;
		Node next = node.next;

		pre.next = next;
		next.pre = pre;
	}

	private void update(Node node) {
		remove(node);
		add(node);
	}

	private int	               capacity, count;
	private Map<Integer, Node>	map;
	private Node	           head, tail;

	public Leet146LRUCache(int capacity) {
		this.capacity = capacity;
		this.count = 0;
		map = new HashMap<>();
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.pre = head;
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {
			return -1;
		}
		update(node);
		return node.value;
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if (node == null) {
			node = new Node(key, value);
			map.put(key, node);
			add(node);
			count++;
		} else {
			node.value = value;
			update(node);
		}

		if (count > capacity) {
			Node toDel = tail.pre;
			remove(toDel);
			map.remove(toDel.key);
			count--;
		}

	}
}

package B08_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * 
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same
 * probability of being returned.
 */
public class Leet380RandomizedSet {
	/**
	 * Hashmap with Arraylist
	 * swap with the last one, remove the last one is O(1)
	 */
	private List<Integer>	      list;
	private Map<Integer, Integer>	map;
	private Random	              rand;

	/** Initialize your data structure here. */
	public Leet380RandomizedSet() {
		list = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
		rand = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain the specified
	 * element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		map.put(val, list.size());
		list.add(val);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int index = map.get(val);
		int lastVal = list.get(list.size() - 1);
		if (val != lastVal) {
			list.set(index, lastVal);
			map.put(lastVal, index);
		}
		list.remove(list.size() - 1);
		map.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(rand.nextInt(list.size()));
	}
}

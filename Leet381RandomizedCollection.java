package B08_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Leet381RandomizedCollection {
	private Map<Integer, Set<Integer>>	map;
	private List<Integer>	           list;

	/** Initialize your data structure here. */
	public Leet381RandomizedCollection() {
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not already contain the
	 * specified element.
	 */
	public boolean insert(int val) {
		boolean contain = map.containsKey(val);
		if (!contain) {
			map.put(val, new HashSet<>());
		}
		// 与1不同，map存在可以继续加
		map.get(val).add(list.size());
		list.add(val);
		return !contain;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection contained the specified
	 * element.
	 * 顺序：map remove； map重设，list重设，list remove
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		// 找到set里面的第一个
		int index = map.get(val).iterator().next();
		int lastVal = list.get(list.size() - 1);
		// map删除不能放在后面，因为可能val==lastVal,那么下面add（index）就会失败
		map.get(val).remove(index);
		if (map.get(val).isEmpty()) {
			map.remove(val);
		}
		// 因为有重复，不能判断value要判断位置
		if (index != list.size() - 1) {
			// lastVal的set里面去掉list.size() - 1加上index，相当于update
			map.get(lastVal).remove(list.size() - 1);
			map.get(lastVal).add(index);
			list.set(index, lastVal);
		}
		list.remove(list.size() - 1);
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

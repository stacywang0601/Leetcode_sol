package B09_19;

import java.util.HashMap;
import java.util.Map;

class Leet677MapSum_2 {
	private Map<String, Integer>	map;

	/** Initialize your data structure here. */
	public Leet677MapSum_2() {
		map = new HashMap<>();
	}

	public void insert(String key, int val) {
		map.put(key, val);
	}

	public int sum(String prefix) {
		int r = 0;
		for (String s : map.keySet()) {
			if (s.startsWith(prefix)) {
				r += map.get(s);
			}
		}
		return r;
	}
}
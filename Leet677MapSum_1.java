package B09_19;

import java.util.HashMap;
import java.util.Map;

class Leet677MapSum_1 {
	class TrieNode {
		Map<Character, TrieNode>	children;
		boolean		             isWord;
		int		                 value;

		public TrieNode() {
			children = new HashMap<Character, TrieNode>();
			isWord = false;
			value = 0;
		}
	}

	TrieNode	root;

	/** Initialize your data structure here. */
	public Leet677MapSum_1() {
		root = new TrieNode();
	}

	public void insert(String key, int val) {
		TrieNode curr = root;
		for (char c : key.toCharArray()) {
			TrieNode next = curr.children.get(c);
			if (next == null) {
				next = new TrieNode();
				curr.children.put(c, next);
			}
			curr = next;
		}
		curr.isWord = true;
		curr.value = val;
	}

	public int sum(String prefix) {
		TrieNode curr = root;
		for (char c : prefix.toCharArray()) {
			TrieNode next = curr.children.get(c);
			if (next == null) {
				return 0;
			}
			curr = next;
		}

		return dfs(curr);
	}

	private int dfs(TrieNode root) {
		int sum = 0;
		for (char c : root.children.keySet()) {
			sum += dfs(root.children.get(c));
		}
		return sum + root.value;
	}
}

package B06_19;

/**
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * 
 * click to show hint.
 * 
 * You should be familiar with how a Trie works. If not, please work on this
 * problem: Implement Trie (Prefix Tree) first.
 **/
public class Leet211AddandSearchWord_Datastructuredesign {
	/**
	 * Tire based solution
	 * add, iterative
	 * search, recursive
	 * first check if lenth and index
	 * if c == '.'，go through all children
	 * if c != '.'，check node
	 **/
	public class WordDictionary {
		public class wordNode {
			wordNode[]	children	= new wordNode[26];
			boolean		isLeaf		= false;
		}

		private wordNode	root;

		/** Initialize your data structure here. */
		public WordDictionary() {
			root = new wordNode();
		}

		/** Adds a word into the data structure. */
		public void addWord(String word) {
			wordNode node = root;
			for (char c : word.toCharArray()) {
				if (node.children[c - 'a'] == null) {
					node.children[c - 'a'] = new wordNode();
				}
				node = node.children[c - 'a'];
			}
			node.isLeaf = true;
		}

		/**
		 * Returns if the word is in the data structure. A word could contain the dot character '.'
		 * to represent any one letter.
		 */
		public boolean search(String word) {
			return search(word.toCharArray(), 0, root);
		}

		private boolean search(char[] arr, int index, wordNode parent) {
			if (parent == null) {
				return false;
			}
			if (index == arr.length) {
				return parent.isLeaf;
			}

			char c = arr[index];
			if (c == '.') {
				for (int i = 0; i < parent.children.length; i++) {
					if (search(arr, index + 1, parent.children[i])) {
						return true;
					}
				}
				return false;
			}

			if (parent.children[c - 'a'] == null) {
				return false;
			}
			return search(arr, index + 1, parent.children[c - 'a']);

		}
	}

	/**
	 * Your WordDictionary object will be instantiated and called as such:
	 * WordDictionary obj = new WordDictionary();
	 * obj.addWord(word);
	 * boolean param_2 = obj.search(word);
	 */
}
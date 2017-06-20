package B06_20;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 **/
public class Leet127WordLadder {
	/**
	 * The idea behind bidirectional search is to run two simultaneous searches
	 * The motivation is that b^(d/2) + b^(d/2) is much less than b^d.
	 * b is branch factor, d is depth.
	 * BFS isn't equivalent to Queue. Sometimes Set is more accurate representation for nodes of
	 * level. (also handy since we need to check if we meet from two ends)
	 * 
	 */

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordset = new HashSet<String>(wordList);
		Set<String> start = new HashSet<String>();
		Set<String> end = new HashSet<String>();

		start.add(beginWord);
		// first check if endWord exists in the dictionary
		if (!wordset.contains(endWord)) {
			return 0;
		}
		end.add(endWord);

		return helper(start, end, wordset, 1);
	}

	public int helper(Set<String> start, Set<String> end, Set<String> wordset, int level) {
		// the target (end set) is empty means last round no candidates of start exists in wordset
		if (end.isEmpty()) {
			return 0;
		}
		if (start.size() > end.size()) {
			return helper(end, start, wordset, level);
		}
		// removeAll
		wordset.removeAll(start);
		wordset.removeAll(end);

		// set for candidates of next level
		HashSet<String> set = new HashSet<String>();

		for (String str : start) {
			char[] arr = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				char temp = arr[i];
				for (char c = 'a'; c < 'z'; c++) {
					if (c == temp) {
						continue;
					}
					arr[i] = c;
					String newword = new String(arr);

					if (end.contains(newword)) {
						return level + 1;
					}

					if (wordset.contains(newword)) {
						set.add(newword);
					}
					// go back
					arr[i] = temp;
				}
			}
		}
		return helper(end, set, wordset, level + 1);
	}

}

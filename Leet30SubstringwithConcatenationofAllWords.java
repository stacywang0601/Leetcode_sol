package B05_24;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all
 * starting indices of substring(s) in s that is a concatenation of each word in words exactly once
 * and without any intervening characters.
 * 
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leet30SubstringwithConcatenationofAllWords {
	/*
	 * A time & space O(n) solution
	 * Run a moving window for wordLen times.
	 * Keep a window of size windowLen (= wordLen * numWord), each step length is wordLen.
	 * Each scan takes O(sLen / wordLen), totally takes O(sLen / wordLen * wordLen) = O(sLen)
	 * One trick: use count to record the number of exceeded occurrences of word in current window
	 */
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (words == null || words.length == 0 || s.length() == 0)
			return res;
		int wordLen = words[0].length();
		int numWord = words.length;
		int windowLen = wordLen * numWord;
		int sLen = s.length();
		HashMap<String, Integer> map = new HashMap<>();
		for (String w : words)
			map.put(w, map.containsKey(w) ? (map.get(w) + 1) : 1);

		for (int i = 0; i < wordLen; i++) {  // Run wordLen scans
			HashMap<String, Integer> curMap = new HashMap<>();
			// Move window in step of wordLen
			for (int j = i, count = 0, start = i; j + wordLen <= sLen; j += wordLen) {
				// count: number of exceeded occurences in current window
				// start: start index of current window of size windowLen
				if (start + windowLen > sLen)
					break;
				String word = s.substring(j, j + wordLen);
				if (!map.containsKey(word)) {
					curMap.clear();
					count = 0;
					start = j + wordLen;
				} else {
					// Remove previous word of current window-->only move one word
					if (j == start + windowLen) {
						String preWord = s.substring(start, start + wordLen);
						start += wordLen;
						int val = curMap.get(preWord);
						if (val == 1)
							curMap.remove(preWord);
						else
							curMap.put(preWord, val - 1);
						if (val - 1 >= map.get(preWord))
							count--;  // Reduce count of exceeded word
					}
					// Add new word
					curMap.put(word, curMap.containsKey(word) ? (curMap.get(word) + 1) : 1);
					if (curMap.get(word) > map.get(word))
						count++;  // More than expected, increase count
					// Check if current window valid
					if (count == 0 && start + windowLen == j + wordLen) {
						res.add(start);
					}
				}
			}
		}
		return res;
	}

	/*
	 * Method2: Almost same as 1
	 * One trick: use count to record the number of vlaid occurrences of word in current window
	 * When find a word that appears more than it in map
	 * slide start to the [next word] of the [first same word] as this word !!!---> Jump!!!maybe
	 * several words
	 */
	public static List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (words == null || words.length == 0 || s.length() == 0)
			return res;
		int wordLen = words[0].length();
		int numWord = words.length;
		int windowLen = wordLen * numWord;
		int sLen = s.length();
		HashMap<String, Integer> map = new HashMap<>();
		for (String w : words)
			map.put(w, map.containsKey(w) ? (map.get(w) + 1) : 1);

		for (int i = 0; i < wordLen; i++) {  // Run wordLen scans
			HashMap<String, Integer> curMap = new HashMap<>();
			for (int j = i, count = 0, start = i; j + wordLen <= sLen; j += wordLen) {
				// count: number of valid occurences in current window
				// start: start index of current window of size windowLen
				if (start + windowLen > sLen)
					break;
				String word = s.substring(j, j + wordLen);
				if (map.containsKey(word)) {
					curMap.put(word, curMap.containsKey(word) ? (curMap.get(word) + 1) : 1);
					count++;
					if (curMap.get(word) > map.get(word)) {
						int k = start;
						while (k < j) {// ---> Jump!!!maybe several words[better than method1]
							String temp = s.substring(k, k + wordLen);
							curMap.put(temp, curMap.get(temp) - 1);
							count--;
							if (temp.equals(word))
								break;
							k += wordLen;
						}
						start = k + wordLen;
					} else if (count == numWord) {
						res.add(start);
						String preWord = s.substring(start, start + wordLen);
						curMap.put(preWord, curMap.get(preWord) - 1);
						count--;
						start += wordLen;
					}

				} else {
					curMap.clear();
					count = 0;
					start = j + wordLen;
				}
			}
		}
		return res;
	}

}

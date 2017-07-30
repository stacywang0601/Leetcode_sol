package B07_29;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest
 * transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 * 
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 **/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Leet126WordLadderII {
	/**
	 * Two end BFS + DFS
	 * 
	 * boolean reverse to mark if reverse
	 * make sure we construct the tree in the correct direction(one consist direction)
	 * 
	 * boolean finish to terminate early when find the shortest path
	 * 
	 * use a map to help construct the final result
	 * HashMap<String, List<String>> map = new HashMap<>();
	 * if (!map.containsKey(start)) {
	 * return;
	 * }
	 * 
	 */
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> start = new HashSet<>();
		HashSet<String> end = new HashSet<>();
		HashSet<String> dict = new HashSet<>();

		start.add(beginWord);
		end.add(endWord);
		// addAll
		dict.addAll(wordList);
		// we use a map to help construct the final result
		HashMap<String, List<String>> map = new HashMap<>();
		List<List<String>> res = new ArrayList<>();

		if (!dict.contains(endWord)) {
			return res;
		}

		buildMap(start, end, false, dict, map);

		List<String> path = new ArrayList<>();
		path.add(beginWord);

		// recursively build the final result
		genPath(beginWord, endWord, res, map, path);
		return res;
	}

	private void buildMap(HashSet<String> start, HashSet<String> end, boolean reverse, HashSet<String> dict,
	            HashMap<String, List<String>> map) {
		if (start.size() == 0) {
			return;
		}
		if (start.size() > end.size()) {
			buildMap(end, start, !reverse, dict, map);
			return;
		}

		dict.removeAll(start);
		// as we only need the shortest paths
		// we use a boolean value help early termination
		boolean finished = false;
		HashSet<String> next = new HashSet<>();

		for (String word : start) {
			char[] arr = word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				char temp = arr[i];
				for (char c = 'a'; c <= 'z'; c++) {
					if (c == temp) {
						continue;
					}
					arr[i] = c;
					String newString = new String(arr);
					if (dict.contains(newString)) {
						if (end.contains(newString)) {
							finished = true;
						} else {
							next.add(newString);
						}
						// make sure we construct the tree in the correct direction(one consist
						// direction)
						String parent = reverse ? newString : word;
						String child = reverse ? word : newString;

						List<String> neighbor = map.getOrDefault(parent, new ArrayList<String>());
						neighbor.add(child);
						map.put(parent, neighbor);
					}
				}
				arr[i] = temp;
			}
		}
		// find shortest path!
		if (!finished) {
			buildMap(next, end, reverse, dict, map);
		}
	}

	private void genPath(String start, String end, List<List<String>> ans, HashMap<String, List<String>> map,
	            List<String> temp) {
		if (start.equals(end)) {
			ans.add(new ArrayList<>(temp));
			return;
		}

		if (!map.containsKey(start)) {
			return;
		}

		for (String s : map.get(start)) {
			temp.add(s);
			genPath(s, end, ans, map, temp);
			temp.remove(temp.size() - 1);
		}
	}

}
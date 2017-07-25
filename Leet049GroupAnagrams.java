package B07_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * 
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 */
public class Leet049GroupAnagrams {

	/**
	 * HashMap<String, ArrayList<String>> map
	 * Method--sort
	 **/
	public List<List<String>> groupAnagrams2(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] word = s.toCharArray();
			Arrays.sort(word);
			String skey = String.valueOf(word);
			if (!map.containsKey(skey)) {
				map.put(skey, new ArrayList<String>());
			}
			map.get(skey).add(s);
		}
		// map.values()
		return new ArrayList<>(map.values());
	}

}

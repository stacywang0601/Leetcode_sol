package B08_13;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add
 * spaces in s to construct a sentence where each word is a valid dictionary word. You may assume
 * the dictionary does not contain duplicate words.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet140WordBreakII {
	/**
	 * dfs + memo Map<String, List<String>>
	 * 把每个string分成两部分
	 * s.substring(i); 是从i到结尾，这段直接从dict里面查看
	 * s.substring(0, i) 则是dfs 递归寻找结果
	 * 最后两者结果合并
	 * eg:
	 * string: apple
	 * dict[ap, p, app, le, apple]
	 * res最先add(apple)
	 * then t = le
	 * temp = ["app", "ap p"]
	 * res = ["apple", "app le", "ap p le"];
	 * */

	Map<String, List<String>>	map	= new HashMap<String, List<String>>();

	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return res;
		}
		if (map.containsKey(s)) {
			return map.get(s);
		}
		// 先判断s是否在dict里面,res最先add(apple)
		if (wordDict.contains(s)) {
			res.add(s);
		}
		for (int i = 1; i < s.length(); i++) {
			String t = s.substring(i);
			if (wordDict.contains(t)) {
				List<String> temp = wordBreak(s.substring(0, i), wordDict);
				if (temp.size() != 0) {
					for (int j = 0; j < temp.size(); j++) {
						res.add(temp.get(j) + " " + t);
					}
				}
			}
		}
		map.put(s, res);
		return res;
	}
}
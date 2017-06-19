package B01_06;

import java.util.List;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class Leet139WordBreak {
	/**
	 * boolean
	 * res track if S[0:i-1] can be break。
	 * res[i]=true if and only there exists a k enables following rule
	 * res[k] = true and s[k:i-1] exists in list --> which is
	 * res[i] = res[k] && wordDict.contains(s.substring(k, i));
	 **/
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] res = new boolean[s.length() + 1];
		res[0] = true;
		// debug--endIndex so 1-->s.length() + 1
		for (int i = 1; i < s.length() + 1; i++) {
			for (int k = 0; k < i; k++) {
				res[i] = res[k] && wordDict.contains(s.substring(k, i));
				if (res[i]) {
					break;
				}
			}
		}
		return res[s.length()];

	}
}

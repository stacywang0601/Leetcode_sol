package B08_13;

/** Given two strings S and T, determine if they are both one edit distance apart. */
public class Leet161OneEditDistance {
	/**
	 * m ==n so the only possibility is replacing
	 * 
	 * m > n so the only possibility is deleting from s
	 * 
	 * else so the only possibility is deleting from t
	 * 
	 * m!=n
	 * Only last char different. eg."abcd" "abc". Rule out equal case "abc"
	 * "abc"
	 */
	public boolean isOneEditDistance(String s, String t) {
		int m = s.length(), n = t.length();
		if (Math.abs(m - n) > 1)
			return false;
		for (int i = 0; i < Math.min(m, n); i++) {
			if (s.charAt(i) == t.charAt(i))
				continue;
			if (m == n)
				return s.substring(i + 1).equals(t.substring(i + 1));
			if (m > n)
				return s.substring(i + 1).equals(t.substring(i));
			else
				return s.substring(i).equals(t.substring(i + 1));
		}
		return m != n;
	}
}
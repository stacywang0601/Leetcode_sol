package B08_13;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while preserving the order
 * of characters. No two characters may map to the same character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * Note:
 * You may assume both s and t have the same length.
 */
public class Leet205IsomorphicStrings {
	/** "+1" is to exclude 0 from valid index. */
	public boolean isIsomorphic(String s1, String s2) {
		int[] m1 = new int[256];
		int[] m2 = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			if (m1[s1.charAt(i)] != m2[s2.charAt(i)])
				return false;
			m1[s1.charAt(i)] = m2[s2.charAt(i)] = i + 1;
		}
		return true;
	}

	/** initialzing the array as -1, and simply keep i in the array */
	public boolean isIsomorphic2(String s1, String s2) {
		int[] m1 = new int[256];
		int[] m2 = new int[256];
		for (int i = 0; i < 256; i++) {
			m1[i] = m2[i] = -1;
		}
		for (int i = 0; i < s1.length(); i++) {
			if (m1[s1.charAt(i)] != m2[s2.charAt(i)])
				return false;
			m1[s1.charAt(i)] = m2[s2.charAt(i)] = i;
		}
		return true;
	}
}
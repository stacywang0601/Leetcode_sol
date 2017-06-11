package B06_11;

/** Write a function to find the longest common prefix string amongst an array of strings. */
import java.util.Arrays;

public class Leet014LongestCommonPrefix {
	/**
	 * Sort the array first, and then you can simply compare the first and last elements in the
	 * sorted array.
	 */
	public String longestCommonPrefix(String[] strs) {
		StringBuilder result = new StringBuilder();

		if (strs != null && strs.length > 0) {
			/**
			 * Let s be the length of the longest string
			 * Let a be the length of the array
			 * Sort array O(aloga) BUT need to compare the strings, each comparison O(s)
			 * Total: O(as log a)
			 * */
			Arrays.sort(strs);

			char[] a = strs[0].toCharArray();
			char[] b = strs[strs.length - 1].toCharArray();

			for (int i = 0; i < a.length; i++) {
				if (b.length > i && b[i] == a[i]) {
					result.append(b[i]);
				} else {
					return result.toString();
				}
			}
		}
		return result.toString();
	}
}
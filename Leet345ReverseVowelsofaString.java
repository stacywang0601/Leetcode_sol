/**
 * 345. Reverse Vowels of a String Write a function that takes a string as input
 * and reverse only the vowels of a string.
 * Example 1: Given s = "hello", return "holle".
 * Example 2: Given s = "leetcode", return "leotcede".
 * Note: The vowels does not include the letter "y".
 **/
package B06_14;

public class Leet345ReverseVowelsofaString {
	/**
	 * Two pointers
	 * One from left, one from right,
	 * Once they hit vowels, swap
	 * i < j, indexOf
	 **/
	public String reverseVowels(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String vowel = "aeiouAEIOU";
		char[] c = s.toCharArray();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			// i < j
			while (i < j && vowel.indexOf(c[i]) == -1) {
				i++;
			}
			// i < j
			while (i < j && vowel.indexOf(c[j]) == -1) {
				j--;
			}
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
			i++;
			j--;
		}
		return new String(c);
	}
}

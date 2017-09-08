package B09_08;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and
 * ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an
 * interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
class Leet125ValidPalindrome {

	public boolean isPalindrome(String s) {
		if (s == null || s.length() < 2)
			return true;
		char[] str = s.toCharArray();
		int start = 0, end = str.length - 1;
		while (start <= end) {
			while (start < end && !Character.isLetterOrDigit(str[start]))
				start++;
			while (start < end && !Character.isLetterOrDigit(str[end]))
				end--;
			if (Character.toLowerCase(str[start]) != Character.toLowerCase(str[end]))
				return false;
			start++;
			end--;
		}
		return true;

	}
}
package B07_14;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 
 * 1. 1
 * 2. 11
 * 3. 21
 * 4. 1211
 * 5. 111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * Example 1:
 * 
 * Input: 1
 * Output: "1"
 * Example 2:
 * 
 * Input: 4
 * Output: "1211"
 */
public class Leet038CountandSay {
	public String countAndSay(int n) {
		String result = "1";
		for (int i = 1; i < n; ++i) {
			String temp = result;
			result = helper(temp);
		}
		return result;
	}

	public String helper(String temp) {
		StringBuilder sb = new StringBuilder();
		char say = temp.charAt(0);
		int count = 1;
		for (int i = 1; i < temp.length(); ++i) {
			if (temp.charAt(i) == say)
				count++;
			else {
				sb.append(count).append(say);
				count = 1;
				say = temp.charAt(i);
			}
		}
		// last!
		sb.append(count).append(say);
		return sb.toString();
	}
}
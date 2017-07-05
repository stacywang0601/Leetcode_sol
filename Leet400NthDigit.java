package B07_05;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * Example 1:
 * Input: 3
 * Output:3
 * Example 2:
 * Input: 11
 * Output: 0
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of
 * the number 10.
 */
public class Leet400NthDigit {
	/**
	 * find the length of the number where the nth digit is from
	 * find the actual number where the nth digit is from
	 * find the nth digit and return
	 * 1-9--------1*9=9
	 * 10-99------2*90=180
	 * 100-999----3*900=2700
	 * start next start
	 * 
	 */
	public int findNthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}
		// n-1 from 9-10
		start += (n - 1) / len;
		String s = String.valueOf(start);
		/**
		 * Integer.valueOf returns an Integer.
		 * Integer.parseInt returns an int.
		 */
		return Integer.parseInt(String.valueOf(s.charAt((n - 1) % len)));
	}
}
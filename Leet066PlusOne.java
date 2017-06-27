/**
 * 66. Plus One
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 **/
package B06_26;

public class Leet066PlusOne {
	public int[] plusOne(int[] digits) {
		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			// 0-8 +1 return
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			// 9--0, next digit +1 return
			digits[i] = 0;
		}
		// all 9, 1000
		int[] newDigits = new int[n + 1];
		newDigits[0] = 1;
		return newDigits;
	}

}

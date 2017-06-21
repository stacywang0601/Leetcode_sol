/**
 * 263. Ugly Number
 * Write a program to check whether a given number is an ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another
 * prime factor 7.
 * 
 * Note that 1 is typically treated as an ugly number.
 * 
 **/

package B06_21;

public class Leet263UglyNumber {
	/** include 4 for consise code */
	public boolean isUgly(int num) {
		// handle 0 and negative number
		if (num <= 0) {
			return false;
		}
		for (int i = 2; i < 6 && num > 0; i++) {
			// while
			while (num % i == 0) {
				num /= i;
			}
		}
		return num == 1;
	}

}

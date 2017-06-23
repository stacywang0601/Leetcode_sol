package B06_24;

/**
 * Given a positive integer, output its complement number. The complement
 * strategy is to flip the bits of its binary representation.
 * 
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed
 * integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits),
 * and its complement is 010. So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and
 * its complement is 0. So you need to output 0.
 */
public class Leet476NumberComplement {

	/**
	 * (1 << valid) - 1 ----> mask
	 * eg valid=3，1<<valid is 1000，-1 is 0000111。
	 **/
	/*
	 * Method1
	 * Integer.highestOneBit
	 */
	public int findComplement(int num) {
		return ~num & ((Integer.highestOneBit(num) << 1) - 1);
	}

	/*
	 * Method2
	 * check valid position
	 */
	public int findComplement2(int num) {
		int temp = num;
		int valid = 0;
		while (temp > 0) {
			temp /= 2;
			valid++;
		}
		int mask = (1 << valid) - 1;
		return ~num & mask;
	}

}

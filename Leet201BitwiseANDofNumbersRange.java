package B06_17;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in
 * this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 */
public class Leet201BitwiseANDofNumbersRange {
	/**
	 * last bit of (odd number & even number) is 0.
	 * when m != n, There is at least an odd number and an even number, so the last bit position
	 * result is 0.
	 * Move m and n right a position.
	 * Keep doing step 1,2,3 until m equal to n, use a factor to record the iteration time.
	 * this problem is asking us to find the common prefix of m and n 's binary code.
	 */
	public int rangeBitwiseAnd(int m, int n) {
		int step = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			step++;
		}
		return m << step;
	}
}
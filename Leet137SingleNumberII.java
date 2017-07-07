package B07_07;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 */
public class Leet137SingleNumberII {
	/**
	 * move right to add
	 * mod 3
	 * move left
	 */

	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int n : nums) {
				count += (n >> i) & 1;
			}
			res += (count % 3) << i;
		}
		return res;
	}

}

package B09_06;

/**
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued
 * number. Return the maximum valued number you could get.
 * 
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 */
class Leet670MaximumSwap {
	/**
	 * Use buckets to record the last position of digit 0 ~ 9 in this num.
	 * 
	 * Loop through the num array from left to right. For each position, we check whether there
	 * exists a larger digit in this num (start from 9 to current digit). We also need to make sure
	 * the position of this larger digit is behind the current one. If we find it, simply swap these
	 * two digits and return the result.
	 */
	public int maximumSwap(int num) {
		char[] digits = String.valueOf(num).toCharArray();
		int[] bucket = new int[10];
		for (int i = 0; i < digits.length; i++) {
			bucket[digits[i] - '0'] = i;
		}
		for (int i = 0; i < digits.length; i++) {
			for (int k = 9; k > digits[i] - '0'; k--) {
				if (bucket[k] > i) {
					char temp = digits[i];
					digits[i] = digits[bucket[k]];
					digits[bucket[k]] = temp;
					return Integer.valueOf(new String(digits));
				}
			}
		}
		return num;

	}
}
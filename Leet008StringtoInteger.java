package B05_29;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 **/
public class Leet008StringtoInteger {
	/** Method1: use long **/
	public int myAtoi(String str) {
		str = str.trim();
		char[] c = str.toCharArray();
		int i = 0;
		int len = str.length();
		// empty
		if (len == 0) {
			return 0;
		}
		// sign
		int sign = 1;
		if (c[i] == '+' || c[i] == '-') {
			sign = c[i] == '+' ? 1 : -1;
			i++;
		}
		// digit and overflow
		long num = 0;
		while (i < c.length && c[i] >= '0' && c[i] <= '9') {
			int digit = c[i] - '0';
			num = num * 10 + digit;
			if (num > Integer.MAX_VALUE) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			i++;
		}
		// if "+-", goes here directly
		return (int) (sign * num);
	}

	/**
	 * Method2: use int check bound
	 * INT_MAX (2147483647) or INT_MIN (-2147483648)
	 * bound == 214748364
	 */
	public int myAtoi2(String str) {
		str = str.trim();
		char[] c = str.toCharArray();
		int i = 0;
		int len = str.length();

		if (len == 0) {
			return 0;
		}

		int sign = 1;
		if (c[i] == '+' || c[i] == '-') {
			sign = c[i] == '+' ? 1 : -1;
			i++;
		}

		int num = 0;
		int bound = Integer.MAX_VALUE / 10;
		while (i < c.length && c[i] >= '0' && c[i] <= '9') {
			int digit = c[i] - '0';

			if (num > bound || (num == bound && digit > 7)) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}
		return sign * num;
	}
}
package B07_13;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit. For example: Given num = 38, the process is like:
 * 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */
public class Leet258AddDigits {
	/**
	 * recursive
	 * String.valueOf
	 */
	public int addDigits(int num) {
		int sum = 0;
		String s = String.valueOf(num);
		for (int i = 0; i < s.length(); i++) {
			sum += (s.charAt(i) - '0');
		}
		if (sum < 10) {
			return sum;
		} else {
			return addDigits(sum);
		}

	}

	/**
	 * ABCDE=A*10000+B*1000+C*100+D*10+E=(A+B+C+D+E)+(A*9999+B*
	 * 999+C*99+D*9)
	 * ABCDE%9=(A+B+C+D+E)%9，
	 * but if (A+B+C+D+E) = 9， ABCDE%9=0。
	 * so(num - 1) % 9 + 1;
	 */
	public int addDigits2(int num) {
		return (num - 1) % 9 + 1;
	}

}
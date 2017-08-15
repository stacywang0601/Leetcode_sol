package B08_15;

/**
 * Implement pow(x, n).
 */
public class Leet050myPow {
	/**
	 * 递归，二分法；
	 * 如果 n < 0--> n = -n， x = 1 / x ，
	 * n = Intege.MIN_VALUE，n = -n 会出现溢出
	 * n / 2 赋值给 t，再将 t = -n，就不会出现溢出问题
	 **/
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		if (x == 0.0) {
			return 0.0;
		}
		int t = 0;
		// 处理溢出问题
		if (n < 0) {
			t = -(n / 2);
			x = 1.0 / x;
		} else {
			t = n / 2;
		}

		double temp = myPow(x, t);
		// 如果不整出2，还要称一下x
		return (n % 2 == 0) ? (temp * temp) : (temp * temp * x);

	}
}

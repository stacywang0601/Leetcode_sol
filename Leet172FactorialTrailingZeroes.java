/**
 * 172. Factorial Trailing Zeroes
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.x
 * 这里我们要求n!末尾有多少个0，因为我们知道0是2和5相乘得到的，而在1到n这个范围内，2的个数要远多于5的个数，所以这里只需计算从1到n这个范围内有多少个5就可以了。
 * n=25。与例1相同，计算n/5，可以得到5个5，分别来自其中的5, 10, 15, 20, 25，但是在25中其实是包含2个5的，这一点需要注意。
 * 所以除了计算n/5， 还要计算n/5/5, n/5/5/5, n/5/5/5/5, ..., n/5/5/5,,,/5直到商为0，然后就和，就是最后的结果。
 **/

package B07_19;

public class Leet172FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		if (n <= 0)
			return 0;
		int count = 0;
		while (n > 0) {
			// 125 有 25 个5， 25 还有5 个5
			count += n / 5;
			n /= 5;
		}
		return count;
	}

}

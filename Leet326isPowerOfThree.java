package B07_20;

/**
 * 326. Power of Three Given an integer, write a function to determine if it is
 * a power of three.
 * 
 * Follow up: Could you do it without using any loop / recursion?
 **/
public class Leet326isPowerOfThree {
	/** 1--循环除3－－21ms **/
	public boolean isPowerOfThree1(int n) {
		if (n <= 0) {
			return false;
		}
		while (n % 3 == 0) {
			n = n / 3;
		}
		return n == 1;
	}

	/** 2--任何一个3的x次方一定能被int型里最大的3的x次方整除 3^19--31ms */
	public boolean isPowerOfThree2(int n) {
		return n > 0 && (1162261467 % n == 0);
	}

	/**
	 * 3--log.如果n是3的x次方，那么以3为低对数后一定是一个整数--21ms
	 * But be careful here, you cannot use
	 * log (natural log) here, because it will generate round off error for
	 * n=243. This is more like a coincidence. I mean when n=243, we have the
	 * following results:
	 * 
	 * log(243) = 5.493061443340548 log(3) = 1.0986122886681098 ==>
	 * log(243)/log(3) = 4.999999999999999
	 * 
	 * log10(243) = 2.385606273598312 log10(3) = 0.47712125471966244 ==>
	 * log10(243)/log10(3) = 5.0
	 * This happens because log(3) is actually
	 * slightly larger than its true value due to round off, which makes the
	 * ratio smaller.
	 * 
	 */
	public boolean isPowerOfThree3(int n) {
		return (Math.log10(n) / Math.log10(3)) % 1 == 0;
	}

}

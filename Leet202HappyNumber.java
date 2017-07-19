package B07_19;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 * Write an algorithm to determine if a number is "happy". A
 * happy number is a number defined by the following process: Starting with any
 * positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), or it
 * loops endlessly in a cycle which does not include 1. Those numbers for which
 * this process ends in 1 are happy numbers. Example: 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class Leet202HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		// n不为1，为1就是可以跳出循环，并且n的值不能重复出现，否则会死循环
		while (n != 1 && !set.contains(n)) {
			set.add(n);
			n = getNext(n);
		}
		return n == 1;
	}

	/** 一次等式计算的过程，取个位，平方，取十位，平方 加和 */
	public int getNext(int n) {
		int res = 0;
		while (n > 0) {
			int temp = n % 10;
			n /= 10;
			res += temp * temp;
		}
		return res;
	}

}

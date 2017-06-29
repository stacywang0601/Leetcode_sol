package B06_28;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * Hint:
 * No scary math, just apply elementary math knowledge. Still remember how to
 * perform a long division?
 * Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do
 * you see a pattern?
 * Be wary of edge cases! List out as many test cases as you can think of and
 * test your code thoroughly.
 */
public class Leet166FractiontoRecurringDecimal {
	/**
	 * use a map to store num and res.length()
	 * sign
	 * long abs (long)
	 * First before .
	 * then after .
	 * first put it into map
	 * then num *= 10
	 * divide, append
	 * if contains,
	 * insert ()
	 **/
	public String fractionToDecimal(int numerator, int denominator) {
		// 0 case
		if (numerator == 0) {
			return "0";
		}
		StringBuilder res = new StringBuilder();
		// sign
		String sign = ((numerator > 0) ^ (denominator > 0) ? "-" : "");
		res.append(sign);

		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);

		res.append(num / den);
		num %= den;
		if (num == 0) {
			return res.toString();
		}

		res.append(".");
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();

		while (num != 0) {
			// put into map first
			map.put(num, res.length());
			// *10
			num *= 10;
			res.append(num / den);
			num %= den;

			if (map.containsKey(num)) {
				int index = map.get(num);
				// insert!
				res.insert(index, "(");
				res.append(")");
				// break!
				break;
			}

		}
		return res.toString();
	}
}

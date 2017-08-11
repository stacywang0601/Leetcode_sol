package B08_11;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces
 * . The integer division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 */

public class Leet227BasicCalculatorII {
	/**
	 * add + at the end to handle the last number
	 * perform multiplication and division first, keep tracking multiend
	 * clear curNum and update last sign every cycle
	 */
	public int calculate(String s) {
		// add + at the end to handle the last number
		s = s + "+";
		char[] expr = s.toCharArray();
		int res = 0, multiend = 0;
		int curNum = 0;
		// last sign!!!
		char lastSign = '+';
		for (char c : expr) {
			if (c == ' ')
				continue;
			if (c >= '0' && c <= '9')
				curNum = curNum * 10 + c - '0';
			else {
				if (lastSign == '+') {
					res += curNum;
					multiend = curNum;
				} else if (lastSign == '-') {
					res -= curNum;
					multiend = -curNum;
				} else if (lastSign == '*') {
					res = res - multiend + multiend * curNum;
					multiend = multiend * curNum;
				} else {
					res = res - multiend + multiend / curNum;
					multiend = multiend / curNum;
				}
				// clear curNum and update last sign
				curNum = 0;
				lastSign = c;
			}
		}
		return res;
	}
}
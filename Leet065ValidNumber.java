package B05_29;

/**
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all
 * requirements up front before implementing one.
 */
public class Leet065ValidNumber {
	/**
	 * isNumber(s)==true if and only if s=s1 or s1+'e'+s2, where s1, s2
	 * are valid strings of a number without the char 'e', and s2 is an
	 * integer.
	 * 
	 * ' ' : valid_count=0~n; must appear at two ends
	 * '+/-' : valid_count=0~1; must be the first non-space valid char or the first one after e;
	 * [boolean hasFirst]
	 * '.' : valid_count=0~1; cannot appear after 'e'; [boolean hasDot]
	 * 
	 * special cases
	 * test(4, "0123", true);
	 * test(5, "00", true);
	 * test(13, "0.", true);
	 * test(14, "00.5", true);
	 * test(25, ".1", true);
	 * test(27, "2e0", true);
	 * test(29, " 005047e+6", true);
	 */

	public boolean isNumber(String s) {
		// space at two ends
		s = s.trim();
		int n = s.length();
		if (n == 0)
			return false;

		boolean hasDigit, hasE, hasFirst, hasDot;
		hasDigit = hasE = hasFirst = hasDot = false;

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				hasFirst = true;
				hasDigit = true;
				continue;
			}

			switch (c) {
			case 'e':
				if (hasE || !hasDigit) {
					return false;
				}
				hasE = true;
				// reset for exponent number!!!
				hasDigit = hasFirst = false;
				// the exponent must be an integer ,so cannot have hasDot
				hasDot = true;
				continue;
			case '.':
				if (hasDot) {
					return false;
				}
				hasDot = hasFirst = true;
				continue;
			case '+':
			case '-':
				if (hasFirst) {
					return false;
				}
				hasFirst = true;
				continue;
			default:
				return false;
			}
		}
		return hasDigit;

	}

}

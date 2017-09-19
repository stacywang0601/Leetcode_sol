package B09_19;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to
 * check whether this string is valid. We define the validity of a string by these rules:
 * 
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an
 * empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 */
class Leet678ValidParenthesisString {
	/**
	 * When checking whether the string is valid, we only cared about the "balance": the number of
	 * extra, open left brackets as we parsed through the string. For example, when checking whether
	 * '(()())' is valid, we had a balance of 1, 2, 1, 2, 1, 0 as we parse through the string: '('
	 * has 1 left bracket, '((' has 2, '(()' has 1, and so on. This means that after parsing the
	 * first i symbols, (which may include asterisks,) we only need to keep track of what the balance
	 * could be.
	 * 
	 * For example, if we have string '(***)', then as we parse each symbol, the set of possible
	 * values for the balance is [1] for '('; [0, 1, 2] for '(*'; [1, 2, 3] for '(**'; [0, 1, 2, 3,
	 * 4] for '(***', and [0, 1, 2, 3] for '(***)'.
	 * 
	 * Furthermore, we can prove these states always form a contiguous interval. Thus, we only need
	 * to know the left and right bounds of this interval. That is, we would keep those intermediate
	 * states described above as [lo, hi] = [1, 1], [0, 2], [1, 3], [0, 4], [0, 3].
	 */
	public boolean checkValidString(String s) {
		int lo = 0, hi = 0;
		for (char c : s.toCharArray()) {
			lo += c == '(' ? 1 : -1;
			hi += c != ')' ? 1 : -1;
			if (hi < 0)
				break;
			lo = Math.max(lo, 0);
		}
		return lo == 0;
	}
}
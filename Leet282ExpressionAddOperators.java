package B08_11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add
 * binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * 
 * Examples:
 * "123", 6 -> ["1+2+3", "1*2*3"]
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 */

public class Leet282ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> ret = new LinkedList<>();
		if (num.length() == 0)
			return ret;
		char[] path = new char[num.length() * 2 - 1];
		char[] digits = num.toCharArray();
		long n = 0;
		for (int i = 0; i < digits.length; i++) {
			n = n * 10 + digits[i] - '0';
			path[i] = digits[i];
			dfs(ret, path, i + 1, 0, n, digits, i + 1, target);
			if (n == 0)
				break;
		}
		return ret;
	}

	public void dfs(List<String> ret, char[] path, int len, long left, long cur, char[] digits, int pos,
	            int target) {
		if (pos == digits.length) {
			if (left + cur == target)
				ret.add(new String(path, 0, len));
			return;
		}
		long n = 0;
		int j = len + 1;
		for (int i = pos; i < digits.length; i++) {
			n = n * 10 + digits[i] - '0';
			path[j++] = digits[i];
			path[len] = '+';
			dfs(ret, path, j, left + cur, n, digits, i + 1, target);
			path[len] = '-';
			dfs(ret, path, j, left + cur, -n, digits, i + 1, target);
			path[len] = '*';
			dfs(ret, path, j, left, cur * n, digits, i + 1, target);
			if (digits[pos] == '0')
				break;
		}
	}

	/** stringbuilder; save the value that is to be multiplied in the next recursion */

	public List<String> addOperators2(String num, int target) {
		List<String> result = new ArrayList<String>();
		// overflow: we use a long type
		dfs(result, num, 0, new StringBuilder(), 0, 0, target);
		return result;
	}

	private void dfs(List<String> result, String num, int index, StringBuilder current, long total,
	            long lastTotal, int target) {
		if (index == num.length()) {
			if (total == target) {
				result.add(current.toString());
			}
			return;
		}
		for (int i = index; i < num.length(); i++) {
			// have numbers with multiple digits started with zero
			if (i != index && num.charAt(index) == '0') {
				break;
			}
			long value = Long.parseLong(num.substring(index, i + 1));
			if (index == 0) {
				current.append(value);
				dfs(result, num, i + 1, current, value, value, target);
				current.setLength(current.length() - (i + 1 - index));
			} else {
				current.append("+").append(value);
				dfs(result, num, i + 1, current, total + value, value, target);
				current.setLength(current.length() - (i + 2 - index));
				current.append("-").append(value);
				dfs(result, num, i + 1, current, total - value, -value, target);
				current.setLength(current.length() - (i + 2 - index));
				current.append("*").append(value);
				dfs(result, num, i + 1, current, total - lastTotal + lastTotal * value, lastTotal * value,
				            target);
				current.setLength(current.length() - (i + 2 - index));
			}
		}
	}
}
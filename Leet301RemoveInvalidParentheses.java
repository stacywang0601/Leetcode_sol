package B06_21;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return
 * all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and ).
 * 
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
import java.util.ArrayList;
import java.util.List;

public class Leet301RemoveInvalidParentheses {
	/**
	 *
	 * counter++ when ‘(‘;
	 * counter-- when ‘)’.
	 * counter < 0, more ‘)’ than ‘(‘
	 * 
	 * remove a ‘)’ if remove any one-> duplicate results
	 * Thus, remove the first ) in a series of consecutive ')'s.
	 * 
	 * After the removal, the prefix is then valid.
	 * Call the function recursively to solve the rest of the string.
	 * However, we need to keep another information: the last removal position last_j
	 * If we do not have this position, we will generate duplicate by removing two ‘)’ in
	 * two steps only with a different order.
	 * For this, we keep tracking last_j and only remove ‘)’ after that.
	 * 
	 * For more '('
	 * reverse the string and reuse the code!
	 */
	public List<String> removeInvalidParentheses(String s) {
		List<String> ans = new ArrayList<>();
		StringBuilder sb = new StringBuilder(s);
		remove(sb, ans, 0, 0, new char[] { '(', ')' });
		return ans;
	}

	public void remove(StringBuilder s, List<String> ans, int last_i, int last_j, char[] par) {
		// only remove ‘)’ after last_i
		for (int stack = 0, i = last_i; i < s.length(); ++i) {
			if (s.charAt(i) == par[0])
				stack++;
			if (s.charAt(i) == par[1])
				stack--;
			if (stack >= 0)
				continue;
			for (int j = last_j; j <= i; ++j)

				if (s.charAt(j) == par[1] && (j == 0 || s.charAt(j - 1) != par[1])) {
					StringBuilder sb = new StringBuilder();
					sb.append(s.substring(0, j));
					sb.append(s.substring(j + 1, s.length()));
					remove(sb, ans, i, j, par);
				}

			return;
		}
		StringBuilder reversed = new StringBuilder(s).reverse();
		if (par[0] == '(') // finished left to right
			remove(reversed, ans, 0, 0, new char[] { ')', '(' });
		else
			// finished right to left
			ans.add(reversed.toString());
	}

}

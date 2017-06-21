package B06_21;

import java.util.LinkedList;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid
 * (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has
 * length = 4.
 **/
public class Leet032LongestValidParentheses {
	/** only update the result (max) when we find a "pair" */
	public int longestValidParentheses(String s) {
		LinkedList<Integer> stack = new LinkedList<>();
		int result = 0;
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
				stack.pop();
				result = Math.max(result, i - stack.peek());
			} else {
				stack.push(i);
			}
		}
		return result;
	}
}
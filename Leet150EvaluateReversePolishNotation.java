package B07_18;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression. Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Leet150EvaluateReversePolishNotation {
	/**
	 * Using a stack. We can loop through each
	 * element in the given array. When it is a number, push it to the stack.
	 * When it is an operator, pop two numbers from the stack, do the
	 * calculation, and push back the result.
	 * 
	 * String has method contains!
	 * parseInt
	 * switch() break!!!
	 */
	public int evalRPN(String[] tokens) {
		String operators = "+-*/";
		Stack<Integer> stack = new Stack<Integer>();

		for (String token : tokens) {
			if (!operators.contains(token)) {
				stack.push(Integer.parseInt(token));
			} else {
				int a = stack.pop();
				int b = stack.pop();

				switch (token) {
				case "+":
					stack.push(a + b);
					break;
				case "-":
					stack.push(b - a);
					break;
				case "*":
					stack.push(a * b);
					break;
				case "/":
					stack.push(b / a);
					break;
				}
			}
		}
		return stack.pop();
	}
}

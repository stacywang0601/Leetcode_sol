package B06_02;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's
 * and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 6.
 */
public class Leet085MaximalRectangle {
	/**
	 * This question is similar as 084 [Largest Rectangle in Histogram]:
	 * 
	 * Maintain a row length of Integer array H recorded its height of '1's,
	 * scan and update row by row to find out the largest rectangle of each row.
	 * 
	 * For each row, if matrix[row][i] == '1'. H[i] +=1, or reset the H[i] to 0.
	 * According to the algorithm of [Largest Rectangle in Histogram], to update the maximum area.
	 */
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int cLen = matrix[0].length;    // column length
		int rLen = matrix.length;       // row length
		// height array
		int[] h = new int[cLen + 1];
		// last one set here
		h[cLen] = 0;
		int max = 0;

		for (int row = 0; row < rLen; row++) {
			// stack for each row
			Stack<Integer> s = new Stack<Integer>();
			for (int i = 0; i < cLen + 1; i++) {
				if (i < cLen) {
					// update height according matrix
					if (matrix[row][i] == '1')
						h[i] += 1;
					else
						h[i] = 0;

				}
				// inside row: same as 84
				while (!s.isEmpty() && h[i] <= h[s.peek()]) {
					int height = h[s.pop()];
					int w = s.isEmpty() ? i : (i - s.peek() - 1);
					int area = height * w;
					max = Math.max(max, area);
				}
				s.push(i);

			}
		}
		return max;
	}

	public int maximalRectangle2(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int cLen = matrix[0].length;
		int rLen = matrix.length;
		int[] h = new int[cLen + 1];
		h[cLen] = 0;
		int max = 0;

		for (int row = 0; row < rLen; row++) {
			Stack<Integer> s = new Stack<Integer>();
			// no need check empty later
			s.push(-1);
			for (int i = 0; i < cLen + 1; i++) {
				if (i < cLen) {
					if (matrix[row][i] == '1')
						h[i] += 1;
					else
						h[i] = 0;

				}
				// size() >1 instead of empty
				while (s.size() > 1 && h[i] <= h[s.peek()]) {
					int height = h[s.pop()];
					// (i - s.peek() - 1) for all cases
					int area = height * (i - s.peek() - 1);
					max = Math.max(max, area);
				}
				s.push(i);

			}
		}
		return max;
	}
}
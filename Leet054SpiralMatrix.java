package B07_11;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral
 * order.
 * 
 * For example,
 * Given the following matrix:
 * 
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class Leet054SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		int m = matrix.length - 1;// row
		int n = matrix[0].length - 1;// col
		int i = 0;
		int j = 0;
		while (i <= m && j <= n) {
			// right traverse
			for (int k = j; k <= n; k++) {
				result.add(matrix[i][k]);
			}
			i++;
			// down traverse
			for (int k = i; k <= m; k++) {
				result.add(matrix[k][n]);
			}
			n--;
			// left traverse
			if (i <= m) {// check whether the row still exists to prevent duplicates
				for (int k = n; k >= j; k--) {
					result.add(matrix[m][k]);
				}
				m--;
			}
			// up traverse
			if (j <= n) {// check whether the col still exists to prevent duplicates
				for (int k = m; k >= i; k--) {
					result.add(matrix[k][j]);
				}
				j++;
			}
		}
		return result;
	}
}

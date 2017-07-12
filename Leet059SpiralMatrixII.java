package B07_11;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example,
 * Given n = 3,
 * 
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 **/
public class Leet059SpiralMatrixII {
	/** same as 54 */
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		if (n == 0) {
			return matrix;
		}

		int rowEnd = n - 1;// row
		int colEnd = n - 1;// col
		int i = 0;// row start
		int j = 0;// col start
		int num = 1;

		while (i <= rowEnd && j <= colEnd) {
			// right traverse
			for (int k = j; k <= colEnd; k++) {
				matrix[i][k] = num++;
			}
			i++;
			// down traverse
			for (int k = i; k <= rowEnd; k++) {
				matrix[k][colEnd] = num++;
			}
			colEnd--;
			// left traverse
			if (i <= rowEnd) {// check whether the row still exists to prevent duplicates
				for (int k = colEnd; k >= j; k--) {
					matrix[rowEnd][k] = num++;
				}
				rowEnd--;
			}
			// up traverse
			if (j <= colEnd) {// check whether the col still exists to prevent duplicates
				for (int k = rowEnd; k >= i; k--) {
					matrix[k][j] = num++;
				}
				j++;
			}
		}
		return matrix;
	}

}

package B08_12;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties: Integers in each row are sorted
 * from left to right. The first integer of each row is greater than the last
 * integer of the previous row. For example, Consider the following matrix: [
 * [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3, return
 * true.
 */

public class Leet074Searcha2DMatrix {
	/**
	 * You may try to solve this problem by finding the row first and then the
	 * column. There is no need to do that. Because of the matrix's special
	 * features, the matrix can be considered as a sorted array. Your goal is to
	 * find one element in this sorted array by using binary search.
	 */
	public boolean searchMatrix(int[][] matrix, int target) {

		int row = matrix.length;
		int col = matrix[0].length;
		// last item index
		int h = row * col - 1;
		int l = 0;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (matrix[mid / col][mid % col] == target) {
				return true;
			} else if (matrix[mid / col][mid % col] > target) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return false;
	}
}

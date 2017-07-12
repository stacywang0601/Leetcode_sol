package B07_11;

/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class Leet052NQueensII {
	int	count;

	public int totalNQueens(int n) {
		int[] columnVal = new int[n];
		dfs(n, 0, columnVal);
		return count;
	}

	private void dfs(int n, int row, int[] columnVal) {
		if (row == n) {
			count++;
			return;
		}
		for (int i = 0; i < n; i++) {
			columnVal[row] = i;
			if (isValid(columnVal, row))
				dfs(n, row + 1, columnVal);
		}
	}

	private boolean isValid(int[] columnVal, int row) {
		for (int i = 0; i < row; i++) {
			if (columnVal[row] == columnVal[i] || Math.abs(columnVal[row] - columnVal[i]) == row - i)
				return false;
		}
		return true;
	}
}
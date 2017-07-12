package B07_11;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two
 * queens attack each other.Given an integer n, return all distinct solutions to the n-queens
 * puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and
 * '.' both indicate a queen and an empty space respectively.
 */
import java.util.ArrayList;

public class Leet051NQueens2 {
	/**
	 * 而这道题巧就巧在，每一行只能有一个皇后，也就是说，对于一行只能有一个纵坐标值，所以用1维数组能提前帮助解决皇后不能在同一行的问题。
	 * 那么用一维数组表示的话，方法是：一维数组的下标表示横坐标（哪一行），而数组的值表示纵坐标（哪一列）。
	 * 
	 * 例如：对于一个4皇后问题，声明一个长度为4的数组（因为行数为4）。
	 * A[] = [1,0,2,3]表达含义是：
	 * 当前4个皇后所在坐标点为：[[0,1],[1,0],[2,2],[3,3]]（被我标蓝的正好是数组的下标，标粉的正好是数组的值）
	 * 相当于：A[0] = 1, A[1] = 0, A[2] = 2, A[3] = 3
	 * 这样以来，皇后所在的坐标值就能用一维数组表示了。
	 * 而正是这个一维数组，在回溯找结果的时候不需要进行remove重置操作了，因为回溯的话正好就回到上一行了，就可以再重新找下一个合法列坐标了。
	 */
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> res = new ArrayList<String[]>();
		if (n <= 0)
			return res;
		int[] columnVal = new int[n];
		dfs(n, res, 0, columnVal);
		return res;
	}

	public void dfs(int n, ArrayList<String[]> res, int row, int[] columnVal) {
		if (row == n) {
			String[] unit = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuilder s = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (j == columnVal[i])
						s.append("Q");
					else
						s.append(".");
				}
				unit[i] = s.toString();
			}

			res.add(unit);
		} else {
			for (int i = 0; i < n; i++) {
				columnVal[row] = i;
				if (isValid(row, columnVal))
					dfs(n, res, row + 1, columnVal);
			}
		}
	}

	public boolean isValid(int row, int[] columnVal) {
		for (int i = 0; i < row; i++) {
			if (columnVal[row] == columnVal[i] || Math.abs(columnVal[row] - columnVal[i]) == row - i)
				return false;
		}
		return true;
	}
}
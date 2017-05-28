package B05_27;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two
 * queens attack each other.Given an integer n, return all distinct solutions to the n-queens
 * puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and
 * '.' both indicate a queen and an empty space respectively.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet051NQueens {
	/**
	 * Go row by row!!!!!(NOT one STEP) since it has to check the whole row!
	 * Each position, we need to check if the column, the 45° diagonal and
	 * the 135° diagonal had a queen before.
	 * The number of columns is n, the number of 45° diagonals and 135° diagonals are 2n-1
	 * When reach [row, col], the column No. is col, the 45° diagonal
	 * No. is row + col and the 135° diagonal No. is n - 1 - row + col.
	 * 3 boolean[] to check
	 */
	/**    
	 *     | | |                / / /             \ \ \
	  *    O O O               O O O               O O O
	  *    | | |              / / / /             \ \ \ \
	  *    O O O               O O O               O O O
	  *    | | |              / / / /             \ \ \ \ 
	  *    O O O               O O O               O O O
	  *    | | |              / / /                 \ \ \
	  *   3 columns        5 45° diagonals     5 135° diagonals    (when n is 3)
	  */
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		dfs(0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1],
		                  new ArrayList<String>(), res);
		return res;
	}

	private void dfs(int r, boolean[] col, boolean[] diag1, boolean[] diag2,
	                  ArrayList<String> list, List<List<String>> res) {
		int n = col.length;
		if (r == n) {
			//new ! so don't be affected when remove later
			res.add(new ArrayList<String>(list));
			return;
		}

		for (int j = 0; j < n; j++) {
			int d1 = r + j;
			int d2 = n - 1 - r + j;
			if (!col[j] && !diag1[d1] && !diag2[d2]) {
				char[] row = new char[n];
				Arrays.fill(row, '.');
				row[j] = 'Q';
				list.add(r, new String(row));
				col[j] = diag1[d1] = diag2[d2] = true;
				dfs(r + 1, col, diag1, diag2, list, res);
				//remove this row
				list.remove(list.size() - 1);
				col[j] = diag1[d1] = diag2[d2] = false;
			}
		}
	}
}
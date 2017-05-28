package B05_27;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 */
public class Leet037SudokuSolver2 {
	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		// 10
		boolean[][] rows = new boolean[9][10];
		boolean[][] cols = new boolean[9][10];
		boolean[][] boxes = new boolean[9][10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0';
					rows[i][num] = true;
					cols[j][num] = true;
					boxes[i / 3 * 3 + j / 3][num] = true;	// left-up corner of box
				}
			}
		}
		dfs(board, 0, 0, rows, cols, boxes);
	}

	public boolean dfs(char[][] board, int i, int j, boolean[][] rows, boolean[][] cols, boolean[][] boxes) {
		if (i == 9 && j == 0)
			return true;
		if (board[i][j] != '.')
			return dfs(board, (j + 1) == 9 ? i + 1 : i, (j + 1) == 9 ? 0 : j + 1, rows, cols, boxes);
		for (int n = 1; n <= 9; n++) {
			if (!rows[i][n] && !cols[j][n] && !boxes[i / 3 * 3 + j / 3][n]) {
				board[i][j] = (char) (n + '0');
				rows[i][n] = cols[j][n] = boxes[i / 3 * 3 + j / 3][n] = true;
				if (dfs(board, (j + 1) == 9 ? i + 1 : i, (j + 1) == 9 ? 0 : j + 1, rows, cols, boxes))
					return true;
				rows[i][n] = cols[j][n] = boxes[i / 3 * 3 + j / 3][n] = false;
				board[i][j] = '.';
			}
		}
		return false;

	}
}

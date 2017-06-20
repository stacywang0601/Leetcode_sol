package B06_19;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need
 * to be validated.
 **/

public class Leet036ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		boolean[][] rows = new boolean[9][10];
		boolean[][] cols = new boolean[9][10];
		boolean[][] boxes = new boolean[9][10];
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				char number = board[i][j];
				if (number != '.') {
					int n = number - '0';
					int k = i / 3 * 3 + j / 3;
					if (rows[i][n] || cols[j][n] || boxes[k][n]) {
						return false;
					}
					rows[i][n] = cols[j][n] = boxes[k][n] = true;
				}
			}
		}
		return true;
	}

}

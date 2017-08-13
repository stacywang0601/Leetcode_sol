package B02_11;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands.
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
public class Leet200NumberofIslands {
      /** 碰到一个1，就把它周围所有相连的1都标记为x，这样整个遍历过程中碰到的1的个数就是所求解。 **/
      public int numIslands(char[][] grid) {
            // debug-- 必须check 否则可能下面rc都是非法
            if (grid == null || grid.length == 0) {
                  return 0;
            }

            int count = 0;
            int r = grid.length;
            int c = grid[0].length;
            for (int i = 0; i < r; i++) {
                  for (int j = 0; j < c; j++) {
                        if (grid[i][j] == '1') {
                              dfs(grid, i, j);
                              count++;
                        }

                  }
            }
            return count;
      }

      public void dfs(char[][] grid, int i, int j) {
            int r = grid.length;
            int c = grid[0].length;

            if (i < 0 || j < 0 || i >= r || j >= c || grid[i][j] != '1') {
                  return;
            }
            grid[i][j] = 'x';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
      }

}

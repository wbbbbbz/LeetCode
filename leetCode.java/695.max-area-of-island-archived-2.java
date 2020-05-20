import java.util.HashSet;

/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 *
 * https://leetcode.com/problems/max-area-of-island/description/
 *
 * algorithms
 * Medium (61.03%)
 * Likes:    1707
 * Dislikes: 75
 * Total Accepted:    141.3K
 * Total Submissions: 229.6K
 * Testcase Example:  '[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]'
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no
 * island, the maximum area is 0.)
 * 
 * Example 1:
 * 
 * 
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,1,1,0,1,0,0,0,0,0,0,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,0,1,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,1,1,0,0],
 * ⁠[0,0,0,0,0,0,0,0,0,0,1,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 
 * Given the above grid, return 6. Note the answer is not 11, because the
 * island must be connected 4-directionally.
 * 
 * Example 2:
 * 
 * 
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * 
 * Note: The length of each dimension in the given grid does not exceed 50.
 * 
 */

// @lc code=start
class Solution {
    private int R, C;
    private int[][] grid;
    private boolean[][] visited;
    private int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    // 返回grid这个图中最大的联通面积
    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null)
            return 0;
        R = grid.length;
        if (R == 0)
            return 0;
        C = grid[0].length;
        if (C == 0)
            return 0;

        this.grid = grid;

        this.visited = new boolean[R][];
        for (int i = 0; i < R; i++) {
            visited[i] = new boolean[C];
        }

        int maxIslandArea = 0;

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (grid[x][y] == 1 && !visited[x][y]) {
                    maxIslandArea = Math.max(maxIslandArea, dfs(x, y));
                }
            }
        }
        return maxIslandArea;

        // 726/726 cases passed (2 ms)
        // Your runtime beats 99.52 % of java submissions
        // Your memory usage beats 96.3 % of java submissions (39.7 MB)
    }

    // 返回以(x, y)作为顶点的图的顶点数
    private int dfs(int x, int y) {

        if (x < 0 || x >= R || y < 0 || y >= C || grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0;

        int res = 1;

        res += dfs(x - 1, y);
        res += dfs(x + 1, y);
        res += dfs(x, y - 1);
        res += dfs(x, y + 1);
        return res;
    }

}
// @lc code=end

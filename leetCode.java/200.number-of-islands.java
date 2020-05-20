/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (45.28%)
 * Likes:    5052
 * Dislikes: 190
 * Total Accepted:    681.6K
 * Total Submissions: 1.5M
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 * 
 */

// @lc code=start
class Solution {

    // floodfill解题
    // visited信息直接记录在grid上，0代表不用遍历
    // 使用dfs遍历，不借助queue
    // 四联通
    private int R, C;
    private char[][] grid;

    public int numIslands(char[][] grid) {

        if (grid == null)
            return 0;
        this.grid = grid;
        R = grid.length;
        if (R == 0)
            return 0;
        C = grid[0].length;
        if (C == 0)
            return 0;

        int islandCount = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    // 深度优先遍历
    // 直接在递归中进行越界判断
    private void dfs(int i, int j) {
        if (i < 0 || i >= R || j < 0 || j >= C || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);

        // 47/47 cases passed (1 ms)
        // Your runtime beats 99.94 % of java submissions
        // Your memory usage beats 49.3 % of java submissions (41.9 MB)
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 *
 * https://leetcode.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (33.97%)
 * Likes:    1818
 * Dislikes: 244
 * Total Accepted:    303.6K
 * Total Submissions: 878.5K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * 
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * 
 * 
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null || obstacleGrid[0] == null) {
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (n == 0 || m == 0 || obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }

        int[][] path = new int[n][m];

        boolean hasObstacle = false;

        for (int i = 0; i < n; i++) {
            if (hasObstacle){
                path[i][0] = 0;
            } else {
                if (obstacleGrid[i][0] == 1){
                    hasObstacle = true;
                    path[i][0] = 0;
                } else {
                    path[i][0] = 1;
                }
            }
        }

        hasObstacle = false;

        for (int i = 0; i < m; i++) {
            if (hasObstacle){
                path[0][i] = 0;
            } else {
                if (obstacleGrid[0][i] == 1){
                    hasObstacle = true;
                    path[0][i] = 0;
                } else {
                    path[0][i] = 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }

        return path[n - 1][m - 1];
        // 0ms, 38.8MB
    }
}
// @lc code=end

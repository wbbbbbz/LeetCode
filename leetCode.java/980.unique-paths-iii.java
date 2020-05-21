/*
 * @lc app=leetcode id=980 lang=java
 *
 * [980] Unique Paths III
 *
 * https://leetcode.com/problems/unique-paths-iii/description/
 *
 * algorithms
 * Hard (72.58%)
 * Likes:    504
 * Dislikes: 55
 * Total Accepted:    29.5K
 * Total Submissions: 40.4K
 * Testcase Example:  '[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]'
 *
 * On a 2-dimensional grid, there are 4 types of squares:
 * 
 * 
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * 
 * 
 * Return the number of 4-directional walks from the starting square to the
 * ending square, that walk over every non-obstacle square exactly once.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths: 
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths: 
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation: 
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the
 * grid.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= grid.length * grid[0].length <= 20
 * 
 */

// @lc code=start
class Solution {
    // 汉密尔顿路径问题
    // 求解所有可能的汉密尔顿路径
    // visited信息直接记在grid上，0代表需要遍历，-1代表遍历过，2代表终点
    // 点的压缩通过R*C完成

    private int R, C;
    private int[][] grid;
    private int paths; // 记录可能的路径数
    private int start; // 记录起始点
    private int end; // 记录终结点

    public int uniquePathsIII(int[][] grid) {

        if (grid == null)
            return 0;
        this.grid = grid;
        this.R = grid.length;
        if (R == 0)
            return 0;
        this.C = grid[0].length;
        if (C == 0)
            return 0;

        int left = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 0) {
                    left++;
                } else if (grid[i][j] == 1) {
                    left++;
                    grid[i][j] = 0;
                    start = i * C + j;
                } else if (grid[i][j] == 2) {
                    left++;
                    grid[i][j] = 0;
                    end = i * C + j;
                }
            }
        }
        if (left == 0)
            return 0;

        dfs(start, left);
        grid[start / C][start % C] = 1;
        grid[end / C][end % C] = 2;
        return paths;
    }

    // 汉密尔顿路径搜索
    // v：当前搜索节点，left：剩余空节点
    public boolean dfs(int v, int left) {
        int x = v / C;
        int y = v % C;
        left--;
        // System.out.println(v + " " + x + " " + y + " " + grid[x][y] + " " + left);
        if (v == end && left == 0) {
            paths++;
            return true;
        }
        int tempGrid = grid[x][y];
        grid[x][y] = -1;
        boolean res = false;

        res = ((x != 0 && grid[x - 1][y] == 0 && dfs(v - C, left))
                | (y + 1 != C && grid[x][y + 1] == 0 && dfs(v + 1, left))
                | (x + 1 != R && grid[x + 1][y] == 0 && dfs(v + C, left))
                | (y != 0 && grid[x][y - 1] == 0 && dfs(v - 1, left)));

        grid[x][y] = tempGrid;
        return res;

        // 39/39 cases passed (1 ms)
        // Your runtime beats 54.81 % of java submissions
        // Your memory usage beats 33.33 % of java submissions (37.1 MB)
    }
}
// @lc code=end

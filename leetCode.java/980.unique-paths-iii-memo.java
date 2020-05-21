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
    private int start; // 记录起始点
    private int end; // 记录终结点
    private int[][] memo; // 记录搜索结果

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

        memo = new int[1 << (R * C)][];

        for (int i = 0; i < (1 << (R * C)); i++) {
            memo[i] = new int[R * C];
            for (int j = 0; j < R * C; j++) {
                memo[i][j] = -1;
            }
        }

        grid[start / C][start % C] = 0;
        grid[end / C][end % C] = 0;
        return dfs(0, start, left);
        // return paths;
    }

    // 汉密尔顿路径搜索
    // v：当前搜索节点，left：剩余空节点
    public int dfs(int visited, int v, int left) {
        int x = v / C;
        int y = v % C;
        left--;
        visited += (1 << v);
        if (memo[visited][v] != -1) {
            return memo[visited][v];
        }
        // System.out.println(v + " " + x + " " + y + " " + grid[x][y] + " " + left);
        if (v == end && left == 0) {
            visited -= (1 << v);
            memo[visited][v] = 1;
            return 1;
        }
        // int tempGrid = grid[x][y];
        // grid[x][y] = -1;
        int res = 0;
        if (x != 0 && (visited & (1 << (v - C))) == 0 && grid[x - 1][y] == 0) {
            res += dfs(visited, v - C, left);
        }
        if (y + 1 != C && (visited & (1 << (v + 1))) == 0 && grid[x][y + 1] == 0) {
            res += dfs(visited, v + 1, left);
        }
        if (x + 1 != R && (visited & (1 << (v + C))) == 0 && grid[x + 1][y] == 0) {
            res += dfs(visited, v + C, left);
        }
        if (y != 0 && (visited & (1 << (v - 1))) == 0 && grid[x][y - 1] == 0) {
            res += dfs(visited, v - 1, left);
        }
        visited -= (1 << v);
        memo[visited][v] = res;
        return res;

    }
}
// @lc code=end

// 39/39 cases passed (635 ms)
// Your runtime beats 5.38 % of java submissions
// Your memory usage beats 6.67 % of java submissions (211.5 MB)

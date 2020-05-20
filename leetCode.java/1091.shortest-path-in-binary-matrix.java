import java.util.LinkedList;

/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 *
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
 *
 * algorithms
 * Medium (37.44%)
 * Likes:    310
 * Dislikes: 33
 * Total Accepted:    24.7K
 * Total Submissions: 65.3K
 * Testcase Example:  '[[0,1],[1,0]]'
 *
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 * 
 * A clear path from top-left to bottom-right has length k if and only if it is
 * composed of cells C_1, C_2, ..., C_k such that:
 * 
 * 
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are
 * different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] ==
 * 0).
 * 
 * 
 * Return the length of the shortest such clear path from top-left to
 * bottom-right.  If such a path does not exist, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[0,1],[1,0]]
 * 
 * 
 * Output: 2
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[0,0,0],[1,1,0],[1,1,0]]
 * 
 * 
 * Output: 4
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= grid.length == grid[0].length <= 100
 * grid[r][c] is 0 or 1
 * 
 * 
 */

// @lc code=start
class Solution {
    // 八联通问题，借用八联通矩阵
    // 不对图像进行建模
    // 使用queue数据结构
    private int[][] grid;
    private int N;
    private int[][] steps;
    private int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {

        // 初始化
        if (grid == null)
            return -1;
        this.grid = grid;
        N = grid.length;
        if (N == 0)
            return -1;
        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) {
            return -1;
        }

        steps = new int[N][];
        for (int i = 0; i < N; i++) {
            steps[i] = new int[N];
        }

        return bfs(0, 0);

        // 84/84 cases passed (32 ms)
        // Your runtime beats 19.81 % of java submissions
        // Your memory usage beats 100 % of java submissions (54.1 MB)

    }

    // 广度优先遍历搜索
    // 返回以i, j为起点到终点n-1, n-1的步数
    private int bfs(int i, int j) {

        LinkedList<Integer> queue = new LinkedList<>();
        steps[i][j] = 1;
        queue.push(i * N + j);
        while (!queue.isEmpty()) {
            int coordinate = queue.poll();
            int x = coordinate / N;
            int y = coordinate % N;
            for (int k = 0; k < 8; k++) {
                int nextX = x + dirs[k][0];
                int nextY = y + dirs[k][1];
                if (inArea(nextX, nextY) && grid[nextX][nextY] == 0 && steps[nextX][nextY] == 0) {
                    queue.add(nextX * N + nextY);
                    steps[nextX][nextY] = steps[x][y] + 1;
                }
            }
            // for (int k = 0; k < N; k++) {
            // for (int k2 = 0; k2 < N; k2++) {
            // System.out.print(steps[k][k2] + " ");
            // }
            // System.out.println();
            // }
            // System.out.println("----------------------------------");
        }

        return steps[N - 1][N - 1] == 0 ? -1 : steps[N - 1][N - 1];
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
// @lc code=end

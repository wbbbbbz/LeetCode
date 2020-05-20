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
    // grid中每一个顶点看作图的顶点
    // 如果1与1相连就形成边
    // 求的是最大顶点数的联通分量
    // 因为图像顶点是一维的，所以将二维顶点映射一维
    // 每一行首尾相连！行进制
    // (x, y) -> x * C + y
    // v -> x = v / C, y = v % C

    // 找到一个点上下左右四个方向的点：四联通问题
    // 可以拓展到八联通
    // dirs[[-1,0],[0, 1],[1, 0],[0, -1]]
    // nextx = x + dirs[d][0]

    private int R, C;
    private int vertexes;
    private int[][] grid;
    private boolean[][] visited;
    // private int maxIslandArea;
    // private boolean hasConnectedIsland;
    private int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    // 建图，每一个hashSet中含每一个点连接的点
    private HashSet<Integer>[] graph;

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
        this.vertexes = R * C;

        // graph = constructGraph();

        // if (maxIslandArea == 0)
        // return 0;
        // if (!hasConnectedIsland)
        // return 1;

        // this.visited = new boolean[vertexes];
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

        // for (int v = 0; v < vertexes; v++) {
        // if (graph[v] != null && !visited[v])
        // maxIslandArea = Math.max(maxIslandArea, dfs(v));

        // }
        return maxIslandArea;

        // 726/726 cases passed (10 ms)
        // Your runtime beats 5.43 % of java submissions
        // Your memory usage beats 96.3 % of java submissions (39.8 MB)
    }

    // // 返回以v作为顶点的图的顶点数
    // private int dfs(int v) {
    // visited[v] = true;
    // int res = 1;
    // for (int w : graph[v]) {
    // if (!visited[w]) {
    // res += dfs(w);
    // }
    // }
    // return res;
    // }

    // 返回以(x, y)作为顶点的图的顶点数
    private int dfs(int x, int y) {
        visited[x][y] = true;
        int res = 1;
        for (int j = 0; j < 4; j++) {
            int nextX = x + dirs[j][0];
            int nextY = y + dirs[j][1];
            if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                res += dfs(nextX, nextY);
            }
        }
        return res;
        // 726/726 cases passed (5 ms)
        // Your runtime beats 18.89 % of java submissions
        // Your memory usage beats 44.44 % of java submissions (45 MB)
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    // private HashSet<Integer>[] constructGraph() {
    // HashSet<Integer>[] res = new HashSet[vertexes];
    // int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    // for (int i = 0; i < vertexes; i++) {
    // int x = i / C;
    // int y = i % C;
    // for (int j = 0; j < 4; j++) {
    // int nextX = x + dirs[j][0];
    // int nextY = y + dirs[j][1];
    // if (grid[x][y] == 1) {
    // if (res[i] == null) {
    // res[i] = new HashSet<Integer>();
    // maxIslandArea = 1;
    // }
    // if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && grid[nextX][nextY]
    // == 1) {
    // res[i].add(nextX * C + nextY);
    // hasConnectedIsland = true;
    // }
    // }
    // }
    // }
    // return res;

    // }

}
// @lc code=end

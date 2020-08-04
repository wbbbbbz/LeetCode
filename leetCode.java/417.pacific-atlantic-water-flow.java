import java.util.*;
/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 *
 * algorithms
 * Medium (39.92%)
 * Likes:    1291
 * Dislikes: 261
 * Total Accepted:    77.2K
 * Total Submissions: 188.1K
 * Testcase Example:  '[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]'
 *
 * Given an m x n matrix of non-negative integers representing the height of
 * each unit cell in a continent, the "Pacific ocean" touches the left and top
 * edges of the matrix and the "Atlantic ocean" touches the right and bottom
 * edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a
 * cell to another one with height equal or lower.
 * 
 * Find the list of grid coordinates where water can flow to both the Pacific
 * and Atlantic ocean.
 * 
 * Note:
 * 
 * 
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given the following 5x5 matrix:
 * 
 * ⁠ Pacific ~   ~   ~   ~   ~ 
 * ⁠      ~  1   2   2   3  (5) *
 * ⁠      ~  3   2   3  (4) (4) *
 * ⁠      ~  2   4  (5)  3   1  *
 * ⁠      ~ (6) (7)  1   4   5  *
 * ⁠      ~ (5)  1   1   2   4  *
 * ⁠         *   *   *   *   * Atlantic
 * 
 * Return:
 * 
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with
 * parentheses in above matrix).
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {

    // testcase: [[1,2,3],[8,9,4],[7,6,5]]

    private int M;
    private int N;
    private int[][] matrix;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        // 四联通问题
        // 使用pacific和atlantic进行记录
        // -1是不连通，0是未查找，1是连通
        // 从已知是true的地方开始进行floodfill，只要能进入(高度更高的地方)就改成true即可

        List<List<Integer>> res = new LinkedList<>();

        if (matrix == null || matrix.length == 0) {
            return res;
        }

        this.M = matrix.length;
        this.N = matrix[0].length;
        this.matrix = matrix;

        boolean[][] pacific = new boolean[M][N];
        boolean[][] atlantic = new boolean[M][N];

        // 行的floodfill
        for (int i = 0; i < this.N; i++) {
            floodfill(0, i, Integer.MIN_VALUE, pacific);
            floodfill(M - 1, i, Integer.MIN_VALUE, atlantic);
        }

        // 列的floodfill
        for (int i = 0; i < this.M; i++) {
            floodfill(i, 0, Integer.MIN_VALUE, pacific);
            floodfill(i, N - 1, Integer.MIN_VALUE, atlantic);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;

        // 5ms
        // 40.6MB
    }

    private void floodfill(int i, int j, int last, boolean[][] ocean){
        if (!inArea(i, j) || last > matrix[i][j] || ocean[i][j]){
            return;
        }
        ocean[i][j] = true;
        floodfill(i + 1, j, matrix[i][j], ocean);
        floodfill(i - 1, j, matrix[i][j], ocean);
        floodfill(i, j + 1, matrix[i][j], ocean);
        floodfill(i, j - 1, matrix[i][j], ocean);
    }

    private boolean inArea(int i, int j){
        return i >= 0 && j >= 0 && i < M && j < N;
    } 

}
// @lc code=end

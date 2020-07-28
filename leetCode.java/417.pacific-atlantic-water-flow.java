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
    
    private int[][] pacific;
    private int[][] atlantic;
    private int[][] matrix;

    private int M;
    private int N;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        // 四联通问题
        // 使用pacific和atlantic进行记录
        // -1是不连通，0是未查找，1是连通
    
        List<List<Integer>> res = new LinkedList<>();
        
        if (matrix == null || matrix.length == 0){
            return res;
        }

        this.M = matrix.length;
        this.N = matrix[0].length;
        this.matrix = matrix;

        this.pacific = new int[M][];
        this.atlantic = new int[M][];

        for (int i = 0; i < M; i++) {
            this.pacific[i] = new int[N];
            this.atlantic[i] = new int[N];
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (this.pacific[i][j] == 0){
                    if (pacific(i + 1, j, matrix[i][j]) || pacific(i - 1, j, matrix[i][j])
                        || pacific(i, j + 1, matrix[i][j]) || pacific(i, j - 1, matrix[i][j]))
                        this.pacific[i][j] = 1;
                    else
                        this.pacific[i][j] = -1;
                }
                if (this.atlantic[i][j] == 0){
                    if (atlantic(i + 1, j, matrix[i][j]) || atlantic(i - 1, j, matrix[i][j])
                    || atlantic(i, j + 1, matrix[i][j]) || atlantic(i, j - 1, matrix[i][j]))
                        this.atlantic[i][j] = 1;
                    else
                        this.atlantic[i][j] = -1;
                }
                if (this.pacific[i][j] == 1 && this.atlantic[i][j] == 1){
                    res.add(Arrays.asList(i, j));
                }
                System.out.println(Arrays.toString(pacific[i]));
                System.out.println(Arrays.toString(atlantic[i]));
            }
        }

        return res;

    }

    private boolean pacific(int i, int j, int last){
        if (i < 0 || j < 0){
            return true;
        }
        if (i >= M || j >= N){
            return false;
        }
        if (matrix[i][j] > last){
            return false;
        }
        if (pacific[i][j] != 0){
            return pacific[i][j] == 1;
        }
        boolean res = pacific(i + 1, j, matrix[i][j])
                    || pacific(i - 1, j, matrix[i][j])
                    || pacific(i, j + 1, matrix[i][j])
                    || pacific(i, j - 1, matrix[i][j]);
        if (res){
            pacific[i][j] = 1;
        } else {
            pacific[i][j] = -1;
        }
        return res;
    }

    private boolean atlantic(int i, int j, int last){
        if (i >= M || j >= N){
            return true;
        }
        if (i < 0 || j < 0){
            return false;
        }
        if (matrix[i][j] > last){
            return false;
        }
        if (atlantic[i][j] != 0){
            return atlantic[i][j] == 1;
        }
        boolean res = atlantic(i + 1, j, matrix[i][j])
                    || atlantic(i - 1, j, matrix[i][j])
                    || atlantic(i, j + 1, matrix[i][j])
                    || atlantic(i, j - 1, matrix[i][j]);
        if (res){
            atlantic[i][j] = 1;
        } else {
            atlantic[i][j] = -1;
        }
        return res;
    }
}
// @lc code=end


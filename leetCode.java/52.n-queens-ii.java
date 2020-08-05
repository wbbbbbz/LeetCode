/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (56.14%)
 * Likes:    536
 * Dislikes: 156
 * Total Accepted:    135.9K
 * Total Submissions: 235.4K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {

    private int n;

    private int res;

    public int totalNQueens(int n) {
        
        if (n <= 0){
            return 0;
        }

        this.n = n;

        boolean[] col = new boolean[n];
        // 左下向右上和左上向右下的对角线各有2n-1条
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        for (int i = 0; i < n; i++) {
            helper(0, i, col, diag1, diag2);
        }

        return res;


    }

    private void helper(int i, int j, boolean[] col, boolean[] diag1, boolean[] diag2) {

        col[j] = true;
        // 左下向右上的对角线，相加为定值
        diag1[i + j] = true;
        // 左上向右下的对角线，相减为定值
        diag2[i - j + n - 1] = true;

        // System.out.println(String.format("i: %d, j: %d", i, j));
        // System.out.println(Arrays.toString(col));
        // System.out.println(Arrays.toString(diag1));
        // System.out.println(Arrays.toString(diag2));
        // for (int k = 0; k < n; k++) {
        //     System.out.println(Arrays.toString(board[k]));
        // }

        if (i == n - 1) {
            res++;
        } else {
            for (int k = 0; k < n; k++) {
                if (!col[k] && !diag1[i + 1 + k] && !diag2[i - k + n]) {
                    helper(i + 1, k, col, diag1, diag2);
                }
            }
        }
        col[j] = false;
        diag1[i + j] = false;
        diag2[i - j + n - 1] = false;

        // 1ms, 38.2MB
    }
}
// @lc code=end


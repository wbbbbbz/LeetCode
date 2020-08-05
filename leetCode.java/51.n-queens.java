import java.util.*;
/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 *
 * https://leetcode.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (44.51%)
 * Likes:    1941
 * Dislikes: 73
 * Total Accepted:    205.2K
 * Total Submissions: 442.3K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: [
 * ⁠[".Q..",  // Solution 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // Solution 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as
 * shown above.
 * 
 * 
 */

// @lc code=start
class Solution {

    List<List<String>> res = new LinkedList<>();

    int n;

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return res;
        }

        this.n = n;

        // for (int i = 0; i < n; i++) {
        // helper(0, i, new boolean[n * n]);
        // }

        // return res;

        boolean[] col = new boolean[n];
        // 左下向右上和左上向右下的对角线各有2n-1条
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        for (int i = 0; i < n; i++) {
            solution2(0, i, col, diag1, diag2, board);
        }

        return res;
    }

    private void solution2(int i, int j, boolean[] col, boolean[] diag1, boolean[] diag2, char[][] board) {

        col[j] = true;
        // 左下向右上的对角线，相加为定值
        diag1[i + j] = true;
        // 左上向右下的对角线，相减为定值
        diag2[i - j + n - 1] = true;
        board[i][j] = 'Q';

        // System.out.println(String.format("i: %d, j: %d", i, j));
        // System.out.println(Arrays.toString(col));
        // System.out.println(Arrays.toString(diag1));
        // System.out.println(Arrays.toString(diag2));
        // for (int k = 0; k < n; k++) {
        //     System.out.println(Arrays.toString(board[k]));
        // }

        if (i == n - 1) {
            LinkedList<String> solve = new LinkedList<>();
            for (int k = 0; k < n; k++) {
                solve.add(new String(board[k]));
            }
            res.add(solve);
        } else {
            for (int k = 0; k < n; k++) {
                if (!col[k] && !diag1[i + 1 + k] && !diag2[i - k + n]) {
                    solution2(i + 1, k, col, diag1, diag2, board);
                }
            }
        }
        col[j] = false;
        diag1[i + j] = false;
        diag2[i - j + n - 1] = false;
        board[i][j] = '.';

        // 1ms, 40.1MB

    }

    // private void helper(int i, int j, boolean[] board) {

    // for (int k = 0; k < n; k++) {
    // board[i * n + k] = true;
    // }
    // board[i * n + j] = false;

    // // System.out.println(String.format("i: %d, j: %d", i, j));
    // // System.out.println(Arrays.toString(board));

    // if (i == n - 1) {
    // LinkedList<String> solve = new LinkedList<>();
    // for (int k = 0; k < n; k++) {
    // StringBuilder sb = new StringBuilder();
    // for (int k2 = 0; k2 < n; k2++) {
    // if (board[k * n + k2]) {
    // sb.append('.');
    // } else {
    // sb.append('Q');
    // }
    // }
    // solve.add(sb.toString());
    // }
    // res.add(solve);
    // return;
    // }

    // for (int k = i + 1; k < n; k++) {
    // board[k * n + j] = true;
    // if (j - (k - i) >= 0) {
    // board[k * n + (j - (k - i))] = true;
    // }
    // if (j + (k - i) < n) {
    // board[k * n + (j + (k - i))] = true;
    // }
    // }

    // // System.out.println(Arrays.toString(board));

    // for (int k = 0; k < n; k++) {
    // if (!board[(i + 1) * n + k]) {
    // helper(i + 1, k, board.clone());
    // }
    // }

    // // 5ms 44.1MB
    // }
}
// @lc code=end

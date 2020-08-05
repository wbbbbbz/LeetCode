import java.util.Arrays;
import java.util.HashSet;

import org.omg.CORBA.BAD_INV_ORDER;

/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 *
 * https://leetcode.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (41.60%)
 * Likes:    1875
 * Dislikes: 92
 * Total Accepted:    190.2K
 * Total Submissions: 437.5K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3
 * sub-boxes of the grid.
 * 
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * 
 * A sudoku puzzle...
 * 
 * 
 * ...and its solution numbers marked in red.
 * 
 * Note:
 * 
 * 
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique
 * solution.
 * The given board size is always 9x9.
 * 
 * 
 */

// @lc code=start
class Solution {

    private char[][] board;

    public void solveSudoku(char[][] board) {
        
        this.board = board;

        solve(0);
    }

    private boolean solve(int index){
        if (index == 81){
            return true;
        }
        int i = index / 9;
        int j = index % 9;
        if (board[i][j] != '.'){
            return solve(index + 1);
        }

        for (char k = '1'; k <= '9'; k++) {
            if (isValid(i, j, k)){
                board[i][j] = k;
                if (solve(index + 1)){
                    return true;
                } 
                board[i][j] = '.';
            }
        }
        return false;
        // 26ms, 
    }

    private boolean isValid(int i, int j, char k){
        int grid = i / 3 * 3 + j / 3;
        for (int k2 = 0; k2 < board.length; k2++) {
            if (board[i][k2] == k || board[k2][j] == k || board[grid / 3 * 3 + k2 / 3][grid % 3 * 3 + k2 % 3] == k){
                return false;
            }
        }
        return true;
    }






    // private boolean[][] row = new boolean[9][9];
    // private boolean[][] col = new boolean[9][9];
    // private boolean[][] grid = new boolean[9][9];
    // private char[][] board;

    // public void solveSudoku(char[][] board) {

    //     this.board = board;

    //     for (int i = 0; i < 9; i++) {
    //         for (int j = 0; j < 9; j++) {
    //             if (board[i][j] != '.'){
    //                 int num = board[i][j] - '1';
    //                 row[i][num] = true;
    //                 col[j][num] = true;
    //                 grid[i / 3 * 3 + j / 3][num] = true;
    //             }
    //         }
    //     }

    //     solve(0, 0);
    // }

    // private boolean solve(int i, int j) {
    //     // for (int j2 = 0; j2 < 9; j2++) {
    //     //     System.out.println(Arrays.toString(board[j2]));
    //     // }
    //     // System.out.println(String.format("i: %d, j: %d", i, j));
    //     if (i == 9) {
    //         return true;
    //     }
    //     if (board[i][j] != '.') {
    //         return j == 8 ? solve(i + 1, 0) : solve(i, j + 1);
    //     }

    //     int g = i / 3 * 3 + j / 3;

    //     for (int k = 0; k < 9; k++) {
    //         if (!row[i][k] && !col[j][k] && !grid[g][k]) {
    //             board[i][j] = (char) ('1' + k);
    //             row[i][k] = true;
    //             col[j][k] = true;
    //             grid[g][k] = true;
    //             if (j == 8 ? solve(i + 1, 0) : solve(i, j + 1)) {
    //                 return true;
    //             }
    //             board[i][j] = '.';
    //             row[i][k] = false;
    //             col[j][k] = false;
    //             grid[g][k] = false;
    //         }
    //     }
    //     return false;
    //     // 2ms, 37.2MB
    // }
}
// @lc code=end

import java.util.*;
/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (25.80%)
 * Likes:    1854
 * Dislikes: 670
 * Total Accepted:    243.8K
 * Total Submissions: 871.9K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */

// @lc code=start
class Solution {

    char[][] board;

    char[][] origin;

    int R;

    int C;

    // testcase: [["X","O","X","O","X","O"],["O","X","O","X","O","X"],["X","O","X","O","X","O"],["O","X","O","X","O","X"]]

    public void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }
        
        R = board.length;
        C = board[0].length;

        origin = new char[R][];

        for (int i = 0; i < R; i++) {
            origin[i] = Arrays.copyOf(board[i], C);
            for (int j = 1; j < C - 1; j++) {
                board[i][j] = 'X';
            }
        }

        this.board = board;

        for (int c = 0; c < C; c++) {
            floodFill(0, c);
            floodFill(R - 1, c);
        }
        for (int r = 1; r < R; r++) {
            floodFill(r, 0);
            floodFill(r, C - 1);
        }
    }

    private void floodFill(int i, int j) {
        if (i < 0 || j < 0 || i >= R || j >= C || origin[i][j] != 'O') {
            return;
        }
        origin[i][j] = 'X';
        board[i][j] = 'O';
        floodFill(i + 1, j);
        floodFill(i - 1, j);
        floodFill(i, j + 1);
        floodFill(i, j - 1);
        // 1ms, 41.6MB
    }
}
// @lc code=end

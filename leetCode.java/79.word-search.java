import java.util.*;
/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (34.03%)
 * Likes:    3968
 * Dislikes: 192
 * Total Accepted:    499.4K
 * Total Submissions: 1.4M
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 
 * 
 */

// @lc code=start
class Solution {

    private char[][] board;

    private char[] word;

    public boolean exist(char[][] board, String word) {

        this.board = board;

        this.word = word.toCharArray();

        if (board.length * board[0].length < word.length()){
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean exist(int i, int j, int index) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length){
            return false;
        }
        if (board[i][j] != word[index]) {
            return false;
        }
        if (index == word.length - 1) {
            return true;
        }

        board[i][j] = '0';

        boolean res = exist(i + 1, j, index + 1)
                    || exist(i - 1, j, index + 1)
                    || exist(i, j + 1, index + 1)
                    || exist(i, j - 1, index + 1);

        board[i][j] = word[index];
        return res;
        // 4ms, 40.9MB
    }
}
// @lc code=end

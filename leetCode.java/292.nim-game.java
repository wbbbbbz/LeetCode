/*
 * @lc app=leetcode id=292 lang=java
 *
 * [292] Nim Game
 *
 * https://leetcode.com/problems/nim-game/description/
 *
 * algorithms
 * Easy (56.11%)
 * Likes:    580
 * Dislikes: 1561
 * Total Accepted:    212.2K
 * Total Submissions: 379.7K
 * Testcase Example:  '4'
 *
 * You are playing the following Nim Game with your friend: There is a heap of
 * stones on the table, each time one of you take turns to remove 1 to 3
 * stones. The one who removes the last stone will be the winner. You will take
 * the first turn to remove the stones.
 * 
 * Both of you are very clever and have optimal strategies for the game. Write
 * a function to determine whether you can win the game given the number of
 * stones in the heap.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: false 
 * Explanation: If there are 4 stones in the heap, then you will never win the
 * game;
 * No matter 1, 2, or 3 stones you remove, the last stone will always
 * be 
 * removed by your friend.
 */

// @lc code=start
class Solution {
    public boolean canWinNim(int n) {
        return n <= 0 ? false : n % 4 != 0;
    }

    // 60/60 cases passed (0 ms)
    // Your runtime beats 100 % of java submissions
    // Your memory usage beats 7.69 % of java submissions (36 MB)
}
// @lc code=end

/*
 * @lc app=leetcode id=441 lang=java
 *
 * [441] Arranging Coins
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        return (int)((Math.sqrt(1.0 + 8.0 * n) - 1.0) / 2.0);
    }
}
// @lc code=end
/*
 * Runtime: 3 ms, faster than 74.72% of Java online submissions for Arranging Coins.
 * Memory Usage: 41.9 MB, less than 21.04% of Java online submissions for Arranging Coins.
 * 有数学公式，解二次方程
 */


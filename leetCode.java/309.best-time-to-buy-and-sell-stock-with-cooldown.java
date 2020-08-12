/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (45.77%)
 * Likes:    2698
 * Dislikes: 88
 * Total Accepted:    158.3K
 * Total Submissions: 334.1K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * Say you have an array for which the i^th element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * 
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1
 * day)
 * 
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,0,2]
 * Output: 3 
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * 
 */

// @lc code=start
class Solution {
    // 分析状态。一共有三个状态，can buy，hold stock和cooldown
    // 这三个状态互相转换，然后分析出到该日为止的最大值即可。
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1){
            return 0;
        }

        // 初始化
        int canBuy = 0;
        int hold = -prices[0];
        int cooldown = 0;

        for (int i = 1; i < prices.length; i++) {
            int temp = canBuy;
            canBuy = Math.max(canBuy, cooldown);
            cooldown = prices[i] + hold;
            hold = Math.max(temp - prices[i], hold);
        }

        return Math.max(canBuy, Math.max(cooldown, hold));
        // 0ms, 37.9MB
    }
}
// @lc code=end


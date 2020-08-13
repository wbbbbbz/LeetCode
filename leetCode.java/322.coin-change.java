import java.util.Arrays;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (34.08%)
 * Likes:    4470
 * Dislikes: 141
 * Total Accepted:    432.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {

        // 背包问题。
        // 以i枚硬币凑出C元
        // F(i, C) = min(F(i-1, C), F(i-1, C-coins[j]) + 1) (j是coins种所有可能)

        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        // return solution1(coins, amount);

        // 优化：从1到amount，每一次计算一个数字
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // System.out.println(Arrays.toString(dp));

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
        // 10ms, 39.2MB
    }

    private int solution1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i = amount; i >= 1; i--) {
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] >= 0 && dp[i - coins[j]] + 1 < dp[i]) {
                        flag = true;
                        dp[i] = dp[i - coins[j]] + 1;
                        // System.out.println(String.format("i: %d, dp[i]: %d", i, dp[i]));
                    }
                }
            }
            // System.out.println(Arrays.toString(dp));
            if (dp[amount] != Integer.MAX_VALUE - 1) {
                return dp[amount];
            }
        }

        return -1;
        // 130ms, 39.2MB
    }
}
// @lc code=end

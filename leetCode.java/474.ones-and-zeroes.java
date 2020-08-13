import java.util.Arrays;

/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 *
 * https://leetcode.com/problems/ones-and-zeroes/description/
 *
 * algorithms
 * Medium (42.11%)
 * Likes:    1057
 * Dislikes: 235
 * Total Accepted:    50K
 * Total Submissions: 116.6K
 * Testcase Example:  '["10","0001","111001","1","0"]\n5\n3'
 *
 * Given an array, strs, with strings consisting of only 0s and 1s. Also two
 * integers m and n.
 * 
 * Now your task is to find the maximum number of strings that you can form
 * with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s
 * and 3 1s, which are "10","0001","1","0".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: You could form "10", but then you'd have nothing left. Better
 * form "0" and "1".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        // 背包问题
        // 从[0, i]元素中取出不定的元素使元素总0<=m，总1<=n.F求的是放入元素的最多个数
        // F(i, m, n) = max(F(i - 1, m, n), F(i - 1, m - m(strs[j]), n - n(strs[j]) +
        // 1))

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            int[] temp = count(strs[i].toCharArray());
            // System.out.println(Arrays.toString(temp));
            int zeroes = temp[0];
            int ones = temp[1];
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j - zeroes >= 0 && k - ones >= 0)
                        dp[j][k] = Math.max(dp[j][k], dp[j - zeroes][k - ones] + 1);
                }
            }
            // System.out.println(Arrays.deepToString(dp));
        }

        return dp[m][n];

        // 32ms, 39.5MB

    }

    private int[] count(char[] s) {
        int zeroes = 0;
        int ones = 0;
        for (char c : s) {
            if (c == '0')
                zeroes++;
            else
                ones++;
        }
        return new int[] { zeroes, ones };
    }
}
// @lc code=end

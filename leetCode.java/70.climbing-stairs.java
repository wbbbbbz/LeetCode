/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (46.45%)
 * Likes:    4564
 * Dislikes: 146
 * Total Accepted:    724.9K
 * Total Submissions: 1.5M
 * Testcase Example:  '2'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 45
 * 
 * 
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {

        if (n <= 2) {
            return Math.max(0, n);
        }
        // int[] path = new int[n];
        // path[0] = 1;
        // path[1] = 2;
        // for (int i = 2; i < n; i++) {
        //     path[i] = path[i - 1] + path[i - 2];
        // }

        // return path[n - 1];

        int prepre = 1;
        int pre = 2;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = prepre + pre;
            prepre = pre;
            pre = res;
        }

        return res;

        // 0ms, 36.1MB

    }
}
// @lc code=end

/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (36.08%)
 * Likes:    1842
 * Dislikes: 50
 * Total Accepted:    178.9K
 * Total Submissions: 490.6K
 * Testcase Example:  '[2,3,2]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money
 * = 2),
 * because they are adjacent houses.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money =
 * 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        
        if (nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;

        if (n == 1){
            return nums[0];
        }

        if (n == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] has1 = nums.clone();
        int[] no1 = nums.clone();
        
        has1[1] = Math.max(has1[0], has1[1]);
        for (int i = 2; i < n - 1; i++) {
            has1[i] = Math.max(has1[i - 2] + has1[i], has1[i - 1]);
        }

        no1[2] = Math.max(no1[1], no1[2]);
        for (int i = 3; i < n; i++) {
            no1[i] = Math.max(no1[i - 2] + no1[i], no1[i - 1]);
        }

        return Math.max(has1[n - 2], no1[n - 1]);
        // 0ms, 37.1MB
    }
}
// @lc code=end


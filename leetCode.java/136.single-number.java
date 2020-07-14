/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 *
 * https://leetcode.com/problems/single-number/description/
 *
 * algorithms
 * Easy (64.70%)
 * Likes:    4490
 * Dislikes: 161
 * Total Accepted:    886.9K
 * Total Submissions: 1.4M
 * Testcase Example:  '[2,2,1]'
 *
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * 
 * Input: [2,2,1]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,1,2,1,2]
 * Output: 4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;

        // 16/16 cases passed (1 ms)
        // Your runtime beats 68.61 % of java submissions
        // Your memory usage beats 14.07 % of java submissions (43.4 MB)
    }
}
// @lc code=end

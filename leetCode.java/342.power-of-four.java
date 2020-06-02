/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 *
 * https://leetcode.com/problems/power-of-four/description/
 *
 * algorithms
 * Easy (41.24%)
 * Likes:    471
 * Dislikes: 197
 * Total Accepted:    146.2K
 * Total Submissions: 353.7K
 * Testcase Example:  '16'
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 * 
 * Example 1:
 * 
 * 
 * Input: 16
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 5
 * Output: false
 * 
 * 
 * Follow up: Could you solve it without loops/recursion?
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int num) {
        return (num > 0 && ((num - 1) & num) == 0 && ((num & 0x55555555) == num));
    }
}
// @lc code=end

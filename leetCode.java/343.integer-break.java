/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 *
 * https://leetcode.com/problems/integer-break/description/
 *
 * algorithms
 * Medium (49.56%)
 * Likes:    1076
 * Dislikes: 227
 * Total Accepted:    110K
 * Total Submissions: 218.6K
 * Testcase Example:  '2'
 *
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * 
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        assert(n >= 2 && n <= 58);
        switch (n) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 4;
            default:
                int res = (n - 2) % 3 + 2;
                for (int i = 0; i < (n - 2) / 3; i++) {
                    res *= 3;
                }
                return res;
        }
        // 0ms, 38.1MB
    }
}
// @lc code=end


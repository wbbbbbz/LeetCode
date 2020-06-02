/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 *
 * https://leetcode.com/problems/add-digits/description/
 *
 * algorithms
 * Easy (55.86%)
 * Likes:    669
 * Dislikes: 1022
 * Total Accepted:    282.4K
 * Total Submissions: 503.2K
 * Testcase Example:  '38'
 *
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * Example:
 * 
 * 
 * Input: 38
 * Output: 2 
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 * 
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        if (num == 0)
            return 0;
        int res = num % 9;
        return res == 0 ? 9 : res;

        // 1101/1101 cases passed (1 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 6.67 % of java submissions (37 MB)
    }
}
// @lc code=end

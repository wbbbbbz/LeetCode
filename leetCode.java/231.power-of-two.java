/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 *
 * https://leetcode.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (42.92%)
 * Likes:    684
 * Dislikes: 168
 * Total Accepted:    287.7K
 * Total Submissions: 669.4K
 * Testcase Example:  '1'
 *
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: true 
 * Explanation: 2^0 = 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 16
 * Output: true
 * Explanation: 2^4 = 16
 * 
 * Example 3:
 * 
 * 
 * Input: 218
 * Output: false
 * 
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        // if (n <= 0)
        // return false;
        // while (n > 1) {
        // if (n % 2 == 1)
        // return false;
        // n /= 2;
        // }
        // return true;
        // 1108/1108 cases passed (1 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 7.32 % of java submissions (36.8 MB)

        return n > 0 && Integer.bitCount(n) == 1;
    }

}
// @lc code=end

import java.util.HashSet;

/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 *
 * https://leetcode.com/problems/happy-number/description/
 *
 * algorithms
 * Easy (49.95%)
 * Likes:    2155
 * Dislikes: 427
 * Total Accepted:    513.5K
 * Total Submissions: 1M
 * Testcase Example:  '19'
 *
 * Write an algorithm to determine if a number n is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Return True if n is a happy number, and False if not.
 * 
 * Example: 
 * 
 * 
 * Input: 19
 * Output: true
 * Explanation: 
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }

        // 通过hashSet记录搜索路径。只要重复了就肯定有cycle，不是happy数
        HashSet<Integer> path = new HashSet<>();

        while (n != 1 && !path.contains(n)) {
            path.add(n);
            n = sosd(n);
        }
        return n == 1;
        // 401/401 cases passed (1 ms)
        // Your runtime beats 90.17 % of java submissions
        // Your memory usage beats 31.42 % of java submissions (37 MB)
    }

    private int sosd(int n) {
        int res = 0;
        while (n != 0) {
            res += ((n % 10) * (n % 10));
            n /= 10;
        }
        return res;
    }
}
// @lc code=end

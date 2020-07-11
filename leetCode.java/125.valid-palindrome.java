/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (34.69%)
 * Likes:    1199
 * Dislikes: 2914
 * Total Accepted:    586.5K
 * Total Submissions: 1.6M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * s consists only of printable ASCII characters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        s = s.trim().toLowerCase();
        // 判断[i, j]是不是回文。如果是回文就继续缩小范围
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char iChar = s.charAt(i);
            char jChar = s.charAt(j);
            // System.out.println("iChar: " + iChar + ", jChar: " + jChar);
            if (!Character.isLetterOrDigit(iChar)) {
                i++;
            } else if (!Character.isLetterOrDigit(jChar)) {
                j--;
            } else if (iChar != jChar) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
        // 481/481 cases passed (6 ms)
        // Your runtime beats 42.7 % of java submissions
        // Your memory usage beats 11.18 % of java submissions (41 MB)
    }
}
// @lc code=end

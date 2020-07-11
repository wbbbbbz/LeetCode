import java.util.Collections;

/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (66.19%)
 * Likes:    1452
 * Dislikes: 687
 * Total Accepted:    762.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '["h","e","l","l","o"]'
 *
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii
 * characters.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length < 1) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            swap(s, i++, j--);
        }
        // 478/478 cases passed (1 ms)
        // Your runtime beats 59.88 % of java submissions
        // Your memory usage beats 37.06 % of java submissions (46.6 MB)
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
// @lc code=end

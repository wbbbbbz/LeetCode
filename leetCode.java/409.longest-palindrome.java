import java.util.HashMap;

/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int result = 1;
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (char c : s.toCharArray()) {
            if (c < 'a'){
                // upper
                upper[c - 'A'] += 1;
            } else{
                lower[c - 'a'] += 1;
            }
        }
        for (int i : lower) {
            result += (i / 2) * 2;
        }
        for (int i : upper) {
            result += (i / 2) * 2;
        }
        return Math.min(result, s.length());
    }
}
// @lc code=end
/*
 * Runtime: 2 ms, faster than 93.57% of Java online submissions for Longest Palindrome.
 * Memory Usage: 41.2 MB, less than 88.55% of Java online submissions for Longest Palindrome.
 * 看起来是回文问题，实际上还是计算个数问题。要么排序，要么用counter
 */


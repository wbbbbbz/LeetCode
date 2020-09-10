import java.util.*;

/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (28.97%)
 * Likes:    7671
 * Dislikes: 563
 * Total Accepted:    1M
 * Total Submissions: 3.4M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {

    // testcase: '"aaaa"'

    public String longestPalindrome(String s) {

        // return solution1(s);

        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();

        int[] res = { 0, 0 };

        int len = 1;

        for (int i = 0; i < n - 1; i++) {
            int left = i;
            int right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                // System.out.println(String.format("left: %d, right: %d", left, right));
                if ((right - left + 1) > len) {
                    res[0] = left;
                    res[1] = right;
                    len = right - left + 1;
                }
                left--;
                right++;
            }
        }

        // System.out.println(Arrays.toString(res));

        for (int i = 0; i < n - 2; i++) {
            int left = i;
            int right = i + 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                // System.out.println(String.format("left: %d, right: %d", left, right));
                if ((right - left + 1) > len) {
                    len = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }
                left--;
                right++;
            }
        }

        // System.out.println(Arrays.toString(res));
        return s.substring(res[0], res[1] + 1);

        // // 103/103 cases passed (22 ms)
        // Your runtime beats 92.8 % of java submissions
        // Your memory usage beats 86.95 % of java submissions (37.8 MB)
    }

    private String solution1(String s) {
        // F(i, j) = if s(i) == s(j) : F(i + 1, j - 1)
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int[] res = { 0, 0 };

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res[0] = i;
                res[1] = i + 1;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (s.charAt(j) == s.charAt(j + i) && dp[j + 1][j + i - 1]) {
                    res[0] = j;
                    res[1] = j + i;
                    dp[j][j + i] = true;
                }
            }
        }

        return s.substring(res[0], res[1] + 1);
        // 85ms, 42.4MB
    }
}
// @lc code=end

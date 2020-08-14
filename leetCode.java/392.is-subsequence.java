/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 *
 * https://leetcode.com/problems/is-subsequence/description/
 *
 * algorithms
 * Easy (47.95%)
 * Likes:    1624
 * Dislikes: 205
 * Total Accepted:    224.6K
 * Total Submissions: 456.4K
 * Testcase Example:  '"abc"\n"ahbgdc"'
 *
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you
 * want to check one by one to see if T has its subsequence. In this scenario,
 * how would you change your code?
 * 
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test
 * cases.
 * 
 * 
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * Both strings consists only of lowercase characters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {

        if(s == null || t == null || t.length() < s.length()){
            return false;
        }
        if (s.length() == 0){
            return true;
        }

        int si = 0;
        for (char c : t.toCharArray()) {
            // System.out.println(c + ", si: " + si);
            if (c == s.charAt(si)){
                si++;
            }
            if (si == s.length()){
                return true;
            }
        }

        return false;
        // 1ms 37.1MB
    }
}
// @lc code=end


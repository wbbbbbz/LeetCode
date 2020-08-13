import java.util.List;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (38.72%)
 * Likes:    4642
 * Dislikes: 240
 * Total Accepted:    575K
 * Total Submissions: 1.4M
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        // 背包问题
        // 用i个物品能否恰好装满C长度的单词(并且词序相等)
        // F(i, C) = F(i-1, C) || F(i-1, C-wordDict.get(j))

        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        int minLen = Integer.MAX_VALUE;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                dp[i] = (i - word.length() >= 0 && dp[i - word.length()]
                        && s.substring(i - word.length(), i).equals(word));
                if (dp[i])
                    break;
            }
        }

        return dp[s.length()];

        // 2ms, 37.6MB

    }
}
// @lc code=end

import java.util.HashMap;

import javax.xml.stream.events.Characters;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (29.80%)
 * Likes:    8385
 * Dislikes: 506
 * Total Accepted:    1.4M
 * Total Submissions: 4.8M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;
        // 记录每一个字母最后出现的index
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        // 现有子字符串的开始index
        int start = 0;
        // 最长子字符串的长度
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!lastIndex.containsKey(c)) {
                lastIndex.put(c, i);
            } else {
                start = start > lastIndex.get(c) + 1 ? start : lastIndex.get(c) + 1;
                lastIndex.put(c, i);
            }
            res = res > i - start ? res : i - start;
            // System.out.println(start + ", " + res);
        }
        return res + 1;
        // 987/987 cases passed (4 ms)
        // Your runtime beats 88.12 % of java submissions
        // Your memory usage beats 11.1 % of java submissions (39.9 MB)
    }
}
// @lc code=end

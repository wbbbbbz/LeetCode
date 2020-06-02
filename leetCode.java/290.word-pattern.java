import java.util.HashMap;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 *
 * https://leetcode.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (36.47%)
 * Likes:    1026
 * Dislikes: 144
 * Total Accepted:    183K
 * Total Submissions: 499.1K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Example 1:
 * 
 * 
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * 
 * Example 4:
 * 
 * 
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * 
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters that may be separated by a single space.
 * 
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {

        String[] strs = str.split(" ");

        if (pattern.length() != strs.length)
            return false;

        boolean[] chars = new boolean[26];

        TreeMap<String, Character> map = new TreeMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            String s = strs[i];
            Character c = pattern.charAt(i);
            if (!map.containsKey(s)) {
                if (chars[c - 'a']) {
                    return false;
                }
                map.put(s, c);
                chars[c - 'a'] = true;
            } else if (map.get(s) != c) {
                return false;
            }
        }
        return true;
    }
    // 37/37 cases passed (1 ms)
    // Your runtime beats 44.07 % of java submissions
    // Your memory usage beats 5.41 % of java submissions (37.2 MB)
}
// @lc code=end

import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (39.23%)
 * Likes:    1269
 * Dislikes: 334
 * Total Accepted:    280.1K
 * Total Submissions: 711.3K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * Note:
 * You may assume both s and t have the same length.
 * 
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> mapped = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);

            if (!map.containsKey(sc)) {
                if (mapped.contains(tc))
                    return false;
                map.put(sc, tc);
                mapped.add(tc);
            } else if (map.get(sc) != tc)
                return false;
        }

        return true;

        // 32/32 cases passed (6 ms)
        // Your runtime beats 71.7 % of java submissions
        // Your memory usage beats 6.14 % of java submissions (39.6 MB)
    }
}
// @lc code=end

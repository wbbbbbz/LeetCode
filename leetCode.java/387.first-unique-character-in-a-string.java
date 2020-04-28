import java.util.Collections;
import java.util.HashMap;

/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (51.76%)
 * Likes:    1638
 * Dislikes: 108
 * Total Accepted:    429.2K
 * Total Submissions: 827.8K
 * Testcase Example:  '"leetcode"'
 *
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {

        // // TestCase:"loveleetcode"
        // // TestCase:"lllll"
        // // TestCase:""

        // // 考虑s长度为0的情况
        // if (s == null || s.isEmpty())
        // return -1;

        // // 生成s的字符与首次出现的Index的映射
        // // 重复出现的字符就将Index改为s的长度(也就是不可能的index)
        // HashMap<Character, Integer> map = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        // Character c = s.charAt(i);
        // if (map.containsKey(c))
        // map.put(c, s.length());
        // else
        // map.put(c, i);
        // }

        // // 在映射中寻找最小值,如果是s的长度就返回-1
        // int res = Collections.min(map.values());
        // return res == s.length() ? -1 : res;

        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;

        // 104/104 cases passed (5 ms)
        // Your runtime beats 94.54 % of java submissions
        // Your memory usage beats 5.71 % of java submissions (40.6 MB)

    }

    // 104/104 cases passed (20 ms)
    // Your runtime beats 59.67 % of java submissions
    // Your memory usage beats 5.71 % of java submissions (40.3 MB)
}
// @lc code=end

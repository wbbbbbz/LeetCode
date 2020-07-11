import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (33.71%)
 * Likes:    4487
 * Dislikes: 310
 * Total Accepted:    397.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {

        if (s == null || t == null || s.isEmpty() || t.isEmpty() || t.length() > s.length()) {
            return "";
        }

        // return solution1(s, t);

        // 字典的优化
        // 使用int[128]作为字典
        // 这次计数用的counter使用t的长度。
        // 不需要担心不是t中的字符。因为不是t中的字符，一开始次数就是0。
        // 所以维护counter的方式是只要一开始map中的值为正数，就-1
        // 加回去的时候如果加完之后能成为正数，就+1
        int minSize = s.length() + 1;
        int start = -1;

        int[] map = new int[128];
        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();

        for (int i = 0; i < tCh.length; i++) {
            map[tCh[i]]++;
        }

        int counter = tCh.length;

        int left = 0;
        for (int i = 0; i < sCh.length; i++) {
            if (map[sCh[i]]-- > 0) {
                counter--;
            }
            while (counter == 0) {
                if (i - left + 1 < minSize) {
                    start = left;
                    minSize = i - left + 1;
                }
                if (++map[sCh[left]] > 0) {
                    counter++;
                }
                left++;
            }
        }
        return start == -1 ? "" : new String(sCh, start, minSize);

        // 268/268 cases passed (2 ms)
        // Your runtime beats 99.98 % of java submissions
        // Your memory usage beats 20.54 % of java submissions (41.3 MB)
    }

    private String solution1(String s, String t) {
        int minSize = s.length() + 1;
        int start = -1;

        HashMap<Character, Integer> map = new HashMap<>();

        char[] sCh = s.toCharArray();
        char[] tCh = t.toCharArray();

        for (int i = 0; i < tCh.length; i++) {
            map.put(tCh[i], map.getOrDefault(tCh[i], 0) + 1);
        }

        int counter = map.size();

        int left = 0;
        for (int i = 0; i < sCh.length; i++) {
            if (map.containsKey(sCh[i])) {
                map.put(sCh[i], map.get(sCh[i]) - 1);
                if (map.get(sCh[i]) == 0) {
                    counter--;
                }
            }
            while (counter == 0) {
                if (i - left + 1 < minSize) {
                    start = left;
                    minSize = i - left + 1;
                }
                if (map.containsKey(sCh[left])) {
                    if (map.get(sCh[left]) == 0) {
                        counter++;
                    }
                    map.put(sCh[left], map.get(sCh[left]) + 1);
                }
                left++;
            }
        }

        return start == -1 ? "" : new String(sCh, start, minSize);

        // 268/268 cases passed (25 ms)
        // Your runtime beats 22.97 % of java submissions
        // Your memory usage beats 22.49 % of java submissions (41.2 MB)
    }
}
// @lc code=end

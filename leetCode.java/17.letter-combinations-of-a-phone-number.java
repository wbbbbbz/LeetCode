import java.util.*;
/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (45.37%)
 * Likes:    3973
 * Dislikes: 412
 * Total Accepted:    618.9K
 * Total Submissions: 1.3M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */

// @lc code=start
class Solution {

    private HashMap<Character, String[]> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty()) {
            return new LinkedList<String>();
        }

        map.put('2', new String[] { "a", "b", "c" });
        map.put('3', new String[] { "d", "e", "f" });
        map.put('4', new String[] { "g", "h", "i" });
        map.put('5', new String[] { "j", "k", "l" });
        map.put('6', new String[] { "m", "n", "o" });
        map.put('7', new String[] { "p", "q", "r", "s" });
        map.put('8', new String[] { "t", "u", "v" });
        map.put('9', new String[] { "w", "x", "y", "z" });

        List<String> res = new LinkedList<String>();
        int index = 0;
        for (String s : map.get(digits.charAt(index))) {
            res.add(s);
        }

        for (index = 1; index < digits.length(); index++) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                String temp = res.remove(0);
                for (String s : map.get(digits.charAt(index))) {
                    res.add(temp + s);
                }
            }
        }

        return res;

        // 25/25 cases passed (1 ms)
        // Your runtime beats 85.71 % of java submissions
        // Your memory usage beats 71.29 % of java submissions (38.3 MB)

    }
}
// @lc code=end

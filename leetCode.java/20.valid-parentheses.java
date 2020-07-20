import java.util.HashMap;
import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (38.28%)
 * Likes:    5127
 * Dislikes: 224
 * Total Accepted:    1M
 * Total Submissions: 2.7M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()){
            return true;
        }

        HashMap<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if (!map.containsKey(c)){
                stack.add(c);
            } else {
                if (stack.empty() || map.get(c) != stack.pop()){
                    return false;
                }
            }
        }
        return stack.empty();
//         76/76 cases passed (2 ms)
// Your runtime beats 47.37 % of java submissions
// Your memory usage beats 12.94 % of java submissions (39 MB)
    }
}
// @lc code=end


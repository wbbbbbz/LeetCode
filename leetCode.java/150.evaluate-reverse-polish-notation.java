import java.util.function.ToIntBiFunction;
import java.util.HashMap;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * algorithms
 * Medium (35.15%)
 * Likes:    1031
 * Dislikes: 471
 * Total Accepted:    229.4K
 * Total Submissions: 635.4K
 * Testcase Example:  '["2","1","+","3","*"]'
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Note:
 * 
 * 
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would
 * always evaluate to a result and there won't be any divide by zero
 * operation.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation: 
 * ⁠ ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 
 * 
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {

        assert(tokens != null);

        if (tokens.length == 1){
            return Integer.parseInt(tokens[0]);
        }

        assert(tokens.length >= 3);

        // ToIntBiFunction<Integer, Integer> add = (a, b) -> a + b;
        // ToIntBiFunction<Integer, Integer> substract = (a, b) -> a - b;
        // ToIntBiFunction<Integer, Integer> multiply = (a, b) -> a * b;
        // ToIntBiFunction<Integer, Integer> divide = (a, b) -> a / b;

        HashMap<String, ToIntBiFunction<Integer, Integer>> map = new HashMap<>();

        map.put("+", (a, b) -> b + a);
        map.put("-", (a, b) -> b - a);
        map.put("*", (a, b) -> b * a);
        map.put("/", (a, b) -> b / a);

        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){
            if (!map.containsKey(s)){
                stack.add(Integer.parseInt(s));
            } else {
                assert(stack.size() >= 2);
                stack.add(map.get(s).applyAsInt(stack.pop(), stack.pop()));
            }
            // System.out.println(stack);
        }
        assert(stack.size() == 1);
        return stack.pop();

//         20/20 cases passed (18 ms)
// Your runtime beats 9.42 % of java submissions
// Your memory usage beats 11.58 % of java submissions (41.4 MB)
    }
}
// @lc code=end


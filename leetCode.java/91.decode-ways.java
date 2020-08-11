import java.util.Arrays;

/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (23.90%)
 * Likes:    2759
 * Dislikes: 2885
 * Total Accepted:    408.7K
 * Total Submissions: 1.7M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */

// @lc code=start
class Solution {

    public int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            if (s.equals("0")){
                return 0;
            }
            return 1;
        }

        char[] str = s.toCharArray();

        int n = str.length;

        int[] temp = new int[4];
        if (str[n - 1] != '0') {
            temp[0] = 1;
            temp[1] = 0;
        }
        if (str[n - 2] != '0') {
            temp[2] = str[n - 2] == 0 ? 0 : temp[0] + temp[1];
            temp[3] = judge2(str[n - 2], str[n - 1]) ? 1 : 0;
        }

        for (int i = n - 3; i >= 0; i--) {
            // System.out.println(Arrays.toString(temp));
            int sum = temp[0] + temp[1];
            temp[0] = temp[2];
            temp[1] = temp[3];
            if (str[i] == '0'){
                temp[2] = temp[3] = 0;
            } else {
                temp[2] += temp[3];
                temp[3] = judge2(str[i], str[i + 1]) ? sum : 0;
            }
        }

        return temp[2] + temp[3];
        // 1ms. 37.5MB
    }

    private boolean judge2(char a, char b) {
        return a < '2' || (a == '2' && b <= '6');
    }
}
// @lc code=end

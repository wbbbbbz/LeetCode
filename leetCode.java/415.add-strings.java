/*
 * @lc app=leetcode id=415 lang=java
 *
 * [415] Add Strings
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {

        // make sure num1 is the one with less digits
        if (num1.length() > num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        StringBuilder output = new StringBuilder();

        int carry = 0;
        int mod = 0;
        int tempSum = 0;
        while (index2 >= 0) {
            if (index1 < 0) {
                tempSum = num2.charAt(index2) - '0' + carry;
            } else {
                tempSum = (num1.charAt(index1) - '0') + (num2.charAt(index2) - '0') + carry;
            }
            mod = tempSum % 10;
            carry = tempSum / 10;
            output.append(mod);
            index1--;
            index2--;
        }
        if (carry != 0){
            output.append(1);
        }
        return output.reverse().toString();
    }
}
// @lc code=end
/*
 * Runtime: 4 ms, faster than 64.16% of Java online submissions for Add Strings.
 * Memory Usage: 42.4 MB, less than 93.20% of Java online submissions for Add Strings.
 * 注意极限情况。两个数字可能digit不一样。进位是1，需不需要考虑最后的一位。
 */
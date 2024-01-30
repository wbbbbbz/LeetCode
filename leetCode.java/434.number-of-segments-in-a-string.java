/*
 * @lc app=leetcode id=434 lang=java
 *
 * [434] Number of Segments in a String
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int output = 0;
        int index = 0;
        boolean isWord = false;
        while(index < s.length()){
            if(!isWord && s.charAt(index) != ' '){
                isWord = true;
                output += 1;
            } else if(s.charAt(index) == ' '){
                isWord = false;
            }
            index += 1;
        }
        return output;
    }
}
// @lc code=end
/*
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Segments in a String.
 * Memory Usage: 41.8 MB, less than 56.13% of Java online submissions for Number of Segments in a String.
 * 需要考虑特殊情况，几个空格连续，头尾是空格等等，用一个flag来判断单词比较好
 */

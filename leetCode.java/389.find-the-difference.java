/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        int[] letters = new int[26];
        for(char c: t.toCharArray()){
            letters[c - 'a'] += 1;
        }
        for(char c: s.toCharArray()){
            letters[c - 'a'] -= 1;
        }
        for (int i = 0; i < letters.length; i++) {
            if(letters[i] != 0){
                return (char)(i + 'a');
            }
        }
        return 'a';
    }
}
// @lc code=end
/*
 * Runtime: 2 ms, faster than 84.97% of Java online submissions for Find the Difference.
 * Memory Usage: 42 MB, less than 72.15% of Java online submissions for Find the Difference.
 * Counter使用，找出多于的字符
 */

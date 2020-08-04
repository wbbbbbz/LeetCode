import java.util.*;
/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (45.45%)
 * Likes:    1892
 * Dislikes: 67
 * Total Accepted:    230.2K
 * Total Submissions: 487.8K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * 
 * Input: "aab"
 * Output:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {

    private char[] str;

    private List<List<String>> res;

    public List<List<String>> partition(String s) {

        this.str = s.toCharArray();

        this.res = new LinkedList<>();

        if (s == null || s.isEmpty()) {
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            partition(0, i, new LinkedList<String>());
        }

        return res;
        // 2ms, 40.8MB

    }

    private boolean partition(int start, int end, LinkedList<String> list) {

        if (start == end || isPalindrome(start, end)) {
            list.add(new String(this.str, start, end - start + 1));
            int size = list.size();
            if (end == str.length - 1) {
                res.add(new LinkedList<>(list));
            } else {
                for (int i = end + 1; i < str.length; i++) {
                    if (partition(end + 1, i, list)){
                        list.pollLast();
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean isPalindrome(int start, int end) {
        while (start < end) {
            if (this.str[start] != this.str[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
// @lc code=end

import java.util.HashSet;
import java.util.Stack;

/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (43.34%)
 * Likes:    608
 * Dislikes: 1060
 * Total Accepted:    208.7K
 * Total Submissions: 479.1K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1:
 * 
 * 
 * Input: "hello"
 * Output: "holle"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "leetcode"
 * Output: "leotcede"
 * 
 * 
 * Note:
 * The vowels does not include the letter "y".
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {

        if (s == null) {
            return null;
        }
        if (s.length() < 2) {
            return s;
        }

        // Stack<Character> stack = new Stack<>();

        // HashSet<Character> set = new HashSet<>();

        // set.add('a');
        // set.add('e');
        // set.add('i');
        // set.add('o');
        // set.add('u');
        // set.add('A');
        // set.add('E');
        // set.add('I');
        // set.add('O');
        // set.add('U');

        // for (char c : s.toCharArray()) {
        // if (set.contains(c))
        // stack.push(c);
        // }

        // StringBuilder news = new StringBuilder();

        // for (char c : s.toCharArray()) {
        // if (!set.contains(c))
        // news.append(c);
        // else
        // news.append(stack.pop());
        // }

        // return news.toString();

        // // 481/481 cases passed (8 ms)
        // // Your runtime beats 29.99 % of java submissions
        // // Your memory usage beats 44.83 % of java submissions (40.5 MB)

        // 指针碰撞法
        HashSet<Character> set = new HashSet<>();

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        StringBuilder news = new StringBuilder(s);
        int i = 0;
        int j = news.length() - 1;
        while (i < j) {
            char iChar = news.charAt(i);
            char jChar = news.charAt(j);
            // System.out.println("iChar: " + iChar + ", jChar: " + jChar);
            if (!set.contains(iChar)) {
                i++;
            } else if (!set.contains(jChar)) {
                j--;
            } else {
                news.setCharAt(i++, jChar);
                news.setCharAt(j--, iChar);
            }
        }
        return news.toString();

        // 481/481 cases passed (7 ms)
        // Your runtime beats 37.32 % of java submissions
        // Your memory usage beats 13.09 % of java submissions (41.9 MB)

    }
}
// @lc code=end

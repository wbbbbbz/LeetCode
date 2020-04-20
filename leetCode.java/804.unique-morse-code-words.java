import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=804 lang=java
 *
 * [804] Unique Morse Code Words
 *
 * https://leetcode.com/problems/unique-morse-code-words/description/
 *
 * algorithms
 * Easy (76.24%)
 * Likes:    580
 * Dislikes: 569
 * Total Accepted:    129.1K
 * Total Submissions: 169.2K
 * Testcase Example:  '["gin", "zen", "gig", "msg"]'
 *
 * International Morse Code defines a standard encoding where each letter is
 * mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b"
 * maps to "-...", "c" maps to "-.-.", and so on.
 * 
 * For convenience, the full table for the 26 letters of the English alphabet
 * is given below:
 * 
 * 
 * 
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 
 * Now, given a list of words, each word can be written as a concatenation of
 * the Morse code of each letter. For example, "cba" can be written as
 * "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll
 * call such a concatenation, the transformation of a word.
 * 
 * Return the number of different transformations among all words we have.
 * 
 * 
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation: 
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * 
 * There are 2 different transformations, "--...-." and "--...--.".
 * 
 * 
 * Note:
 * 
 * 
 * The length of words will be at most 100.
 * Each words[i] will have length in range [1, 12].
 * words[i] will only consist of lowercase letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        // 摩尔斯密码的解读表是一定需要的
        // 把每一个字母对应的密码连接起来放入一个集合中，返回集合的大小即可
        // java中通过char型的数字距离来对应摩尔斯密码

        String[] morseCode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

        Set<String> output = new HashSet<>();

        for (String word : words) {
            StringBuilder str = new StringBuilder();
            for (char c : word.toCharArray()) {
                str.append(morseCode[c - 'a']);
            }
            output.add(str.toString());
        }

        return output.size();

    }
    // 83/83 cases passed (1 ms)
    // Your runtime beats 100 % of java submissions
    // Your memory usage beats 5.26 % of java submissions (37.5 MB)
}
// @lc code=end

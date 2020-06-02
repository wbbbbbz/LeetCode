import java.util.HashMap;

/*
 * @lc app=leetcode id=299 lang=java
 *
 * [299] Bulls and Cows
 *
 * https://leetcode.com/problems/bulls-and-cows/description/
 *
 * algorithms
 * Easy (41.70%)
 * Likes:    587
 * Dislikes: 708
 * Total Accepted:    147.3K
 * Total Submissions: 350.9K
 * Testcase Example:  '"1807"\n"7810"'
 *
 * You are playing the following Bulls and Cows game with your friend: You
 * write down a number and ask your friend to guess what the number is. Each
 * time your friend makes a guess, you provide a hint that indicates how many
 * digits in said guess match your secret number exactly in both digit and
 * position (called "bulls") and how many digits match the secret number but
 * locate in the wrong position (called "cows"). Your friend will use
 * successive guesses and hints to eventually derive the secret number.
 * 
 * Write a function to return a hint according to the secret number and
 * friend's guess, use A to indicate the bulls and B to indicate the cows. 
 * 
 * Please note that both secret number and friend's guess may contain duplicate
 * digits.
 * 
 * Example 1:
 * 
 * 
 * Input: secret = "1807", guess = "7810"
 * 
 * Output: "1A3B"
 * 
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * 
 * Example 2:
 * 
 * 
 * Input: secret = "1123", guess = "0111"
 * 
 * Output: "1A1B"
 * 
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a
 * cow.
 * 
 * Note: You may assume that the secret number and your friend's guess only
 * contain digits, and their lengths are always equal.
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {

        HashMap<Character, Integer> s = new HashMap<>();

        HashMap<Character, Integer> g = new HashMap<>();

        int A = 0;
        int B = 0;

        for (int i = 0; i < secret.length(); i++) {
            Character sc = secret.charAt(i);
            Character gc = guess.charAt(i);
            if (sc == gc) {
                A++;
                continue;
            }
            g.put(gc, g.getOrDefault(gc, 0) + 1);
            s.put(sc, s.getOrDefault(sc, 0) + 1);
        }

        for (Character c : s.keySet()) {
            B += Math.min(s.get(c), g.getOrDefault(c, 0));
        }

        return A + "A" + B + "B";
    }
    // 152/152 cases passed (6 ms)
    // Your runtime beats 51 % of java submissions
    // Your memory usage beats 5.26 % of java submissions (39.8 MB)
}
// @lc code=end

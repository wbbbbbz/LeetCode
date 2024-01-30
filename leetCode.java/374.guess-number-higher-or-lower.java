/*
 * @lc app=leetcode id=374 lang=java
 *
 * [374] Guess Number Higher or Lower
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return guessHelper(1, n);
    }

    private int guessHelper(int lower, int upper){
        if (lower == upper){
            return lower;
        }
        int num = lower + (upper - lower) / 2;
        int result = guess(num);
        switch (result) {
            case 0:
                return num;
            case 1:
                return guessHelper(num + 1, upper);
            case -1:
                return guessHelper(lower, num - 1);
            default:
                break;
        }
    }
}
// @lc code=end
/*
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Guess Number Higher or Lower.
 * Memory Usage: 40.4 MB, less than 76.31% of Java online submissions for Guess Number Higher or Lower.
 * 递归猜数字大小
 * 
 * 
 */


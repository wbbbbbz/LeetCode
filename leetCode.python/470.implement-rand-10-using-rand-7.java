/*
 * @lc app=leetcode id=470 lang=java
 *
 * [470] Implement Rand10() Using Rand7()
 */

// @lc code=start
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int a = rand7();
        int b = rand7();
        int mappedSum = (a - 1) * 7 + (b - 1);
        if (mappedSum >= 40){
            return rand10();
        }
        else {
            return (mappedSum % 10 + 1);
        }
    }
    // public int rand10() {
    //     return rand10Helper(rand7(), 49); 
    // }
    // private int rand10Helper(int a, int totalRange){
    //     // System.out.println("a = " + a);
    //     // System.out.println("totalRange = " + totalRange);
    //     int b = rand7();
    //     int mappedSum = (a - 1) * (totalRange / 7) + (b - 1);
    //     int firstTen = totalRange - (totalRange % 10);
    //     if (mappedSum >= firstTen){
    //         if (totalRange == 21){
    //             return rand10Helper(rand7(), 49);
    //         }
    //         return rand10Helper(rand7(), (totalRange % 10) * 7);
    //     }
    //     else {
    //         return (mappedSum % 10 + 1);
    //     }
    // }
}
// @lc code=end


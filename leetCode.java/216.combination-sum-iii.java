import java.util.*;
/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 *
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (55.08%)
 * Likes:    1062
 * Dislikes: 51
 * Total Accepted:    167.7K
 * Total Submissions: 297.6K
 * Testcase Example:  '3\n7'
 *
 * 
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Note:
 * 
 * 
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */

// @lc code=start
class Solution {
    
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int i = 1; i < 10; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(i);
            genCom(i + 1, k-1, n-i, list);
        }

        return res;
    }

    private void genCom(int start, int counts, int rest, LinkedList<Integer> com){
        if (counts == 0 && rest == 0){
            res.add(new LinkedList<Integer>(com));
        }
        if (counts <= 0 || rest <= 0){
            return;
        }
        for (int i = start; i < 10; i++) {
            com.add(i);
            genCom(i + 1, counts - 1, rest - i, com);
            com.pollLast();
        }
        // 0ms
    }
}
// @lc code=end


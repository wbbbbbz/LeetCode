import java.util.*;
/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (46.26%)
 * Likes:    1803
 * Dislikes: 67
 * Total Accepted:    330K
 * Total Submissions: 688.9K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {

    List<List<Integer>> res = new LinkedList<>();

    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        this.candidates = candidates;

        for (int i = 0; i < candidates.length;) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(candidates[i]);
            getCom(i + 1, target - candidates[i], list);
            i++;
            while (i < candidates.length && candidates[i - 1] == candidates[i]){
                i++;
            }
        }

        return res;
        
    }

    private void getCom(int start, int rest, LinkedList<Integer> com){
        if (rest == 0){
            res.add(new LinkedList<Integer>(com));
            return;
        }
        if (start >= candidates.length || rest < 0){
            return;
        }
        for (int i = start; i < candidates.length;) {
            com.add(candidates[i]);
            getCom(i + 1, rest - candidates[i], com);
            i++;
            while (i < candidates.length && candidates[i - 1] == candidates[i]){
                i++;
            }
            com.pollLast();
        }
        // 4ms
    }
}
// @lc code=end


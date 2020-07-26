import java.util.*;
/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (54.06%)
 * Likes:    3917
 * Dislikes: 119
 * Total Accepted:    547K
 * Total Submissions: 980.1K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
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
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * Each element of candidate is unique.
 * 1 <= target <= 500
 * 
 * 
 */

// @lc code=start
class Solution {

    private List<List<Integer>> res = new LinkedList<>();

    private int[] candidates;

    private int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        this.candidates = candidates;

        this.target = target;

        for (int i = 0; i < candidates.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(candidates[i]);
            genCom(i, target-candidates[i], list);
        }

        return res;

    }

    private void genCom(int start, int rest, LinkedList<Integer> list){
        if (rest < 0){
            return;
        }
        if (rest == 0){
            res.add(new LinkedList<Integer>(list));
            return;
        }
        for (int i = start; i < this.candidates.length; i++) {
            list.add(candidates[i]);
            genCom(i, rest-candidates[i], list);
            list.pollLast();
        }
        // 3ms
    }
}
// @lc code=end


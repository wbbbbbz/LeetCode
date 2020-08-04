import java.util.*;
/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (61.20%)
 * Likes:    3982
 * Dislikes: 105
 * Total Accepted:    618.8K
 * Total Submissions: 978.3K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {

    private List<List<Integer>> res = new LinkedList<>();

    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0){
            return res;
        }

        this.nums = nums;

        LinkedList<Integer> path = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            boolean[] visited = new boolean[nums.length];
            visited[i] = true;
            path.add(nums[i]);
            genPermutation(visited, nums.length - 1, path);
            path.pollLast();
        }
        return res;
    }

    private void genPermutation(boolean[] visited, int rest, LinkedList<Integer> perm){
        if (rest == 0){
            res.add(new LinkedList<Integer>(perm));
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]){
                visited[i] = true;
                perm.add(nums[i]);
                genPermutation(visited.clone(), rest - 1, perm);
                perm.pollLast();
                visited[i] = false;
            }
        }
        // 2ms, 39.8MB
    }
}
// @lc code=end


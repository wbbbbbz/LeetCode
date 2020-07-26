import java.util.*;
/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (44.80%)
 * Likes:    1968
 * Dislikes: 61
 * Total Accepted:    356.1K
 * Total Submissions: 770.3K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {

    private List<List<Integer>> res = new LinkedList<>();

    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums == null || nums.length == 0){
            return res;
        }

        Arrays.sort(nums);

        this.nums = nums;
        
        for (int i = 0; i < nums.length;) {
            boolean[] visited = new boolean[nums.length];
            visited[i] = true;
            genPermutation(visited, nums.length - 1, new LinkedList<Integer>(Arrays.asList(nums[i])));
            i++;
            while (i < nums.length && nums[i - 1] == nums[i]){
                i++;
            }
        }
        return res;
    }

    private void genPermutation(boolean[] visited, int rest, LinkedList<Integer> perm){
        if (rest == 0){
            res.add(new LinkedList<Integer>(perm));
        }
        for (int i = 0; i < visited.length;) {
            if (!visited[i]){
                visited[i] = true;
                LinkedList<Integer> temp = new LinkedList<>(perm);
                temp.add(this.nums[i]);
                genPermutation(visited.clone(), rest - 1, temp);
                visited[i] = false;
                i++;
                while (i < nums.length && nums[i - 1] == nums[i]){
                    i++;
                }
            } else {
                i++;
            }
        }
        // 3ms
    }
}
// @lc code=end


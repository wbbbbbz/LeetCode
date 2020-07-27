import java.util.*;
/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (58.79%)
 * Likes:    3930
 * Dislikes: 85
 * Total Accepted:    596.4K
 * Total Submissions: 966.8K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {

    private List<List<Integer>> res = new LinkedList<>();

    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        
        Arrays.sort(nums);

        this.nums = nums;

        for (int i = 0; i < nums.length; i++) {
            
            // 该元素不加入
            getCom(i + 1, nums.length - 1, new LinkedList<>());
            // 该元素加入
            LinkedList<Integer> list = new LinkedList<>();
            list.add(nums[i]);
            getCom(i + 1, nums.length - 1, list);
        }

        return res;
    }

    private void getCom(int start, int rest, LinkedList<Integer> com){
        if (rest == 0){
            res.add(new LinkedList<Integer>(com));
            return;
        }
        if (start >= nums.length){
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // 该元素不加入
            getCom(i + 1, rest - 1, com);
            // 该元素加入
            com.add(nums[i]);
            getCom(i + 1, rest - 1, com);
            com.pollLast();
        }
        // 1ms
    }
}
// @lc code=end


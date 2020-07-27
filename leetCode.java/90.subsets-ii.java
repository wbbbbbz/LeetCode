import java.util.*;
/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (45.72%)
 * Likes:    1693
 * Dislikes: 73
 * Total Accepted:    282.2K
 * Total Submissions: 601.3K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new LinkedList<>();

    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);

        this.nums = nums;

        res.add(new LinkedList<Integer>());

        for (int j = 1; j <= nums.length; j++) {
            for (int i = 0; i < nums.length;) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(nums[i]);
                getCom(i + 1, j - 1, list);
                i++;
                while (i < nums.length && nums[i] == nums[i-1]){
                    i++;
                }
            }
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
        for (int i = start; i < nums.length;) {
            com.add(nums[i]);
            getCom(i + 1, rest - 1, com);
            com.pollLast();
            i++;
            while (i < nums.length && nums[i] == nums[i-1]){
                i++;
            }
        }
        // 2ms
    }
}
// @lc code=end


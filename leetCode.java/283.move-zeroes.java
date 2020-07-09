/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (57.21%)
 * Likes:    3796
 * Dislikes: 123
 * Total Accepted:    839.6K
 * Total Submissions: 1.5M
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        // 记录非0元素的个数为j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果该元素不是0，那么就让nums[j] = nums[i]
            if (nums[i] != 0)
                nums[j++] = nums[i];
        }
        while(j < nums.length){
            nums[j++] = 0;
        }
//         21/21 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 26.03 % of java submissions (40.2 MB)
    }
}
// @lc code=end


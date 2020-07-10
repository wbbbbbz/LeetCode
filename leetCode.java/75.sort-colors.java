/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (45.12%)
 * Likes:    3417
 * Dislikes: 226
 * Total Accepted:    512.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * 
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * 
 * Follow up:
 * 
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 * 
 * 
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        // 三路快排思想
        // 保持两个变量i和j，保证最后的结果是
        // [0, i)是0, [i, j]是1(最后才能完成，同时使搜索的范围)，(j, n-1]是2
        int i = 0;
        int j = nums.length - 1;
        int n = 0;

        while (n <= j) {
            if (nums[n] == 0) {
                nums[n++] = nums[i];
                nums[i++] = 0;
            } else if (nums[n] == 2) {
                nums[n] = nums[j];
                nums[j--] = 2;
            } else {
                n++;
            }
        }
        // 87/87 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 8.97 % of java submissions (39.6 MB)

    }
}
// @lc code=end

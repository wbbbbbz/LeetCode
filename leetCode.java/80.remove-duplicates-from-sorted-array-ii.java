/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 *
 * algorithms
 * Medium (42.90%)
 * Likes:    1150
 * Dislikes: 697
 * Total Accepted:    262.5K
 * Total Submissions: 601.1K
 * Testcase Example:  '[1,1,1,2,2,3]'
 *
 * Given a sorted array nums, remove the duplicates in-place such that
 * duplicates appeared at most twice and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * Example 1:
 * 
 * 
 * Given nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3 respectively.
 * 
 * It doesn't matter what you leave beyond the returned length.
 * 
 * Example 2:
 * 
 * 
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * 
 * Your function should return length = 7, with the first seven elements of
 * nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 * 
 * It doesn't matter what values are set beyond the returned length.
 * 
 * 
 * Clarification:
 * 
 * Confused why the returned value is an integer but your answer is an array?
 * 
 * Note that the input array is passed in by reference, which means
 * modification to the input array will be known to the caller as well.
 * 
 * Internally you can think of this:
 * 
 * 
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * 
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len
 * elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 
 * 
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // if (nums == null || nums.length == 0)
        //     return 0;
        // // 通过变量nonRep记录没有重复的元素的subArray的尾index
        // // 将array分成[0, nonRep]和(nonRep, n-1]两个array
        // if (nums.length == 1) {
        //     return 1;
        // }
        // int nonRep = 0;
        // if (nums[1] == nums[0]) {
        //     nonRep = 1;
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != nums[nonRep]) {
        //         if (i == nums.length - 1 || nums[i + 1] != nums[i]) {
        //             nums[++nonRep] = nums[i];
        //         } else {
        //             nums[++nonRep] = nums[i];
        //             nums[++nonRep] = nums[i];
        //         }
        //     }
        // }
        // return nonRep + 1;

        // // 166/166 cases passed (1 ms)
        // // Your runtime beats 38.43 % of java submissions
        // // Your memory usage beats 14.37 % of java submissions (41.7 MB)

        // 参考评论区答案
        // 切分成[0, i)是去重后的subArray，[i, n-1]是搜索的部分
        // 1. 前两个不管是否重复都不管
        // 2. 如果搜索的元素和i-2一样的话，说明[i-2, 搜索元素]部分是重复的，这个重复一定大于2（因为搜索元素的index>=i）
        // 这种时候就要继续搜索到下一个和i-2不一样的元素为止，并且进行替换
        // 只要还是重复的，i就不会增加，继续停在该搜索位置
        // 所以就能保证重复的元素一定最多只有两个
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
// @lc code=end

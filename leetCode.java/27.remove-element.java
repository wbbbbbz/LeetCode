/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 *
 * https://leetcode.com/problems/remove-element/description/
 *
 * algorithms
 * Easy (47.30%)
 * Likes:    1444
 * Dislikes: 2703
 * Total Accepted:    618.9K
 * Total Submissions: 1.3M
 * Testcase Example:  '[3,2,2,3]\n3'
 *
 * Given an array nums and a value val, remove all instances of that value
 * in-place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave
 * beyond the new length.
 * 
 * Example 1:
 * 
 * 
 * Given nums = [3,2,2,3], val = 3,
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 * 
 * It doesn't matter what you leave beyond the returned length.
 * 
 * 
 * Example 2:
 * 
 * 
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * 
 * Your function should return length = 5, with the first five elements of nums
 * containing 0, 1, 3, 0, and 4.
 * 
 * Note that the order of those five elements can be arbitrary.
 * 
 * It doesn't matter what values are set beyond the returned length.
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
 * int len = removeElement(nums, val);
 * 
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len
 * elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */

// @lc code=start
class Solution {
    // testcase: '[0,1,2,2,3,0,4,2]\n2'
    // testcase: '[1]\n1'
    // testcase: '[3, 3]\n3'
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        // 因为顺序无所谓，所以直接跟最后的元素进行交换
        // 使用两个index, i为前向，j为后向。
        // 将array分成三段。[0, i)为非val部分，[i, j]为搜索部分，(j, n-1]为val部分
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                if (nums[j] == val) {
                    j--;
                } else {
                    nums[i++] = nums[j];
                    nums[j--] = val;
                }
            } else {
                i++;
            }
        }
        return i;

        // 113/113 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 13.28 % of java submissions (39.5 MB)
    }
}
// @lc code=end

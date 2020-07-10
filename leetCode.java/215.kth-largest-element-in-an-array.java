import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (53.16%)
 * Likes:    3726
 * Dislikes: 251
 * Total Accepted:    632.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 */

// @lc code=start
class Solution {
    // testcase:[3,2,3,1,2,4,5,5,6]\n4
    // testcase:[1,2,3,4,5,6]\n1
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        // // 暴力方法，排序
        // Arrays.sort(nums);
        // return nums[nums.length - k];
        // // 32/32 cases passed (4 ms)
        // // Your runtime beats 66.51 % of java submissions
        // // Your memory usage beats 15.74 % of java submissions (42 MB)
        // 利用多排的partition方法找出第k大元素
        partition(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
        // 32/32 cases passed (1 ms)
        // Your runtime beats 98.17 % of java submissions
        // Your memory usage beats 94.43 % of java submissions (39.4 MB)
    }

    // 对[left, right]部分进行partition分组
    private void partition(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int pivot = nums[left + (right - left) / 2];
        // [left, lt) < pivot
        // (rt, right] > pivot
        int lt = left;
        int rt = right;
        int n = left;
        while (n <= rt) {
            if (nums[n] < pivot) {
                swap(nums, lt++, n++);
            } else if (nums[n] > pivot) {
                swap(nums, n, rt--);
            } else {
                n++;
            }
        }
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i] + ", ");
        // }
        // System.out.println();
        if (k < lt) {
            partition(nums, left, lt - 1, k);
        } else if (k > rt) {
            partition(nums, rt + 1, right, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (38.49%)
 * Likes:    2212
 * Dislikes: 4169
 * Total Accepted:    595.8K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to
 * hold additional elements from nums2.
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * Output: [1,2,2,3,5,6]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 * 
 * 
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || (m == 0 && n == 0)) {
            return;
        }
        // 对于num1来说：
        // [0, m-1]是第一个array，[m, m+n-1]是空白array
        // 对于num2来说：
        // [0, n-1]是一个array
        // 因为空白array是在右边，所以可以从最大值部分开始。
        // 保证num1[m-1]和num2[n-1]一定是需要对比的项，然后num1[m+n-1]是需要放结果的地方
        // 条件是m-1>=0, n-1>=0
        // 如果n==0了，那么就不用排了，因为nums1就是答案
        // 如果m==0了，那么需要将n减到==0为止即可
        while (n >= 1) {
            if (m != 0 && nums1[m - 1] >= nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
        // 59/59 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 29.65 % of java submissions (39.8 MB)
    }
}
// @lc code=end

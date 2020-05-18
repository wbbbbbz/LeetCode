/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (28.70%)
 * Likes:    6648
 * Dislikes: 1022
 * Total Accepted:    650.7K
 * Total Submissions: 2.2M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */

// @lc code=start
class Solution {
    // [1,3]\n[2,4]
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 == 0) {
            if (l2 % 2 == 1)
                return nums2[l2 / 2];
            return (nums2[l2 / 2 - 1] + nums2[l2 / 2]) / 2.0;
        }
        if (l2 == 0) {
            if (l1 % 2 == 1)
                return nums1[l1 / 2];
            return (nums1[l1 / 2 - 1] + nums1[l1 / 2]) / 2.0;
        }
        boolean b1 = true;
        boolean b2 = true;
        int totalLength = l1 + l2;
        int l = 0;
        int r = 0;

        for (int i = 0; i < (totalLength - 1) / 2; i++) {
            if (b1 && b2) {
                if (nums1[l] <= nums2[r])
                    l++;
                else
                    r++;
            } else if (b1)
                l++;
            else
                r++;
            if (l >= l1)
                b1 = false;
            else if (r >= l2)
                b2 = false;
        }
        if (totalLength % 2 == 1) {
            if (b1 && b2)
                return nums1[l] <= nums2[r] ? nums1[l] : nums2[r];
            return b1 ? nums1[l] : nums2[r];
        }

        double res = 0.0;
        for (int i = 0; i < 2; i++) {
            if (!b1)
                res += nums2[r++];
            else if (!b2)
                res += nums1[l++];
            else {
                if (nums1[l] <= nums2[r])
                    res += nums1[l++];
                else
                    res += nums2[r++];
            }
            if (l >= l1)
                b1 = false;
            else if (r >= l2)
                b2 = false;
        }
        return res / 2.0;

        // 2085/2085 cases passed (2 ms)
        // Your runtime beats 99.78 % of java submissions
        // Your memory usage beats 100 % of java submissions (40.8 MB)

        if (l1 > l2)
            return findMedianSortedArrays(nums2, nums1);

        // int c1 = 0;
        // int c2 = 0;
        // int c1i = (l1 + l2 - 1) / 2;
        // int c2i = c1i + 1;
        // if (nums1[l1 - 1] <= nums2[0]) {
        //     c1 = c1i > (l1 - 1) ? nums2[c1i - l1] : nums1[c1i];
        //     c2 = c2i > (l1 - 1) ? nums2[c2i - l1] : nums1[c2i];
        // } else if (nums2[l2 - 1] <= nums1[0]) {
        //     c1 = c1i > (l2 - 1) ? nums1[c1i - l2] : nums2[c1i];
        //     c2 = c2i > (l2 - 1) ? nums1[c2i - l2] : nums2[c2i];
        // } else {
        //     int l = 0;
        //     int r = l1 - 1;
        //     int mid = l + (r - l) / 2;
        //     while(l<=r){
        //         if(nums1[mid]<nums2[l1+l2-mid])
        //     }
        // }

        // if ((l1 + l2) % 2 == 1)
        //     return c1;
        // return (c1 + c2) / 2.0;
    }
}
// @lc code=end

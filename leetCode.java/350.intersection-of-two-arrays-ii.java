import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 *
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 *
 * algorithms
 * Easy (50.63%)
 * Likes:    1146
 * Dislikes: 365
 * Total Accepted:    313K
 * Total Submissions: 618K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * 
 * 
 * Note:
 * 
 * 
 * Each element in the result should appear as many times as it shows in both
 * arrays.
 * The result can be in any order.
 * 
 * 
 * Follow up:
 * 
 * 
 * What if the given array is already sorted? How would you optimize your
 * algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is
 * better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 1. 使用map记录次数，并且每一次减少对应的次数，0就删掉对应的key
        // 2. 对两个数组进行排序，然后在短的数组上保持一个指针，出现一样的就移动指针，并且记录，最终输出记录
        // 3. 创建一个记录次数的数组，数组的size与nums1一致。次数为0的就不再加入。(但是无法应对极端数字的情况)

        // Testcase: [4,9,5]\n[9,4,9,8,4]
        // Testcase: [-2147483648,1,2,3]\n[1,-2147483648,-2147483648]
        // 1.
        // 0. 保证nums1是较短的数组
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            temp = null;
        }
        // 1. 创建map
        Map<Integer, Integer> times = new HashMap<>();
        for (int num : nums1) {
            times.put(num, times.getOrDefault(num, 0) + 1);
        }
        // 2. 遍历nums2，抵消次数
        int[] output = new int[nums1.length];
        int idx = 0;
        for (int num : nums2) {
            if (times.containsKey(num) && times.get(num) >= 1) {
                times.put(num, times.get(num) - 1);
                output[idx++] = num;
            }
        }
        return Arrays.copyOf(output, idx);

    }
    // 61/61 cases passed (2 ms)
    // Your runtime beats 97.71 % of java submissions
    // Your memory usage beats 6.45 % of java submissions (39.6 MB)
}
// @lc code=end

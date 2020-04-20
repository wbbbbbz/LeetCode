import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (60.32%)
 * Likes:    686
 * Dislikes: 1105
 * Total Accepted:    325.7K
 * Total Submissions: 539.3K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * 
 * 
 * Note:
 * 
 * 
 * Each element in the result must be unique.
 * The result can be in any order.
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.Builder b = IntStream.builder();
        for (int num : nums1) {
            map.put(num, 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num)) {
                b.add(num);
                map.remove(num);
            }
        }
        return b.build().toArray();

    }

    // 60/60 cases passed (4 ms)
    // Your runtime beats 26.09 % of java submissions
    // Your memory usage beats 6.75 % of java submissions (39.5 MB)
}
// @lc code=end

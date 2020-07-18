import java.util.TreeMap;

/*
 * @lc app=leetcode id=220 lang=java
 *
 * [220] Contains Duplicate III
 *
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 *
 * algorithms
 * Medium (20.61%)
 * Likes:    1053
 * Dislikes: 1117
 * Total Accepted:    124.2K
 * Total Submissions: 594.6K
 * Testcase Example:  '[1,2,3,1]\n3\n0'
 *
 * Given an array of integers, find out whether there are two distinct indices
 * i and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    // testcase: [1,5,9,1,5,9]\n2\n3
    // testcase: [0,2147483647]\n1\n2147483647
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || t < 0 || k < 0) {
            return false;
        }

        TreeMap<Long,Long> map = new TreeMap<>();

        long tl = (long)t;

        for (int i = 0; i < nums.length; i++) {
            long num = (long)nums[i];
            // System.out.println(map);
            if ( i > k && map.get((long)nums[i - k - 1]) == 1){
                map.remove((long)nums[i - k - 1]);
            }
            Long temp = map.ceilingKey(num - tl);
            // System.out.println(temp);
            if (i > 0 && temp != null && temp <= num + tl){
                return true;
            }
            map.merge(num, 1l, Long::sum);
        }

        return false;

//         41/41 cases passed (24 ms)
// Your runtime beats 33.99 % of java submissions
// Your memory usage beats 8.16 % of java submissions (43 MB)
    }
}
// @lc code=end


import java.util.HashMap;

/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 *
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (37.02%)
 * Likes:    769
 * Dislikes: 932
 * Total Accepted:    258.4K
 * Total Submissions: 694.4K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        // 使用hashmap存储每一个元素的lastIndex
        HashMap<Integer, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (lastIndex.containsKey(curr) && i - lastIndex.get(curr) <= k)
                return true;
            lastIndex.put(curr, i);
        }
        return false;

        // 23/23 cases passed (5 ms)
        // Your runtime beats 89.01 % of java submissions
        // Your memory usage beats 10.53 % of java submissions (44.8 MB)
    }
}
// @lc code=end

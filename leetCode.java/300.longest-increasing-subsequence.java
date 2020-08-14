import java.util.Arrays;

/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (42.12%)
 * Likes:    5043
 * Dislikes: 111
 * Total Accepted:    398.3K
 * Total Submissions: 934.3K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * Example:
 * 
 * 
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4. 
 * 
 * Note: 
 * 
 * 
 * There may be more than one LIS combination, it is only necessary for you to
 * return the length.
 * Your algorithm should run in O(n^2) complexity.
 * 
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 */

// @lc code=start
class Solution {
    // testcase: [10,9,2,5,3,7,101,18,12,45,7,551,232,4,9,5,16,84,6,56,21,32,198,46,51,32,13,54,684,456]
    public int lengthOfLIS(int[] nums) {

        if (nums == null){
            return 0;
        }

        if (nums.length <= 1){
            return nums.length;
        }

        int[] sub = new int[nums.length + 1];
        int index = 0;
        Arrays.fill(sub, Integer.MAX_VALUE);
        sub[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = Arrays.binarySearch(sub, 0, index + 1, nums[i]);
            if (temp < 0){
                temp = - temp - 1;
            }
            sub[temp] = nums[i];
            if (temp > index){
                index++;
            }
            // System.out.println(Arrays.toString(sub));
            // System.out.println(String.format("temp: %d, num: %d, index: %d", temp, nums[i], index));
        }

        return index + 1;
        // 0ms, 37.1MB
        
    }
}
// @lc code=end


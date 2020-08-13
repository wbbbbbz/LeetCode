/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 *
 * https://leetcode.com/problems/combination-sum-iv/description/
 *
 * algorithms
 * Medium (44.62%)
 * Likes:    1466
 * Dislikes: 181
 * Total Accepted:    128K
 * Total Submissions: 282.5K
 * Testcase Example:  '[1,2,3]\n4'
 *
 * Given an integer array with all positive numbers and no duplicates, find the
 * number of possible combinations that add up to a positive integer target.
 * 
 * Example:
 * 
 * 
 * nums = [1, 2, 3]
 * target = 4
 * 
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 
 * Note that different sequences are counted as different combinations.
 * 
 * Therefore the output is 7.
 * 
 * 
 * 
 * 
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 * 
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test
 * cases.
 * 
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {

        // 用i个数字凑出C数字的组合数
        // F(i, C) = sigma(F(i - 1, C - nums[j])) j是nums种所有的可能性

        if (nums == null || nums.length == 0 || target <= 0){
            return 0;
        }

        Arrays.sort(nums);

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0){
                    dp[i] += dp[i - nums[j]];
                } else {
                    break;
                }
            }
        }

        return dp[target];

        // 1ms, 36.6MB
    }
}
// @lc code=end


import java.util.Arrays;

/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 *
 * https://leetcode.com/problems/target-sum/description/
 *
 * algorithms
 * Medium (46.52%)
 * Likes:    2779
 * Dislikes: 112
 * Total Accepted:    173.8K
 * Total Submissions: 375.2K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a
 * target, S. Now you have 2 symbols + and -. For each integer, you should
 * choose one from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * Example 1:
 * 
 * 
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
 * Output: 5
 * Explanation: 
 * 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {

        // 背包问题
        // 从[0...i]的元素中通过+，-法能得到C的个数
        // C有可能小于0，所以先计算nums的和然后创造2sum + 1([-sum, sum])长度的动态规划数组
        // F(i, C) = F(i - 1, C - nums[j]) + F(i - 1, C + nums[j])
        // 因为状态转移方程取决于前后的元素，所以需要两行动态规划数组进行计算

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (Math.abs(S) > sum) {
            return 0;
        }

        // return solution1(nums, S, sum);

        // 优化
        // P for all positive, N for all negative
        // sum(P) - sum(N) = target
        // sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
        // 2 * sum(P) = target + sum(nums)
        // sum(P) = (target + sum(nums)) / 2
        // 这个时候就从必须拿所有元素变成0/1背包，也就是从所有元素中拿出positive元素
        // 从[0...i]中挑选元素组成C的可能性
        // F(i, C) = F(i - 1, C) + F(i - 1, C - nums[j])
        sum += S;
        if (sum % 2 == 1){
            return 0;
        }
        sum >>= 1;

        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0){
                    dp[j] += dp[j - nums[i]];
                }
            }
        }

        return dp[sum];
        // 2ms, 37.3MB

    }

    private int solution1(int[] nums, int S, int sum) {
        int[][] dp = new int[2][2 * sum + 1];

        dp[0][sum] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                if (j - nums[i] >= 0) {
                    dp[1][j] += dp[0][j - nums[i]];
                }
                if (j + nums[i] <= 2 * sum) {
                    dp[1][j] += dp[0][j + nums[i]];
                }
            }
            dp[0] = dp[1].clone();
            Arrays.fill(dp[1], 0);
            // System.out.println(Arrays.deepToString(dp));
        }

        return dp[0][S + sum];

        // 17ms, 39.6MB
    }
}
// @lc code=end

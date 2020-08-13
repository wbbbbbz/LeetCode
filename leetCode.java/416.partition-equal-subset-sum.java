import java.util.Arrays;

/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 *
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (42.65%)
 * Likes:    2814
 * Dislikes: 73
 * Total Accepted:    189.9K
 * Total Submissions: 434.6K
 * Testcase Example:  '[1,5,11,5]'
 *
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 * 
 * Note:
 * 
 * 
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [1, 5, 11, 5]
 * 
 * Output: true
 * 
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1, 2, 3, 5]
 * 
 * Output: false
 * 
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {

    // testcase: [1,2,5]

    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;
        if (nums[0] == sum) {
            return true;
        }

        // 变成往背包中加入物品，使总价值恰好为sum的一半。
        // F(i, C) = F(i - 1, c) || F(i - 1, c - w(i))
        // 用i个物品填满C的背包，如果i-1能填满，那么i个物品也能。
        // 或者i-1个物品已经填满了c-w(i)的背包，那么i个物品继续使用即可
        // 用i行C列的array来存储结果。i行代表是用[0, i]的物品，C代表背包容量
        // 最后只要看C列有没有任意一个结果是true即可
        // return solution1(nums, sum);

        // 进行优化
        // 可以从转移方程看出只需要上一行的左边的信息。所以每一次从右边更新即可

        boolean[] dp = new boolean[sum];

        for (int j = 0; j < sum; j++) {
            dp[j] = nums[0] == j + 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = sum - 1; j >= 0; j--) {
                dp[j] = dp[j] || (j - nums[i] >= 0 && dp[j - nums[i]]);
            }
            if (dp[sum - 1]){
                return true;
            }
        }
        return false;

        // 12ms, 37.6MB

    }

    private boolean solution1(int[] nums, int sum) {
        boolean[][] dp = new boolean[nums.length][sum];

        for (int j = 0; j < sum; j++) {
            dp[0][j] = nums[0] == j + 1;
        }
        // System.out.println(Arrays.toString(dp[0]));
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < sum; j++) {
                dp[i][j] = dp[i - 1][j] || (j - nums[i] >= 0 && dp[i - 1][j - nums[i]]);
            }
            // System.out.println(Arrays.toString(dp[i]));
            if (dp[i][sum - 1]){
                return true;
            }
        }

        return false;

        // 17ms, 39.5MB
    }

}
// @lc code=end

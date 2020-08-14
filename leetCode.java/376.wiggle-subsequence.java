/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 *
 * https://leetcode.com/problems/wiggle-subsequence/description/
 *
 * algorithms
 * Medium (39.06%)
 * Likes:    1009
 * Dislikes: 59
 * Total Accepted:    70.1K
 * Total Submissions: 176.9K
 * Testcase Example:  '[1,7,4,9,2,5]'
 *
 * A sequence of numbers is called a wiggle sequence if the differences between
 * successive numbers strictly alternate between positive and negative. The
 * first difference (if one exists) may be either positive or negative. A
 * sequence with fewer than two elements is trivially a wiggle sequence.
 * 
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences
 * (6,-3,5,-7,3) are alternately positive and negative. In contrast,
 * [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its
 * first two differences are positive and the second because its last
 * difference is zero.
 * 
 * Given a sequence of integers, return the length of the longest subsequence
 * that is a wiggle sequence. A subsequence is obtained by deleting some number
 * of elements (eventually, also zero) from the original sequence, leaving the
 * remaining elements in their original order.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * Explanation: The entire sequence is a wiggle sequence.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * Explanation: There are several subsequences that achieve this length. One is
 * [1,17,10,13,10,16,8].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * 
 * Follow up:
 * Can you do it in O(n) time?
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {

        if(nums == null){
            return 0;
        }

        int n = nums.length;

        if (n <= 1){
            return n;
        }

        // return solution1(nums, n);
        
        // 优化。对于每个数字根上一个数字比较都有三种情况
        // 大于，小于，等于
        // 大于的时候，到上一个数字为止的小于 + 1
        // 小于就是大于 + 1
        // 等于直接无视
        // if nums[i] > nums[i - 1], up = down + 1
        // if nums[i] < nums[i - 1], down = up + 1

        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]){
                up = down + 1;
            } else if (nums[i] < nums[i - 1]){
                down = up + 1;
            }
        }

        return Math.max(up, down);
        // 0ms, 36.7MB
    }

    private int solution1(int[] nums, int n) {
        if (n == 2){
            if (nums[1] == nums[0]){
                return 1;
            }
            return 2;
        }


        // LIS问题
        // 构建与原数组相同大小的数组，然后记录一个flag
        // 比如说flag为true的时候需要加入一个小于的数组，flag为false的时候加入大于的数字

        int[] dp = nums.clone();
        int index = 1;
        int temp = 2;
        while(dp[1] == dp[0] && temp < n){
            dp[1] = dp[temp++];
        }
        if (dp[1] - dp[0] == 0){
            return 1;
        }
        boolean isBigger = dp[1] - dp[0] > 0;

        for (int i = temp; i < n; i++) {
            if ((isBigger && nums[i] < dp[index]) || (!isBigger && nums[i] > dp[index])){
                dp[++index] = nums[i];
                isBigger = !isBigger;
            } else if ((isBigger && nums[i] > dp[index]) || (!isBigger && nums[i] < dp[index])){
                dp[index] = nums[i];
            }
            // System.out.println(Arrays.toString(dp));
            // System.out.println(String.format("isBigger: %b, i: %d, index: %d", isBigger, i, index));
        }

        return index + 1;

        // 0ms, 37MB
    }
}
// @lc code=end


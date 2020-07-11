import javax.swing.text.html.FormView;

/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (37.04%)
 * Likes:    2355
 * Dislikes: 106
 * Total Accepted:    268.5K
 * Total Submissions: 708.8K
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example: 
 * 
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution of
 * which the time complexity is O(n log n). 
 * 
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // testcase:12\n[1,2,3,4,5,6,5,6,3,3,5,3,2,6,3,4,6,6,2,3,5,6,3,2,5,4,6,2,43,6,4,2,3,6]
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 滑动窗口
        // 每次判断[i, j]（滑动窗口）里面的大小。如果过小就j++
        // 如果初始化不想包含任何元素，那么j = -1
        // while的条件是左边界可以取值。因为左边界可以取值的话有边界也可以！
        // 右边界移动的时候需要判断边界值！
        // 如果[i, j]大于等于s的话，只是需要更新minSize，然后还要继续搜索，i++。因为不能确保一定是最小的
        // 上述情况不用担心i比j还大，因为如果i==j并且还是大于等于s的话，那么就已经是最短解了
        // 如果有负数就会更麻烦
        // int i = 0;
        // int j = -1;
        // int minSize = nums.length + 1;
        // int subSum = 0;
        // while (i < nums.length) {
        //     if (subSum >= s) {
        //         minSize = Math.min(minSize, j - i + 1);
        //         subSum -= nums[i++];
        //     } else if (j == nums.length - 1) {
        //         break;
        //     } else {
        //         subSum += nums[++j];
        //     }
        //     // System.out.println("minSize: " + minSize + ", i: " + i + ", j: " + j);
        // }
        // return minSize == (nums.length + 1) ? 0 : minSize;
        // // 15/15 cases passed (3 ms)
        // // Your runtime beats 23.51 % of java submissions
        // // Your memory usage beats 17.17 % of java submissions (41.9 MB)

        // leetCode官方解法
        // 内部用while，外循环保证每一次右边界都拓展
        // 虽然也是滑动窗口，更像是判断在每一个右边界下的最短子字符串的长度
        // 每一次判断都是从上一个最短子字符串-1开始。如果大于了就可以继续缩小，如果小于的话这个右边界最短子字符串肯定比前一个长。
        int left = 0;
        int minSize = nums.length + 1;
        int subSum = 0;
        for(int i = 0; i < nums.length; i++){
            subSum += nums[i];
            while (subSum >= s){
                minSize = Math.min(minSize, i - left + 1);
                subSum -= nums[left++];
            }
        }
        return minSize == (nums.length + 1) ? 0 : minSize;
    }
}

// @lc code=end

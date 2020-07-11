/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (52.96%)
 * Likes:    1661
 * Dislikes: 607
 * Total Accepted:    411.3K
 * Total Submissions: 764.8K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 * 
 * Note:
 * 
 * 
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.
 * 
 * 
 * Example:
 * 
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * 
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2 || target < numbers[0]) {
            return null;
        }
        // 1. 全部组合试一遍
        // for (int i = 0; i < numbers.length - 1; i++) {
        // for (int j = i + 1; j < numbers.length; j++) {
        // if (numbers[i] + numbers[j] == target) {
        // return new int[] { i + 1, j + 1 };
        // }
        // // 如果大于了也不用再找了
        // if (numbers[i] + numbers[j] > target) {
        // break;
        // }
        // }
        // }
        // return null;
        // 17/17 cases passed (94 ms)
        // Your runtime beats 9.49 % of java submissions
        // Your memory usage beats 14 % of java submissions (41.5 MB)
        // 1的暴力解法还可以优化
        // 如果外层循环在j之后就大于target，那么下一次循环肯定不用到j，因为数组是有序的
        // right保持为搜索的上限。搜索[i, right]范围的所有组合
        // int right = numbers.length - 1;
        // int i = 0;
        // while (right > i) {
        //     for (int j = i + 1; j <= right; j++) {
        //         if (numbers[i] + numbers[j] == target) {
        //             return new int[] { i + 1, j + 1 };
        //         }
        //         // 如果大于了也不用再找了
        //         if (numbers[i] + numbers[j] > target) {
        //             right = j - 1;
        //             break;
        //         }
        //     }
        //     i++;
        // }
        // return null;
        // 17/17 cases passed (86 ms)
        // Your runtime beats 10.33 % of java submissions
        // Your memory usage beats 59.21 % of java submissions (39.6 MB)
        
        // 2. 缩小搜索空间
        // 一开始搜索的是[0, n-1]，先取0和n-1之和。如果太小说明0这个元素一定不在答案里，太大说明n-1一定不在答案里
        // 逐步缩小范围即可
        // 维持两个变量。保证答案一定属于[i, j]当中
        int i = 0;
        int j = numbers.length - 1;
        while (i < j){
            int temp = numbers[i] + numbers[j];
            if (temp == target){
                return new int[]{i+1, j+1};
            } else if (temp < target){
                i++;
            } else {
                j--;
            }
        }
        return null;
//         17/17 cases passed (1 ms)
// Your runtime beats 61.13 % of java submissions
// Your memory usage beats 5.11 % of java submissions (42.1 MB)
    }
}
// @lc code=end

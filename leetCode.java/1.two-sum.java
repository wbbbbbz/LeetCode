import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ForkJoinPool;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (45.23%)
 * Likes:    15692
 * Dislikes: 569
 * Total Accepted:    3.1M
 * Total Submissions: 6.7M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 */

// @lc code=start
class Solution {
    // testcase: [3,2,4]\n6
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        // return solution1(nums, target);

        // 2. 将元素和序号的对应关系记录为map
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                LinkedList<Integer> temp = new LinkedList<>();
                temp.add(i);
                map.put(nums[i], temp);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                for (int j : map.get(target - nums[i])) {
                    if (i != j) {
                        return new int[] { i, j };
                    }
                }
            }
        }

        return null;

        // 29/29 cases passed (4 ms)
        // Your runtime beats 52.1 % of java submissions
        // Your memory usage beats 8.68 % of java submissions (41.8 MB)

    }

    private int[] solution1(int[] nums, int target) {
        // 1. 暴力算法
        // 将所有组合的和都算出，算到正确的时候返回即可
        // 可以优化一下，排序后再寻找
        // 但是这个题目排序后再寻找的话需要记录索引值的对应关系
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        return null;
        // 29/29 cases passed (64 ms)
        // Your runtime beats 21.98 % of java submissions
        // Your memory usage beats 16.51 % of java submissions (41 MB)
    }
}
// @lc code=end

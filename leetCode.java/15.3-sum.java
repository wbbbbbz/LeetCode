import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (25.92%)
 * Likes:    7207
 * Dislikes: 830
 * Total Accepted:    953.2K
 * Total Submissions: 3.6M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    // testcase:[-1, 0, 1, 2, -1, -4, -1, -1, -1, -1]
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int a = nums[i];
            if (a > 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                if (a + b > 0) {
                    break;
                }
                if (a + b + c == 0) {
                    res.add(Arrays.asList(a, b, c));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (a + b + c < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;

        // 313/313 cases passed (25 ms)
        // Your runtime beats 68.16 % of java submissions
        // Your memory usage beats 9.12 % of java submissions (56.6 MB)

    }

}
// @lc code=end

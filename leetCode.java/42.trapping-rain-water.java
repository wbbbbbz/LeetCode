/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */
import java.util.Arrays;
import java.util.Collections;
// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height.length <= 2){
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right){
            if (height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                ans += Math.max(leftMax - height[left], 0);
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                ans += Math.max(rightMax - height[right], 0);
                right--;
            }
        }
        return ans;
    }
}
// @lc code=end
/*
 * Runtime: 1 ms, faster than 99.76% of Java online submissions for Trapping Rain Water.
 * Memory Usage: 48.7 MB, less than 57.27% of Java online submissions for Trapping Rain Water.
 * 动态规划。重要思想，计算机一开始是看不见这个图像的，重要的是我们指示计算机从左看还是从右看，还是两个指针同时向内看
 * 这个题目有点类似于找水桶。而且每次指针转换一定是因为木桶高度更新了。木桶高度更新了就代表某一端出现了新高。
 */


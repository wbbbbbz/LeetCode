#
# @lc app=leetcode id=11 lang=python3
#
# [11] Container With Most Water
#

# @lc code=start

from typing import List
class Solution:
    def maxArea(self, height: List[int]) -> int:
        l, r = 0, len(height) - 1
        ans = 0
        while l < r:
            if height[l] <= height[r]:
                ans = max(ans, height[l] * (r - l))
                l += 1
            else:
                ans = max(ans, height[r] * (r - l))
                r -= 1
        return ans
    
# 当现在的l,r已经构建了之后，对短的那条线，如果中间任何线比这条线还短，那肯定水的体积少。如果中间任何线比这条线还长，但是因为底边短了(l-r)，然后高度又不变，所以可以得出中间不可能有边能跟这条短边构建更多的水了
# 所以如果要找更大的水的组合，肯定就不会包含这条短的线，可以去掉了
# O(n)时间复杂度
        
# @lc code=end


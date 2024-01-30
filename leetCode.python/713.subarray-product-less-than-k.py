#
# @lc app=leetcode id=713 lang=python3
#
# [713] Subarray Product Less Than K
#

# @lc code=start
from typing import List
class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        n = len(nums)
        l, r = 0, 0
        p = 1
        ans = 0
        for r in range(n):
            p *= nums[r]
            while p >= k:  # 因为有可能除等于1，刚好和元素相等，所以要判断l<=r。或者直接在前面判断k<=1的情况
                p /= nums[l]
                l += 1
            ans += r - l + 1 # 需要算的就是以右端点为r的子数组个数
        return ans
        
# [10,5,2,6,2,3,4,5,6,7,3,3,4,5,6,7,2,3,4,5,7,1,1,3,5,5,7,572,3,4,6,6,5,3,5,6,7,4]\n100
# [10,5,2,6,2,3,4,5,6,7,3,3,4,5,6,7,2,3,4,5,7,1,1,3,5,5,7,572,3,4,6,6,5,3,5,6,7,4]\n1
# [1,2,3]\n0
# @lc code=end


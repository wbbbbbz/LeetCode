#
# @lc app=leetcode id=209 lang=python3
#
# [209] Minimum Size Subarray Sum
#

# @lc code=start
from typing import List
from functools import cache
class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        # @cache
        # def sum_helper(nums: tuple[int]) -> int:
        #     if not nums:
        #         return 0
        #     return nums[0] + sum_helper(tuple(nums[1:]))

        # n = len(nums)
        # ans = n + 1
        # for i in range(n):
        #     for j in range(i, n):
        #         if sum(nums[i:j + 1]) >= target:
        #             ans = min(ans, j - i + 1)
        # return ans if ans < n + 1 else 0
        # time limit exceeded

        # n = len(nums)
        # ans = n + 1
        # for i in range(n):
        #     for j in range(i, n):
        #         if sum_helper(tuple(nums[i:j + 1])) >= target:
        #             ans = min(ans, j - i + 1)
        #         if (j - i + 1) >= ans:
        #             break
        # return ans if ans < n + 1 else 0
        # time limit exceeded
        
        n = len(nums)
        ans = n + 1
        s = 0
        left = 0
        for right, x in enumerate(nums): #x: nums[right]
            s += x
            # 不需要判断left <= right因为如果相等的时候s-nums[left] =0一定小于正整数的target
            # 第一种写法
            # while s - nums[left] >= target:
            #     s -= nums[left]
            #     left += 1
            # if s >= target:
            #     ans = min(ans, right - left + 1)
            # 第二种写法
            # while满足单调性
            # left移动的时候窗口内不断变小，所以只会从满足要求变得不满足要求，单调性
            # 只有满足单调性才能使用双指针
            # 也可以从不满足条件变得满足条件，也是单调性
            while s >= target:
                ans = min(ans, right - left + 1)
                s -= nums[left]
                left += 1
                # left 最多加到n就结束了
        return ans if ans <= n else 0
        # 时间复杂度O(n)，空间复杂度O(1)
        


            
        
# @lc code=end


#
# @lc app=leetcode id=15 lang=python3
#
# [15] 3Sum
#
from typing import *

# @lc code=start
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        # print(f"nums is {nums}")
        # 三元数组顺序不重要，i<j<k即可
        # 时间复杂度O(n^2) ->每一个数都要进行n的操作
        # 空间复杂度O(1)
        ans = []
        for i in range(len(nums) - 2):
            if (i > 0 and nums[i] == nums[i-1]):
                continue
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0):
                break # 因为如果加最前面的都大于0那肯定不用再试了，i之后的数字也不用再试了
            if (nums[i] + nums[-1] + nums[-2] < 0):
                continue # nums[i]肯定是凑不到0了，看下一个数了
            two_sum = self.twoSum(nums[i+1:], -nums[i])
            if two_sum:
                ans.extend([nums[i]] + j for j in two_sum)
        return ans

    def twoSum(self, nums: List[int], target: int) -> List[List[int]]:
        l, r = 0, len(nums) - 1
        ans = []
        while l < r:
            if (nums[l] + nums[r] > target):
                r -= 1
            elif (nums[l] + nums[r] < target):
                l += 1
            else:
                ans.append([nums[l], nums[r]])
                l += 1
                # r -= 1
                # 不对，因为可能有多个重复的，所以l和r要到完全不一样为止
                while l < r and nums[l] == nums[l - 1]:
                    l += 1
                r -= 1
                while l < r and nums[r] == nums[r + 1]:
                    r -= 1 
        return ans

        
# @lc code=end


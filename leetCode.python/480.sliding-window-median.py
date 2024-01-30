#
# @lc app=leetcode id=480 lang=python3
#
# [480] Sliding Window Median
#

# @lc code=start
from typing import List
from sortedcontainers import SortedList
class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        sorted_list = SortedList(nums[0:k])
        res = [((sorted_list)[(k - 1) // 2] + sorted_list[(k) // 2]) / 2]
        for i in range(k, len(nums)):
            sorted_list.add(nums[i])
            sorted_list.remove(nums[i - k])
            res.append(((sorted_list)[(k - 1) // 2] + sorted_list[(k) // 2]) / 2)
        
        return res


# 维护一个滑动窗口的sorted list，每一次add和remove，然后维护数据即可
        
# @lc code=end


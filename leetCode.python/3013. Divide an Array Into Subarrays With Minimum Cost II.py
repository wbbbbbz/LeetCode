"""
确定了第二个数的位置，，，，第k个数的位置，那么分割方案就确定了

nums[0] + (n-1 选k-1个数，且这k-1个数的第一个数和最后一个数的下标之差不超过dist)
-> 类似于滑动窗口

滑动窗口
维护大小为dist+1的滑动窗口中的k-1个最小的数的和
其实就类似于下面，就是把整个dist+1分成L和R，L是k-1个最小的数

经典案例：滑动窗口中位数,480 -> 维护两个对顶堆
删除元素：multiset，或者懒删除堆。就是给元素加上删除tag，pop的时候如果有删除tag，那么就再pop一次
https://leetcode.cn/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/solutions/2614067/liang-ge-you-xu-ji-he-wei-hu-qian-k-1-xi-zdzx/
"""

from sortedcontainers import SortedList
from typing import List

class Solution:
    def minimumCost(self, nums: List[int], k: int, dist: int) -> int:
        k -= 1 # 第一个已经分段了
        sorted_list = SortedList(nums[1:dist+2])
        res = s = sum(sorted_list[:k])

        for i in range(dist+2, len(nums)):
            # 如果比前K个小的话要更新sum
            if nums[i] < sorted_list[k - 1]:
                s += nums[i] - sorted_list[k - 1]
            sorted_list.add(nums[i])
            sorted_list.remove(nums[i - dist - 1]) # 滑动窗口最左端去掉
            # 如果移除的数也在前K个里面的话
            if nums[i - dist - 1] < sorted_list[k - 1]:
                s += sorted_list[k - 1] - nums[i - dist - 1]
            res = min(res, s)
        
        
        return res
        
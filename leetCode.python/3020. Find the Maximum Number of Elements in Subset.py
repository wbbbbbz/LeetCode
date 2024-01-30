"""
如果数据的增长是指数级别，或者是超指数级别 -> 暴力枚举x就行，因为数据范围很小，增长太快了

"""

from sortedcontainers import SortedDict
from typing import List
from collections import Counter
class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        counter = SortedDict(Counter(nums))
        ans = 1
        while counter:
            k, v = counter.popitem(0)
            if k == 1:
                ans = max(ans, (v - 1) + (v % 2))
                # 或者可以写v - (v % 2 ^ 1) -> 偶数的时候多减去1
            else:
                if v >= 2:
                    temp = 2
                    while True:
                        print(f"k is {k}, v is {v}")
                        k *= k
                        v = counter.pop(k, None)
                        if not v:
                            ans = max(ans, temp - 1)
                            break
                        if v == 1:
                            ans = max(ans, temp + 1)
                            break
                        temp += 2
        return ans
    
# 排好序的counter一个一个进行计算，费时间
# class Solution:
#     def maximumLength(self, nums: List[int]) -> int:
#         ans = nums.count(1)
#         if ans == 1:
#             ans = 0
#         nums = set(nums)
#         if 1 in nums:
#             nums.remove(1)
#         @cache
#         def go(x):
#             if x**2 in nums:
#                 return go(x**2) + 1
#             else:
#                 return 1
        
#         for x in nums:
#             if go(x) > 1:
#                 ans = max(ans, go(x))
#         return ans
    
# 因为指数增长太快了，所以实际上不如直接算，基本只要走4次翻倍就到最大了
# x^2^p <= 数组最大值m
# 2^p <= logxm
# p <= log2logxm
# 时间法则是O(nlog2logxm)
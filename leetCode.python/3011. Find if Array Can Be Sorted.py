"""
套路题：分组循环
只要涉及到一段一段的。

用最不容易写错的方法写分段
"""


from typing import List
from itertools import pairwise

class Solution:
    # def canSortArray(self, nums: List[int]) -> bool:
    #     print([format(i, 'b') for i in nums])
    #     i, j, l = 0, 0, len(nums)
    #     if l == 1:
    #         return True
        
        
    #     last_max_num, max_num = 0, 0
    #     while i < l:
    #         while (j < l and nums[j].bit_count() == nums[i].bit_count()):
    #             if (nums[j] < last_max_num):
    #                 return False
    #             max_num = nums[j] if nums[j] > max_num else max_num
    #             j += 1

    #         last_max_num = max_num
    #         max_num = 0

    #         i = j
    #         # print(f"i is {i}, j is {j}, last_max_num is {last_max_num}, max_num is {max_num}")
    #     return True

    def canSortArray(self, nums: List[int]) -> bool:
        #首先要分外层循环和内存循环
        n = len(nums)
        i = 0
        while i < n:
            # 外层循环负责两件事情
            # 1.外层循环每次循环的时候把当前子数组的下标记录一下,记录开始位置（因为要排序）
            # 2.循环结束后对子数组进行排序或者统计

            start = i
            ones = nums[i].bit_count()
            i += 1 # 自己没必要比

            while i < n and nums[i].bit_count() == ones:
                i += 1
                # 内层循环就负责找到在哪结束就行
                # 判断和题目要求的判断一致就行
                # 循环结束后，从start到i-1是一个子数组
            nums[start:i] = sorted(nums[start:i])
        return all(x <= y for x, y in pairwise(nums)) #判断是不是每两个数都是x<=y成立的
    # 因为i一直在增大，所以就是O(n)，排序就是O(nlogn)

solution = Solution()
nums = [3,16,8,4,2]
print(solution.canSortArray(nums))


# 边界条件太难考虑了。
# 找出恒定量，各个变量代表什么
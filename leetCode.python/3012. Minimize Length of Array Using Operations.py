"""
如果取模不是0，那就可以继续操作这个数字
2,3,4,5,6
相当于每次操作，删除一个大于2的数
如果最小的数只有一个，那么最后只剩一个数（最优解）

如果最小的数不止一个，能不能得到一个小于m=min(nums)的数
设x不是m的倍数，那么0<x%m<m
如果nums的所有数字都是m的倍数 ->这个时候一定得不到比m小的数


最优做法
把大于m的数字都去掉，然后剩下的cnt个m两两一对
ceil(cnt/2) -> (cnt+1)//2

"""

from typing import List
from collections import Counter

class Solution:
    def minimumArrayLength(self, nums: List[int]) -> int:
        # counter = Counter(nums)
        # items = sorted(counter.items())
        # l = len(items)
        # print(f"items is {items}")
        # if items[0][0] == 1:
        #     return (items[0][1] + 1) // 2
        # if items[0][1] <= 2:
        #     return 1
        # for i in range(0, l):
        #     for j in range(1, l):
        #         if 0 < items[j][0] % items[i][0] < items[0][0]:
        #             return 1

        # return (items[0][1] + 1) // 2

        # 考虑复杂了，不需要两两求余，直接拿最小的数跟其他所有的数求余就行。因为只要所有数不是都是最小数的倍数就行（也就是不用所有数余数为0就行，同余定理）
        # 1的话肯定能整除所有，所以只用考虑1的个数就行
        if 1 in nums:
            return (nums.count(1) + 1) // 2 # 不需要，因为1也不用考虑，可以直接跟下面合并
        k = min(nums)
        for i in nums:
            if i % k != 0:
                return 1
            
        return (nums.count(k) + 1) // 2


        
        

solution = Solution()
nums = [1,4,3,1,1,1,1,1,1,1,1,1,1,1,1]
# nums = [5,5,5,5,10]
print(solution.minimumArrayLength(nums))
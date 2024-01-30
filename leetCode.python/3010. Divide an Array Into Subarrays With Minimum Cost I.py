class Solution:
    def minimumCost(self, nums: List[int]) -> int:
        # l = len(nums)
        # ans = nums[0] + nums[1] + nums[2]
        # for i in range(1, l - 1):
        #     for j in range(i + 1, l):
        #         s = nums[0] + nums[i] + nums[j]
        #         ans = s if s < ans else ans

        return sum(sorted(nums[1:])[0:2]) + nums[0]
    
        # if (nums[1] <= nums[2]):
        #     m, n = nums[1], nums[2]
        # else:
        #     m, n = nums[2], nums[1]
        # for i in range(3, len(nums)):
        #     if nums[i] < m:
        #         m, n = nums[i], m
        #     elif nums[i] < n:
        #         n = nums[i]
                
        # return nums[0] + m + n
     #应该更快，但是数据量太少没有意义
    

# class Solution:
#     def minimumCost(self, nums: List[int]) -> int:
#         return nums[0] + sum(heapq.nsmallest(2, nums[1:]))
    
# 可以用heapq里的nsmallest和nlargest来取n个最大值最小值


# 还真是排序就行。因为第一个一定要取，剩下的不管次小和最小在哪里都可以取到
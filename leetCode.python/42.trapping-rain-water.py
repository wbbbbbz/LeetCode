#
# @lc app=leetcode id=42 lang=python3
#
# [42] Trapping Rain Water
#

# @lc code=start
from typing import List
class Solution:
    def trap(self, height: List[int]) -> int:
        # 假设每一个位置上都有一个桶，桶左边长度是pre_max，右边是suf_max。水一定不可能超过pre_max和suf_max的较小值，否则水就一定会漏出去
        # 然后减去当前部分的高度就行
        # n = len(height)
        # pre_max = [0] * n
        # pre_max[0] = height[0]
        # for i in range(1, n):
        #     pre_max[i] = max(pre_max[i - 1], height[i])
        
        # suf_max = [0] * n
        # suf_max[-1] = height[-1]
        # for i in range(n - 2, -1, -1):
        #     suf_max[i] = max(suf_max[i + 1], height[i])

        # ans = 0
        # for i in range(n):
        #     ans += max(0, min(suf_max[i], pre_max[i]) - height[i])
        # # for h, pre, suf in zip(height, pre_max, suf_max)
        # return ans
    
    # 时间和空间都是O(n)，时间已经是最优的
    # 空间还可以再优化，如果左边已经比右边小，那么不过右边有没有可能更高，都不用再管了，因为一定是根据左边来的，反之同理，所以通过两个指针就行

        # n = len(height)
        # l, r = 0, n - 1
        # ans = 0
        # pre_max, suf_max = height[0], height[-1]
        # while l < r:
        #     if pre_max <= suf_max:
        #         ans += pre_max - height[l]
        #         l += 1
        #         pre_max = max(pre_max, height[l]) -> 有点危险，还是先pre_max可能比较好，就怕index溢出
        #     else:
        #         ans += suf_max - height[r]
        #         r -= 1
        #         suf_max = max(suf_max, height[r])

        # return ans
        # 不对，因为就算l=r也可以算，相等位置的水 -> 还是不对，因为最后一定会停在最高的地方，否则之前一定算过了

        
# @lc code=end


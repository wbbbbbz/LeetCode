#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        # f(n) = f(n-1) + f(n-2)
        last1 = 1
        last0 = 1
        for i in range(1, n):
            last0, last1 = last1, last0 + last1
        return last1
        
# @lc code=end


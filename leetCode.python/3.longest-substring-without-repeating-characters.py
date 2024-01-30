#
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        n = len(s)
        l = 0
        ans = 1
        sub = {}
        for r in range(n):
            if s[r] in sub:
                l = max(l, sub.pop(s[r]) + 1)
            
            sub[s[r]] = r
            # print(f"sub is {sub}, l is {l}")
            # 这个字典维护每一个字符最后出现的index
            ans = max(ans, r - l + 1)
                 
        return ans
        

# 或者通过counter
        # ans = 0
        # cnt = Counter()
        # l = 0
        # for r, c in enumerate(s):
        #     cnt[c] += 1
        #     while cnt[c] > 1:
        #         cnt[s[l]] -= 1
        #         l += 1
        #     ans = max(ans, r - l + 1)
        # return 
    # 时间复杂度O(n)
    # 空间复杂度O(128)
# @lc code=end


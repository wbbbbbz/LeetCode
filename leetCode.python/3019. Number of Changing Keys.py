from itertools import pairwise

class Solution:
    def countKeyChanges(self, s: str) -> int:
        # ans = 0
        # for i in range(1, len(s)):
        #     if s[i].lower() != s[i-1].lower():
        #         ans += 1
        # return ans

        s = s.lower()
        ans = 0
        for x, y in pairwise(s):
            if x != y:
                ans += 1
        return ans
    
    # return sum(x != y for x, y in pairwise(s.lower()))

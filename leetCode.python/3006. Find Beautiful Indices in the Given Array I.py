# class Solution:
#     def beautifulIndices(self, s: str, a: str, b: str, k: int) -> List[int]:
#         ans = []
#         for i in range(len(s) - len(a) + 1):
#             if (s[i:(i+len(a))] == a):
#                 for j in range(len(s) - len(b) + 1):
#                     if (s[j:(j+len(b))] == b and abs(j - i) <= k):
#                         ans.append(i)
#                         break
#         return ans
                        
#         # 超时

class Solution:
    def beautifulIndices(self, s: str, a: str, b: str, k: int) -> List[int]:
        ans = []
        for i in range(len(s) - len(a) + 1):
            if (s[i:(i+len(a))] == a):
                for j in range(max(0, i - k), min(i + k, len(s) - len(b)) + 1):
                    if (s[j:(j+len(b))] == b):
                        ans.append(i)
                        break
        return ans
                        
        
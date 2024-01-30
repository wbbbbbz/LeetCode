from collections import Counter

class Solution:
    def minimumPushes(self, word: str) -> int:
        # counter = Counter(word)
        # ans = 0
        # keys = 8
        # times = 1
        # for (c, i) in counter.most_common():
        #     if keys == 0:
        #         keys = 8
        #         times += 1
        #     ans += times * i
        #     keys -= 1
        # return ans

        # O(n + 26log26)
        cnt = Counter(word)
        a = sorted(cnt.values(), reverse=True)
        ans = 0
        for i, c in enumerate(a):
            ans += c * (i // 8 + 1)
        return ans



solution = Solution()
word = "xycdefghij"
print(solution.minimumPushes(word))
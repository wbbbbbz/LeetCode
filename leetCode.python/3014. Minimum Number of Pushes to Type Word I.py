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

        # l = len(word)
        # if l <= 8:
        #     return l
        # if l <= 16:
        #     return 8 + (l - 8) * 2
        # if l <= 24:
        #     return 24 + (l - 16) * 3
        # return 48 + (l - 24) * 4    

        # n = len(word)
        # k = n // 8
        # return 4 * k * (k + 1) + n % 8 * (k + 1)
        k, n = divmod(len(word), 8)
        return 4 * k * (k + 1) + n * (k + 1)
        # 数学公式，一下求解。等差数列加上剩下部分

        # return int(oct(len(word))[2:]) -> 一部分，比如8，9就是不对的


solution = Solution()
word = "xycdefghij"
print(solution.minimumPushes(word))
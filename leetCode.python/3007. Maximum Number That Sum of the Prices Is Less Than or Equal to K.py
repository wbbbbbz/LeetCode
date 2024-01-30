"""
1. 二分+数位DP
给定num，统计1-num的价值和，判断价值和是否<=k
二分相当于多花费log的时间，额外增加一个条件
当k=1的时候就是leetcode 233题 -> 拿来做基本，然后改装就行
2. 二分+枚举数位
判断二分：是不是有单调性。nums越大，count就越大。所以可以理解成在一个有序数组中找一个<=k的数字

在正整数里面搜索本身就是二分法，但是问题就是需要找出和一个方法计算从0到某个特定正整数的特定位数的总共的1的次数
第一个方法就是通过DP，记忆所有搜索的结果（也就是记忆到某个数字，某个位数加起来的总和）
第二个方法就是直接通过数学公式计算。个位就是看奇偶，其他位数的话每2^x其实就是一个循环，比如第二位就是0011，第三位就是00001111
那么首先找出多少循环(n//2^x * 2^(x-1))，然后剩余的mod的话其实等价于怎么表示0012，或者00001234 ->  - 2**(i-1) + 1 (有一定的对称性 -1,0,1,2 或者-3,-2,-1,0,1,2,3,4)

"""
from functools import cache
from bisect import bisect_left, bisect_right

# class Solution:
#     def findMaximumNumber(self, k: int, x: int) -> int:
#         s = 0
#         base = 1 << (x - 1)
#         helper = 0
#         for i in range(50):
#             helper += base
#             base <<= x
#         # print(bin(helper))

#         times = 1
#         l = k
#         while True:
#             temp_l = k // (2 ** (times * (x - 1)))
#             times += 1
#             print(f"temp_l is {temp_l}, times is {times}")
#             if (2 ** x) * temp_l < l:
#                 l = temp_l
#             else:
#                 break
#         print(l)

#         s = 
#         while True:
#             s += (i & helper).bit_count()
#             # print(f"i: {i}, s: {s}")
#             if (s > k):
#                 return i - 1
#             i += 1

# solution = Solution()
# k=3278539330613
# x=5
# print(solution.findMaximumNumber(k, x))
# # 大数的时候超时 k=3278539330613 x=5

# class Solution:
#     def countDigitOne(self, n: int, x:int) -> int:
#         # 这个比较慢，第一要转2进制
#         s = bin(n)[2:]
#         # m = len(s)
#         # 所以复杂度是O(m^2)
#         @cache
#         def f(i: int, cnt1: int, is_limit: bool) -> int:
#             if i == len(s):
#                 return cnt1
#             res = 0
#             up = int(s[i]) if is_limit else 1
#             for d in range(up + 1):
#                 res += f(i + 1, cnt1 + (d == 1 and (len(s) - i) % x == 0), is_limit and d == up)
#             return res
#         return f(0, 0, True)
    
#     # def countDigitOne2(self, n: int, x:int) -> int:
#     #     base = 1 << (x - 1)
#     #     helper = 0
#     #     for i in range(50):
#     #         helper += base
#     #         base <<= x
#     #     # print(bin(helper))
#     #     s = 0
#     #     for i in range(n+1):
#     #         s += (i & helper).bit_count()
#     #         # print(f"i: {i}, s: {s}")
#     #     return s
    
#     def findMaximumNumber(self, k: int, x: int) -> int:
#         left = 0 # 要保证每时每刻self.countDigitOne(left) <= k
#         # right = 10 ** 18 # magic nunmber
#         right = (k + 1) << x # 要保证每时每刻self.countDigitOne(right) > k
#         # 不用magic number，那就要估计上界在哪
#         # 如果x等于1，那么根据奇偶(010101)那就应该是2k
#         # 如果x等于2，可以假设所有数字都除以2，那么就变成x=1的情况，所以是4k
#         # 所以应该是k * 2^x次方
#         # 然后还可以松一点，(k+1)<<x
#         while left + 1 < right:
#             mid = (left + right) // 2
#             temp = self.countDigitOne(mid, x)
#             print(f"temp is {temp}, mid is {mid}, left is {left}, right is {right}")
#             if temp <= k:
#                 left = mid
#             else:
#                 right = mid
#         return left #返回什么看if更新的是什么，开区间二分写法
#     # m约等于log2n,n等于k*2^x(估算的上限)，所以整体复杂度是(x*log2k)^2 * log2k (二分的复杂度)


# solution = Solution()
# k=3278539330613
# x=5
# print(solution.findMaximumNumber(k, x))
        
# https://www.bilibili.com/video/BV1zt4y1R7Tc/?spm_id_from=333.999.0.0&vd_source=c5259b8dc5c162e1eab0979875357e22


# # for k in range(100):
# #     print(f"bit sum until {k}")    
# #     print(sum([i.bit_count() for i in range(k+1)]))

class Solution:

    def countDigitOnes(self, n:int, x:int) -> int:
        # n:到n为止
        # x:第x位数字
        ans = 0
        max_length = n.bit_length()
        i = 0
        while i <= max_length:
            i += x
            # ans += (n // (2**i)) * (2**(i-1)) + max(0, n % (2**i) - 2**(i-1) + 1)
            ans += ((n >> i) << (i - 1)) + max(0, n % (2**i) - 2**(i-1) + 1)
            # print(f"ans is {ans}, i is {i}")
        return ans
    
    
    def findMaximumNumber(self, k: int, x: int) -> int:
        # return bisect_right(range(((k + 1) << x) + 1), k, key=lambda t: self.countDigitOnes(t, x)) - 1
        # 逐个位数进行构建。这个方法本质上和直接通过公式求总共的1的个数是一样的，都是log(k*2^x)，这个是直接通过从高位开始构建1来计算
        # 最大的可能数根据上面的解释，一定小于(k+1)<<x。直接用这个的位数即可
        # 计算的就是想着到这个第i位能不能放上一个1，所以要计算如果放上1，那么带来多少个可数的1
        # 对于这个0之前的位，就看有多少个x的倍数位是取了1的，这个数据在pre1里
        # 对于这个0之后的位，就是从000000到100000里面对应位数的1的个数。首先通过i//x找出有多少个可数的位，然后对应每个位都有一半是1，所以个数是2^(i-1) / 2 -> 如果用2^(i-2)会出现i-2=-1的问题
        # 由于这个是不包括自己这一位的，所以算出来的n应该会大一个，所以要减一
        pre1 = 0
        n = 0
        for i in range(((k + 1) << x).bit_length(), 0, -1):
            cnt = (pre1 << (i - 1)) + (((i - 1) // x) << (i - 1) >> 1)
            if cnt <= k:
                n += 1 << (i - 1)
                k -= cnt
                pre1 += (i % x) == 0
            print(f"cnt is {cnt}, n is {n}, k is {k}, pre1 is {pre1}, i is {i}")

        return n - 1
    

    

solution = Solution()
k=3278539330613
x=5
print(solution.findMaximumNumber(k, x))
# print(solution.findMaximumNumber(319, 1))
# print(solution.countDigitOnes(63, 1))
# 大数的时候超时 k=3278539330613 x=5 ans=851568447023


# by chatGPT

# https://leetcode.cn/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k/solutions/2603673/er-fen-da-an-shu-wei-dpwei-yun-suan-pyth-tkir/

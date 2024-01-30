class Solution:
    def minMovesToCaptureTheQueen(self, a: int, b: int, c: int, d: int, e: int, f: int) -> int:
        # either 1 step or 2 step, so just need to judge whether we can catch at first place:
        # judge the rook, same line, and there is no bishop in line
        if (a == e):
            if (c == e and (b < d < f or f < d < b)):
                return 2
            return 1
        if (b == f):
            if (b == d and (a < c < e or e < c < a)):
                return 2
            return 1
        # judge the bishop, and rook not in the line
        if (c + d == e + f):
            if (a + b == c + d and (c < a < e or e < a < c)):
                return 2
            return 1
        if (c - d == e - f):
            if (a - b == c - d and (c < a < e or e < a < c)):
                return 2
            return 1
        return 2
        


# class Solution:
#     def minMovesToCaptureTheQueen(self, a: int, b: int, c: int, d: int, e: int, f: int) -> int:
#         rook, bishop, queen  = [a, b], [c, d], [e, f]
        
#         if a == e: # same row
#             if a == c and (d - b) * (d - f) < 0: # bishop on the same row and between rock and queen
#                 return 2
#             else:
#                 return 1
#         elif b == f: # same col
#             if b == d and (c - a) * (c - e) < 0:
#                 return 2
#             else:
#                 return 1
#         # bishop and queen in the same diagonal
#         elif c - e == d - f: # \ diagonal
#             if a - e == b - f and (a - c) * (a - e) < 0:
#                 return 2
#             else:
#                 return 1
#         elif c - e == f - d: # / diagonal
#             if a - e == f - b and (a - c) * (a - e) < 0:
#                 return 2
#             else:
#                 return 1
#         return 2

# 【分类讨论 二分+DP【力扣周赛 379】】 https://www.bilibili.com/video/BV1ae411e7fn/?share_source=copy_web&vd_source=8a18b54c7d062c46676bbbead62e765b

# def ok(l: int, m: int, r: int) -> bool:
#             return not min(l, r) < m < max(l, r)

#         if a == e and (c != e or ok(b, d, f)) or \
#            b == f and (d != f or ok(a, c, e)) or \
#            c + d == e + f and (a + b != e + f or ok(c, a, e)) or \
#            c - d == e - f and (a - b != e - f or ok(c, a, e)):
#             return 1
#         return 2

# 作者：灵茶山艾府
# 链接：https://leetcode.cn/problems/minimum-moves-to-capture-the-queen/solutions/2594432/fen-lei-tao-lun-jian-ji-xie-fa-pythonjav-aoa8/
# 来源：力扣（LeetCode）
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
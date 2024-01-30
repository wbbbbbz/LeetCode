from typing import List

class Solution:
    def beautifulIndices(self, s: str, a: str, b: str, k: int) -> List[int]:
        ans = []
        pos_a = self.kmp(s, a)
        pos_b = self.kmp(s, b)
        i, j = 0, 0
        while i < len(pos_a) and j < len(pos_b):
            if (pos_a[i] > pos_b[j] + k):
                j += 1
            else:
                if (pos_a[i] >= pos_b[j] - k):
                    ans.append(pos_a[i])
                i += 1
        # 上面的双指针虽然成功了但是有bug，因为必须列出所有的i，所以while里面不能判断j，有可能最后一个j对应多个i -> 好像也不对，因为j+1的操作只出现在i太大的情况，这种时候的确应该停止循环了

                
        return ans
    
    def kmp(self, text: str, pattern: str) -> List[int]:
        # 0开头，pi数组是到目前为止字符串的最长公共字符串
        m = len(pattern)
        pi = [0] * m
        c = 0
        for i in range(1, m):
            # i是最新要比较的位置，c是比较的位置,也是要跳跃的位置
            # pi[i]的取值，如果pattern[i] = pattern[c]则长度是pi[i] + 1
            # 否则就判断pattern[i] = pattern[pi[c]]则长度是pi[pi[c]] + 1，循环至比较到0位置为止
            v = pattern[i]
            while c and pattern[c] != v:
                c = pi[c - 1]
            if (pattern[c] == v):
                # 更新c，c永远都是要比较，或者要跳越的那个index
                c += 1
            # 每一个i更新要跳越的index
            pi[i] = c


        # 进行字符串搜索的时候，其实本质和构建next数组类似，就是找出跳跃的index
        # 或者可以说next数组在比较的时候就是text = pattern的比较
        res = []
        c = 0
        for i, v in enumerate(text):
            v = text[i]
            while c and pattern[c] != v:
                c = pi[c - 1]
            if pattern[c] == v:
                c += 1
            if c == m:
                # 搜索完成，匹配
                # 结果中加上对应的index
                res.append(i - m + 1)
                # 也是比较完成，跳回pi[c-1]
                c = pi[c - 1]
        return res


# https://leetcode.cn/problems/find-beautiful-indices-in-the-given-array-ii/solutions/2603695/kmper-fen-cha-zhao-by-endlesscheng-7bjm/

    

s = "isawsquirrelnearmysquirrelhouseohmy"
a = "my"
b = "squirrel"
k = 15
solution = Solution()
print(solution.beautifulIndices(s, a, b, k))
class Solution:
    def maxPartitionsAfterOperations(self, s: str, k: int) -> int:
        def maxPartitions(s: str, k: int) -> int:
            c = set(s[0])
            parts = 1
            for i in range(1, len(s)):
                c.add(s[i])
                # print(f"c: {c}")
                if len(c) > k:
                    parts += 1
                    c = set(s[i])
            return parts
                
                
        if len(s) == 1:
            return 1
        
        if k == 26:
            return len(s)
        
        max_partitions = 0
        for c in range(ord('a'), ord('z') + 1):
            for i in range(len(s)):
                if (chr(c) != s[i]):
                    new_s = s[:i] + chr(c) + s[i + 1:]
                    max_partitions = max(max_partitions, maxPartitions(new_s, k))
        return max_partitions
    
# 暴力破解，26n算法，但是超时。就是把每一种可能的字符串的最大partitions给算出来.
class Solution:
    def maximumSetSize(self, nums1: List[int], nums2: List[int]) -> int:
        
        set1 = set(nums1)
        set2 = set(nums2)
        l1 = len(set1)
        l2 = len(set2)
        n = len(nums1) // 2
        # ans就是最大的答案，如果一个都不删的话(n==0的话)
        ans = len(set1 | set2)
        # 那就先删common的，而且删除common的时候不用担心是nums1还是nums2的，因为大家都是共通的
        common_l = len(set1 & set2)
        
        # 先删的一定是自然重复的，也就是从num1直接变成set1
        # 首先如果set1或者set2都比n(也就是一半)的长度还要小的话，那根本没有讨论的必要，直接删成set1就行，因为重复的也要删
        # 所以只有当set1长度大于n的时候，删到set1之后还要考虑删谁，这个时候就删两个set中common的东西就行
        if (l1 > n):
            if (common_l < (l1 - n)):
                ans -= (l1 - n - common_l)
            common_l = max(common_l - (l1 - n), 0)    
        # print(f"ans after l1:{ans}")
        # print(f"common_l after l1:{common_l}")
        if (l2 > n):
            if (common_l < (l2 - n)):
                ans -= (l2 - n - common_l)
                
        return ans
    
# class Solution:
#     def maximumSetSize(self, nums1: List[int], nums2: List[int]) -> int:
        
#         n, nums1, nums2 = len(nums1) // 2, set(nums1), set(nums2)

#         len_both = len(nums1 & nums2)

#         v1 = min(len(nums1) - len_both, n)
#         v2 = min(len(nums2) - len_both, n)

#         return min(v1 + v2 + len_both, n * 2)

# https://leetcode.com/problems/maximum-size-of-a-set-after-removals/solutions/4520990/c-java-python-set-difference/
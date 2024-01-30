class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        # 1. 遍历3次，counter一次，找出最大值一次，再找所有最大值一次
        # counter = collections.Counter(nums)
        # return sum([x[1] for x in counter.most_common() if x[1] == counter.most_common(1)[0][1]])
        
        # 2. 遍历2次，直接统计最大count
        # max_cnt = ans = 0
        # for c in counter.values():
        #     if c > max_cnt:
        #         max_cnt = ans = c
        #     elif c == max_cnt:
        #         ans += c
        # return ans

        # 一次遍历
        counter = collections.Counter()
        max_cnt = ans = 0
        for x in nums:
            counter[x] += 1
            c = counter[x]
            if c > max_cnt:
                max_cnt = ans = c
            elif c == max_cnt:
                ans += c
        return ans
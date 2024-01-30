class Solution:
    def areaOfMaxDiagonal(self, dimensions: List[List[int]]) -> int:
        # diagonal_length = 0
        # max_area = 0
        # for rectangle in dimensions:
        #     temp_diag_len = rectangle[0] ** 2 + rectangle[1] ** 2
        #     if (temp_diag_len > diagonal_length):
        #         diagonal_length = temp_diag_len
        #         max_area = rectangle[0] * rectangle[1]
        #     elif (temp_diag_len == diagonal_length): 
        #         max_area = max(rectangle[0] * rectangle[1], max_area)
                
        # return max_area
        
        return max((x * x + y * y, x * y) for x, y in dimensions)[1]
    
    # 【分类讨论 二分+DP【力扣周赛 379】】 https://www.bilibili.com/video/BV1ae411e7fn/?share_source=copy_web&vd_source=8a18b54c7d062c46676bbbead62e765b
class Solution:
    def flowerGame(self, n: int, m: int) -> int:
        return (n // 2 + n % 2) * (m // 2) + (m // 2 + m % 2) * (n // 2)
    
# 数学问题，只要找出[1,n]和[1,m]之间多少个和是奇数就行。
# 其实就是nm//2，只要讨论n*m的奇偶以判断就行。用棋盘考虑就行
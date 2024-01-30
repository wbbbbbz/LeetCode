'''
暴力做法：BFS。最短距离
每个点花费O(n)求出它到其余点的距离
花费O(n^2)的时间求出任意两点的距离（二维矩阵，一加完事）

如果没有x和y，距离 = 两个编号之差
i到j的距离=abs(i-j)
假设到i点，与之前所有点的距离是1,2,3....i-1，那么到i+1就是全部+1
使用差分数组，把一堆连续的数字都加一。1094题差分数组 https://leetcode.cn/problems/car-pooling/solutions/2550264/suan-fa-xiao-ke-tang-chai-fen-shu-zu-fu-9d4ra/

i到左边的房子：[1,i-1] + 1
i到右边的房子：[1,n-i] + 1
用差分数组维护上面就好

有了x,y分类讨论：
1. i<=x
2. x<i<(x+y)/2
3. (x+y)/2<i<y
4. y<=i<=n
但是这么分类太复杂了。考虑对称性，整个图翻过来，1==4, 2==3
所以只要讨论两种情况

如果i在x,y区域外，如何更新距离：
因为有x,y，所以i到一些点的距离会缩短
如果x+1<y(也就是x,y路径实际有影响的话)

i到y后面的点一定变小->做一个撤销操作
1. i<=x
    撤销：[y-i, n-i] - 1  #新距离
    dec = y - x - 1
    新增：[y - i - dec, n - i - dec] + 1
    这些点缩短的距离都是一样的。针对y到i之间，距离缩短了：
    (y-i)#原来的长度
    (x-i+1)#缩短后的长度
    (y-i)-(x-i+1)=y-x-1 -> 其实就是x到y之间缩短的距离

    对小于y的数字:
    列不等式有利于思考
    j-i>x-i+1+y-j
    j>(x+y+1)/2
    [(x+y+1)/2+1, y-1]这一段到i的距离都变小
    j = (x+y+1) / 2 + 1
    从j到y-1，这些点到i的距离都变小了
    撤销：[j-i, y-1-i] - 1
    dec = (j-i) - (x-i+1+y-j) = 2j - (x + 1 + y)
    新增：[j - i - dec, y - 1 - i - dec] + 1

    https://www.bilibili.com/video/BV1Q5411C7mN/?spm_id_from=333.999.0.0&vd_source=c5259b8dc5c162e1eab0979875357e22

2. x<i<(x+y)/2
    

3. (x+y)/2<i<y
4. y<=i<=n


第二种思路：
i到j和j到i各算一次，所以实际上只需要考虑i到右边的点的距离就好，最后答案乘以2
'''



from typing import List

class Solution:
    def countOfPairs(self, n: int, x: int, y: int) -> List[int]:
        # 构建房子之间的连接关系
        connections = {i: set([i + 1, i - 1]) for i in range(1, n + 1)}
        connections[1] = set([2])
        connections[n] = set([n-1])

        if abs(x - y) > 1:
            connections[x].add(y)
            connections[y].add(x)

        ans = [0] * (n + 1)
        
        print(f"connections is {connections}, ans is {ans}")

        # 计算每对房子之间的最短路径，并更新结果数组
        for i in range(1, n + 1):
            visited = set()
            queue = [(i, 0)]
            while queue:
                current, distance = queue.pop(0)
                if current not in visited:
                    visited.add(current)
                    ans[distance] += 1
                    queue.extend([(k, distance + 1) for k in connections[current]])

        return ans[1:]
            

solution = Solution()
n = 5
x = 2
y = 4
print(solution.countOfPairs(n, x, y))

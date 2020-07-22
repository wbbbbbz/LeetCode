import java.util.*;

/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (45.04%)
 * Likes:    2992
 * Dislikes: 186
 * Total Accepted:    312.8K
 * Total Submissions: 663.5K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        if (n <= 0){
            return -1;
        }
        // 使用Queue进行bfs搜索，使用boolean[]进行记录是否访问过
        // 类似于图的解法
        // 其实就是图论的解法。背后的图是从0到n的无权图，结点之间差距完全平方数的话就有一条边
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        int steps = 1;
        while (true){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.pollFirst();
                for (int j = 1; ; j++) {
                    int rest = temp - j * j;
                    if (rest < 0){
                        break;
                    }
                    if (rest == 0){
                        return steps;
                    }
                    if (!visited[rest]){
                        queue.addLast(rest);
                        visited[rest] = true;
                    }
                }
            }
            steps++;
        }
//         588/588 cases passed (7 ms)
// Your runtime beats 95.49 % of java submissions
// Your memory usage beats 26.9 % of java submissions (39.5 MB)
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 *
 * https://leetcode.com/problems/max-area-of-island/description/
 *
 * algorithms
 * Medium (61.03%)
 * Likes:    1707
 * Dislikes: 75
 * Total Accepted:    141.3K
 * Total Submissions: 229.6K
 * Testcase Example:  '[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]'
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Find the maximum area of an island in the given 2D array. (If there is no
 * island, the maximum area is 0.)
 * 
 * Example 1:
 * 
 * 
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,1,1,0,1,0,0,0,0,0,0,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,0,1,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,1,1,0,0],
 * ⁠[0,0,0,0,0,0,0,0,0,0,1,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 
 * Given the above grid, return 6. Note the answer is not 11, because the
 * island must be connected 4-directionally.
 * 
 * Example 2:
 * 
 * 
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * 
 * Note: The length of each dimension in the given grid does not exceed 50.
 * 
 */

// @lc code=start
class Solution {

    private class UF {

        private int[] parent;
        private int[] size; // size[i]表示以i为根的集合中元素个数
        private int maxSize;

        public UF(int size) {
            parent = new int[size];
            this.size = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i; // 这样所有元素组别不一样
                this.size[i] = 1;
            }
            this.maxSize = 1;
        }

        // 返回i所在集合的元素个数
        public int getSize(int i) {
            return size[find(i)];
        }

        // 返回并查集中最大集合的size
        public int getMaxSize() {
            return maxSize;
        }

        // 查找元素p所对应的集合编号
        private int find(int p) {
            if (p < 0 && p >= parent.length)
                throw new IllegalArgumentException("p is out of bound.");

            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        // p和q所属的集合进行并集处理
        public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot == qRoot)
                return;

            // 根据树的元素大小进行判断
            if (size[pRoot] < size[qRoot]) {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
                maxSize = Math.max(size[qRoot], maxSize);
            } else {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
                maxSize = Math.max(size[pRoot], maxSize);
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null)
            return 0;
        int R = grid.length;
        if (R == 0)
            return 0;
        int C = grid[0].length;
        if (C == 0)
            return 0;

        boolean hasIsland = false;

        int points = R * C;
        UF uf = new UF(points);
        for (int i = 0; i < points; i++) {
            int x = i / C;
            int y = i % C;
            if (grid[x][y] == 1) {
                hasIsland = true;
                if (y + 1 < C && grid[x][y + 1] == 1)
                    uf.unionElements(i, i + 1);
                if (x + 1 < R && grid[x + 1][y] == 1)
                    uf.unionElements(i, i + C);
            }
        }

        return hasIsland ? uf.getMaxSize() : 0;

        // 726/726 cases passed (3 ms)
        // Your runtime beats 49.07 % of java submissions
        // Your memory usage beats 96.3 % of java submissions (40 MB)

    }

}
// @lc code=end

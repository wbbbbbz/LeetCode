import java.util.LinkedList;

/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 *
 * https://leetcode.com/problems/is-graph-bipartite/description/
 *
 * algorithms
 * Medium (46.22%)
 * Likes:    1257
 * Dislikes: 146
 * Total Accepted:    99.2K
 * Total Submissions: 213.3K
 * Testcase Example:  '[[1,3],[0,2],[1,3],[0,2]]'
 *
 * Given an undirected graph, return true if and only if it is bipartite.
 * 
 * Recall that a graph is bipartite if we can split it's set of nodes into two
 * independent subsets A and B such that every edge in the graph has one node
 * in A and another node in B.
 * 
 * The graph is given in the following form: graph[i] is a list of indexes j
 * for which the edge between nodes i and j exists.  Each node is an integer
 * between 0 and graph.length - 1.  There are no self edges or parallel edges:
 * graph[i] does not contain i, and it doesn't contain any element twice.
 * 
 * 
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation: 
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * 
 * 
 * 
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation: 
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent
 * subsets.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * graph will have length in range [1, 100].
 * graph[i] will contain integers in range [0, graph.length - 1].
 * graph[i] will not contain i or duplicate values.
 * The graph is undirected: if any element j is in graph[i], then i will be in
 * graph[j].
 * 
 * 
 */

// @lc code=start
class Solution {
    // 返回该图是否二分图
    // 可使用广度优先遍历或者深度优先遍历
    private int[][] graph;
    private int vertexes;
    private int[] colors;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        this.vertexes = graph.length;
        colors = new int[vertexes];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = -1;
        }

        for (int s = 0; s < vertexes; s++) {
            // if (colors[s] == -1) {
            // colors[s] = 0;
            // LinkedList<Integer> queue = new LinkedList<>();
            // queue.push(s);
            // while (!queue.isEmpty()) {
            // int v = queue.poll();
            // for (int w : graph[v]) {
            // if (colors[w] == -1) {
            // colors[w] = 1 - colors[v];
            // queue.push(w);
            // } else if (colors[w] == colors[v]) {
            // return false;
            // }
            // }
            // }
            // }
            // }
            // return true;
            // // 78/78 cases passed (2 ms)
            // // Your runtime beats 31.38 % of java submissions
            // // Your memory usage beats 7.32 % of java submissions (51.2 MB)
            if (colors[s] == -1 && !dfs(s, 0))
                return false;
        }
        return true;
    }

    // 返回以v为顶点的图是否二分图
    private boolean dfs(int v, int color) {
        colors[v] = color;
        for (int w : graph[v]) {
            if (colors[w] == -1 && !dfs(w, 1 - color))
                return false;
            if (colors[w] == color)
                return false;
        }
        return true;
        // 78/78 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 92.68 % of java submissions (40.2 MB)
    }
}
// @lc code=end

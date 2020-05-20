import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 *
 * https://leetcode.com/problems/critical-connections-in-a-network/description/
 *
 * algorithms
 * Hard (48.72%)
 * Likes:    927
 * Dislikes: 72
 * Total Accepted:    47.8K
 * Total Submissions: 98.2K
 * Testcase Example:  '4\n[[0,1],[1,2],[2,0],[1,3]]'
 *
 * There are n servers numbered from 0 to n-1 connected by undirected
 * server-to-server connections forming a network where connections[i] = [a, b]
 * represents a connection between servers a and b. Any server can reach any
 * other server directly or indirectly through the network.
 * 
 * A critical connection is a connection that, if removed, will make some
 * server unable to reach some other server.
 * 
 * Return all critical connections in the network in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^5
 * n-1 <= connections.length <= 10^5
 * connections[i][0] != connections[i][1]
 * There are no repeated connections.
 * 
 * 
 */

// @lc code=start
class Solution {
    // criticalConnections就是桥，图的寻桥问题
    // 通过ord和low，然后看low是否比ord大来解决寻桥问题
    // n是顶点数，connections是所有的边
    // 构建图
    // testcase: 5\n[[1,0],[2,0],[3,2],[4,2],[4,3],[3,0],[4,0]]

    private HashSet<Integer>[] graph;
    private int[] ord;
    private int[] low;
    private List<List<Integer>> bridges;
    private List<List<Integer>> connections;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        bridges = new ArrayList<>();
        if (connections == null || connections.size() == 0)
            return bridges;

        this.connections = connections;

        graph = new HashSet[n];
        ord = new int[n];
        low = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }

        for (List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }

        for (int s = 0; s < n; s++) {
            if (ord[s] == 0) {
                dfs(s, s);
            }
        }
        return bridges;

    }

    // 深度优先遍历
    private void dfs(int v, int s) {
        ord[v] = ord[s] + 1;
        low[v] = ord[v];
        // for (int i = 0; i < ord.length; i++) {
        // System.out.print(i + ": " + ord[i] + ", " + low[i] + " ");
        // }
        for (int w : graph[v]) {
            if (ord[w] == 0) {
                dfs(w, v);
            }
            if (w != s && w != v) {
                low[v] = Math.min(low[v], low[w]);
                if (low[w] > ord[v]) {
                    ArrayList<Integer> connection = new ArrayList<>();
                    connection.add(w);
                    connection.add(v);
                    bridges.add(connection);
                }
            }
        }

        // 12/12 cases passed (197 ms)
        // Your runtime beats 19.36 % of java submissions
        // Your memory usage beats 100 % of java submissions (137.2 MB)
    }
}
// @lc code=end

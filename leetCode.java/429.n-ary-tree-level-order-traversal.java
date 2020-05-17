import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (63.15%)
 * Likes:    497
 * Dislikes: 43
 * Total Accepted:    68.3K
 * Total Submissions: 107.3K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * 
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 * 
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        // 层序遍历，借助队列数据结构
        // 存储结果的list
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 队列queue初始化
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            // 记录该层的节点数
            int size = queue.size();
            // 初始化一个新的list放入res中
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                level.add(root.val);
                for (Node node : root.children) {
                    if (node != null)
                        queue.add(node);
                }
            }
            res.add(level);
        }
        return res;
    }
}
// @lc code=end

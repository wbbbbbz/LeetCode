import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (70.84%)
 * Likes:    561
 * Dislikes: 60
 * Total Accepted:    83K
 * Total Submissions: 116.6K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * 
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 * 
 * 
 * 
 * Follow up:
 * 
 * Recursive solution is trivial, could you do it iteratively?
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [5,6,3,2,4,1]
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();

        // postorder(root, res);

        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> peeked = new HashSet<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.peek();
            if (!peeked.contains(root)) {
                peeked.add(root);
                for (int i = root.children.size() - 1; i >= 0; i--) {
                    stack.push(root.children.get(i));
                }
            } else {
                res.add(stack.pop().val);
            }
        }

        return res;

        // 37/37 cases passed (14 ms)
        // Your runtime beats 5.5 % of java submissions
        // Your memory usage beats 100 % of java submissions (43.6 MB)

    }

    private void postorder(Node root, List<Integer> res) {
        if (root == null)
            return;

        for (Node node : root.children) {
            postorder(node, res);
        }
        res.add(root.val);

        // 37/37 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 100 % of java submissions (40.3 MB)

    }
}
// @lc code=end

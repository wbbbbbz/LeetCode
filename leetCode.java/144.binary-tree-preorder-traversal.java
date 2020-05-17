import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (54.40%)
 * Likes:    1333
 * Dislikes: 54
 * Total Accepted:    469.5K
 * Total Submissions: 857.6K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,2,3]
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        // preorderTraversal(root, res);

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }

        return res;

//         68/68 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 5.17 % of java submissions (38.2 MB)

    }

    private void preorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);

        // 68/68 cases passed (1 ms)
        // Your runtime beats 9.07 % of java submissions
        // Your memory usage beats 5.17 % of java submissions (39.3 MB)
    }
}
// @lc code=end

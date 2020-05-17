import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (61.49%)
 * Likes:    2788
 * Dislikes: 120
 * Total Accepted:    688.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
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
    // 返回的是存储遍历结果的list
    public List<Integer> inorderTraversal(TreeNode root) {
        // 1. 构建结果存储器
        List<Integer> res = new ArrayList<>();

        // // 2. 使用递归函数，传入结果存储器
        // inorderTraversal(root, res);

        // 迭代写法
        // 先左遍历，然后出栈，进入右节点
        // 建立一个stack模拟系统栈
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
        // 68/68 cases passed (1 ms)
        // Your runtime beats 10 % of java submissions
        // Your memory usage beats 5.11 % of java submissions (39.4 MB)

    }

    private void inorderTraversal(TreeNode root, List<Integer> res) {
        // 1. 递归基本条件
        if (root == null)
            return;

        // 2. 递归in-order
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);

        // 68/68 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 5.11 % of java submissions (37.4 MB)
    }
}
// @lc code=end

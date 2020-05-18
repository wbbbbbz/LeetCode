/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
 *
 * https://leetcode.com/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (62.31%)
 * Likes:    2885
 * Dislikes: 43
 * Total Accepted:    452K
 * Total Submissions: 720.6K
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * Invert a binary tree.
 * 
 * Example:
 * 
 * Input:
 * 
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 2     7
 * ⁠/ \   / \
 * 1   3 6   9
 * 
 * Output:
 * 
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 7     2
 * ⁠/ \   / \
 * 9   6 3   1
 * 
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * 
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you
 * can’t invert a binary tree on a whiteboard so f*** off.
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
    // 返回已被invert的树的根节点
    public TreeNode invertTree(TreeNode root) {
        // 递归基本条件
        if (root == null)
            return null;

        // 递归要素，左子树和右子树调转
        TreeNode invertedLeft = invertTree(root.left);
        TreeNode invertedRight = invertTree(root.right);

        root.left = invertedRight;
        root.right = invertedLeft;
        return root;

        // 68/68 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 5.1 % of java submissions (36.9 MB)
    }
}
// @lc code=end

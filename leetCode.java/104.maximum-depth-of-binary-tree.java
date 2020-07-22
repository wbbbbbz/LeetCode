/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (64.60%)
 * Likes:    2561
 * Dislikes: 74
 * Total Accepted:    835.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the
 * root node down to the farthest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * return its depth = 3.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int res;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return res;
//         39/39 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.01 % of java submissions (40.6 MB)
    }

    private void dfs(TreeNode root, int depth){
        if (root == null){
            return;
        }
        res = depth > res ? depth : res;
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (36.79%)
 * Likes:    1434
 * Dislikes: 692
 * Total Accepted:    419.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
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
    private int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root, 1);
        return res;
//         41/41 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 75.78 % of java submissions (39.3 MB)
    }
    private void dfs(TreeNode root, int depth){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            res = depth < res ? depth : res;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
// @lc code=end


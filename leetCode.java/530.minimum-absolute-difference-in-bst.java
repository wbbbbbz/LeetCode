/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (52.67%)
 * Likes:    876
 * Dislikes: 68
 * Total Accepted:    90.9K
 * Total Submissions: 169.1K
 * Testcase Example:  '[1,null,3,2]'
 *
 * Given a binary search tree with non-negative values, find the minimum
 * absolute difference between values of any two nodes.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   /
 * ⁠  2
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and
 * 1 (or between 2 and 3).
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * There are at least two nodes in this BST.
 * This question is the same as 783:
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * 
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

    private int last = Integer.MAX_VALUE >>> 1;
    private int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return 0;
        }
        inOrderDFS(root);
        return res;
    }

    private void inOrderDFS(TreeNode root){
        if (root == null){
            return;
        }
        inOrderDFS(root.left);
        res = Math.min(Math.abs(last - root.val), res);
        last = root.val;
        inOrderDFS(root.right);
        // 0ms, 39.2MB
    }
}
// @lc code=end


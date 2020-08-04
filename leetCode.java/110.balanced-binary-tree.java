/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 *
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (42.79%)
 * Likes:    2298
 * Dislikes: 171
 * Total Accepted:    452.8K
 * Total Submissions: 1M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * 
 * a binary tree in which the left and right subtrees of every node differ in
 * height by no more than 1.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Given the following tree [3,9,20,null,null,15,7]:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * Return true.
 * 
 * Example 2:
 * 
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * 
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   2
 * ⁠   / \
 * ⁠  3   3
 * ⁠ / \
 * ⁠4   4
 * 
 * 
 * Return false.
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
    // testcase: [1,2,2,3,null,null,3,4,null,null,4]
    private boolean res = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        getDepth(root, 0);
        return res;
        
    }

    private int getDepth(TreeNode root, int depth){
        if (root == null){
            return depth;
        }
        if (res == false){
            return -1;
        }

        int lDepth = getDepth(root.left, depth + 1);
        int rDepth = getDepth(root.right, depth + 1);
        if (Math.abs(lDepth-rDepth) > 1){
            res = false;
        }
        return Math.max(lDepth, rDepth);
//         227/227 cases passed (1 ms)
// Your runtime beats 67.98 % of java submissions
// Your memory usage beats 5.03 % of java submissions (41.9 MB)
    }
}
// @lc code=end


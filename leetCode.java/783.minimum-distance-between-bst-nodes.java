/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
 *
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 *
 * algorithms
 * Easy (51.79%)
 * Likes:    682
 * Dislikes: 192
 * Total Accepted:    62.6K
 * Total Submissions: 119.3K
 * Testcase Example:  '[4,2,6,1,3,null,null]'
 *
 * Given a Binary Search Tree (BST) with the root node root, return the minimum
 * difference between the values of any two different nodes in the tree.
 * 
 * Example :
 * 
 * 
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 * 
 * The given tree [4,2,6,1,3,null,null] is represented by the following
 * diagram:
 * 
 * ⁠         4
 * ⁠       /   \
 * ⁠     2      6
 * ⁠    / \    
 * ⁠   1   3  
 * 
 * while the minimum difference in this tree is 1, it occurs between node 1 and
 * node 2, also between node 3 and node 2.
 * 
 * 
 * Note:
 * 
 * 
 * The size of the BST will be between 2 and 100.
 * The BST is always valid, each node's value is an integer, and each node's
 * value is different.
 * This question is the same as 530:
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
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

    public int minDiffInBST(TreeNode root) {
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
        // 0ms, 37.1MB
    }
    
}
// @lc code=end


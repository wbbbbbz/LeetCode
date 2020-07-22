/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 *
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (50.42%)
 * Likes:    1164
 * Dislikes: 128
 * Total Accepted:    179.4K
 * Total Submissions: 352.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 * 
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
    private int res;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, false);
        return res;
    }

    private void helper(TreeNode root, boolean isLeftChild) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (isLeftChild) {
                res += root.val;
            }
        }
        helper(root.left, true);
        helper(root.right, false);
        // 102/102 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 5.05 % of java submissions (39.6 MB)
    }
}
// @lc code=end

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (53.10%)
 * Likes:    1549
 * Dislikes: 81
 * Total Accepted:    358.1K
 * Total Submissions: 668.1K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        postorderTraversal(root, res);

        return res;

    }

    private void postorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null)
            return;

        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);

//         68/68 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 5.63 % of java submissions (39.4 MB)
    }
}
// @lc code=end

import java.util.*;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (44.94%)
 * Likes:    1786
 * Dislikes: 66
 * Total Accepted:    332.8K
 * Total Submissions: 718K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
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
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return res;
        }
        pathSum(root, sum, new LinkedList<>());
        return res;
    }

    private void pathSum(TreeNode root, int sum, LinkedList<Integer> path){
        if (root == null){
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null){
            if (root.val == sum){
                res.add(path);
            }
            return;
        }
        
        pathSum(root.left, sum - root.val, new LinkedList<Integer>(path));
        pathSum(root.right, sum - root.val, new LinkedList<Integer>(path));

//         114/114 cases passed (37 ms)
// Your runtime beats 5.33 % of java submissions
// Your memory usage beats 5.02 % of java submissions (67.9 MB)

    }
}
// @lc code=end


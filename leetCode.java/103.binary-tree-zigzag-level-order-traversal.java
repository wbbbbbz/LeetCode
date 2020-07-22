import java.util.*;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (45.80%)
 * Likes:    2083
 * Dislikes: 100
 * Total Accepted:    362.2K
 * Total Submissions: 768.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    private List<List<Integer>> solution1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isEven = true;
        while (!queue.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
                if (isEven){
                    level.addLast(temp.val);
                } else {
                    level.addFirst(temp.val);
                }
            }
            isEven = !isEven;
            res.add(level);
        }
        return res;

//         33/33 cases passed (2 ms)
// Your runtime beats 23.14 % of java submissions
// Your memory usage beats 5.16 % of java submissions (39.9 MB)
    }

    // 递归dfs，level代表层数
    private void dfs(TreeNode root, int level){
            if (root == null){
                return;
            }
            if (level >= res.size()){
                res.add(new LinkedList<>());
            }
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
            if (level % 2 == 0){
                res.get(level).add(root.val);
            } else {
                res.get(level).add(0, root.val);
            }
    
            // 33/33 cases passed (2 ms)
            // Your runtime beats 23.14 % of java submissions
            // Your memory usage beats 5.37 % of java submissions (39.9 MB)
    }

}
// @lc code=end


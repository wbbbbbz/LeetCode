import java.util.*;
/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (50.55%)
 * Likes:    1498
 * Dislikes: 213
 * Total Accepted:    353.5K
 * Total Submissions: 663.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
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
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
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

    List<List<Integer>> res = new LinkedList<>();


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // return solution1(root);
        dfs(root, 0);
        Collections.reverse(res);
        return res;
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
        res.get(level).add(root.val);

//         34/34 cases passed (1 ms)
// Your runtime beats 89.66 % of java submissions
// Your memory usage beats 5.02 % of java submissions (40.6 MB)
    }

    private List<List<Integer>> solution1(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> currLevel = new LinkedList<>();
        LinkedList<TreeNode> nextLevel = new LinkedList<>();

        currLevel.add(root);
        
        while (!currLevel.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            for (TreeNode temp : currLevel) {
                level.add(temp.val);
                if (temp.left != null) {
                    nextLevel.add(temp.left);
                }
                if (temp.right != null) {
                    nextLevel.add(temp.right);
                }
            }
            res.addFirst(level);
            currLevel = nextLevel;
            nextLevel = new LinkedList<>();
        }

        return (List<List<Integer>>) res;

        // 34/34 cases passed (2 ms)
        // Your runtime beats 42.7 % of java submissions
        // Your memory usage beats 5.02 % of java submissions (40.6 MB)
    }
}
// @lc code=end

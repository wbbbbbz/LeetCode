import java.util.*;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (52.26%)
 * Likes:    2278
 * Dislikes: 134
 * Total Accepted:    293.9K
 * Total Submissions: 546.1K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
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
    // testcase: [1,2,3,null,5,null,null]
    private List<Integer> res = new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        // return solution1(root);
        // 可以使用postOrderDFS
        postOrderDFS(root, 0);
        return res;
    }

    private void postOrderDFS(TreeNode root, int depth){
        if (root != null){
            if (depth == res.size()){
                res.add(root.val);
            }
            postOrderDFS(root.right, depth + 1);
            postOrderDFS(root.left, depth + 1);
        }
//         211/211 cases passed (1 ms)
// Your runtime beats 84.11 % of java submissions
// Your memory usage beats 5.03 % of java submissions (40.1 MB)
    }

    private List<Integer> solution1(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        // 层序遍历，取每一层最后一个元素
        if (root == null){
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode temp = null;
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                if (temp.left != null){
                    queue.add(temp.left);
                } 
                if (temp.right != null){
                    queue.add(temp.right);
                }
            }
            res.add(temp.val);
        }
        return res;

//         211/211 cases passed (1 ms)
// Your runtime beats 84.11 % of java submissions
// Your memory usage beats 5.03 % of java submissions (39.9 MB)
    }
}
// @lc code=end


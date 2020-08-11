import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 *
 * https://leetcode.com/problems/house-robber-iii/description/
 *
 * algorithms
 * Medium (49.98%)
 * Likes:    2816
 * Dislikes: 55
 * Total Accepted:    160.7K
 * Total Submissions: 317.5K
 * Testcase Example:  '[3,2,3,null,3,null,1]'
 *
 * The thief has found himself a new place for his thievery again. There is
 * only one entrance to this area, called the "root." Besides the root, each
 * house has one and only one parent house. After a tour, the smart thief
 * realized that "all houses in this place forms a binary tree". It will
 * automatically contact the police if two directly-linked houses were broken
 * into on the same night.
 * 
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3,null,3,null,1]
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  2   3
 * ⁠   \   \ 
 * ⁠    3   1
 * 
 * Output: 7 
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * 
 * Example 2:
 * 
 * 
 * Input: [3,4,5,1,3,null,1]
 * 
 * 3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \   \ 
 * ⁠1   3   1
 * 
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
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
    // testcase: [2,1,4,3,null]
    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        // return Math.max(robAlongPath(root, true) , robAlongPath(root, false));
        return Math.max(robHelper(root)[0], robHelper(root)[1]);
    }

    // 0: with, 1: without
    private int[] robHelper(TreeNode root){
        if (root == null){
            return new int[2];
        }

        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        
        return new int[]{root.val + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
        // 0ms, 39.1MB
    }

    // private int robAlongPath(TreeNode root, boolean include){

    //     if (include){
    //         if(root.left == null && root.right == null){
    //             return root.val;
    //         }
    //         if (root.left == null){
    //             return robAlongPath(root.right, false) + root.val;
    //         }
    //         if (root.right == null){
    //             return robAlongPath(root.left, false) + root.val;
    //         }
    //         return robAlongPath(root.left, false) + robAlongPath(root.right, false) + root.val;
    //     }
    //     if (root.left == null && root.right == null){
    //         return 0;
    //     }
    //     if (root.left == null){
    //         return Math.max(robAlongPath(root.right, true), robAlongPath(root.right, false));
    //     }
    //     if (root.right == null){
    //         return Math.max(robAlongPath(root.left, true), robAlongPath(root.left, false));
    //     }
    //     return Math.max(robAlongPath(root.left, true), robAlongPath(root.left, false))
    //             + Math.max(robAlongPath(root.right, true), robAlongPath(root.right, false));
    //     // 621ms, 39.1MB
    // }

    // private int robAlongPath(TreeNode root, int include, int exclude){
    //     if (root == null){
    //         return Math.max(include, exclude);
    //     }

    //     System.out.println(String.format("root: %d, include: %d, exclude: %d", root.val, include, exclude));

    //     int temp = exclude;
    //     exclude = Math.max(include, exclude);
    //     include = temp + root.val;

    //     return Math.max(robAlongPath(root.left, include, exclude), robAlongPath(root.right, include, exclude));
    // }
}
// @lc code=end


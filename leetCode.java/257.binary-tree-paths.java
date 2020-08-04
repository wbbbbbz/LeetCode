import java.util.*;
/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (49.67%)
 * Likes:    1553
 * Dislikes: 93
 * Total Accepted:    305.3K
 * Total Submissions: 605.3K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * Output: ["1->2->5", "1->3"]
 * 
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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

    public List<String> binaryTreePaths(TreeNode root){
        if (root == null){
            return Arrays.asList();
        }

        if (root.left == null && root.right == null){
            return Arrays.asList(Integer.toString(root.val));
        }

        List<String> res = new LinkedList<>();

        List<String> leftList = binaryTreePaths(root.left);
        for (String s : leftList) {
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        List<String> rightList = binaryTreePaths(root.right);
        for (String s : rightList) {
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        return res;
    }

    // private List<String> list;

    // public List<String> binaryTreePaths(TreeNode root) {

    //     list = new ArrayList<>();

    //     if (root != null)
    //         helper(root, new StringBuilder());

    //     return list;

    // }

    // private void helper(TreeNode root, StringBuilder path) {
    //     path.append(root.val);
    //     // System.out.println(path);
    //     if (root.left == null && root.right == null) {
    //         list.add(path.toString());
    //         return;
    //     }
    //     path.append("->");
    //     String temp = path.toString();
    //     if (root.left != null)
    //         helper(root.left, path);
    //     if (root.right != null)
    //         helper(root.right, new StringBuilder(temp));

    //     // 209/209 cases passed (1 ms)
    //     // Your runtime beats 100 % of java submissions
    //     // Your memory usage beats 5.55 % of java submissions (39 MB)

    // }
}
// @lc code=end

/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (45.19%)
 * Likes:    3498
 * Dislikes: 301
 * Total Accepted:    185.4K
 * Total Submissions: 402.8K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards
 * (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
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

    private int sum;
    private int res;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        this.sum = sum;
        pathSumHelper(root, sum);
        return res;
    }

    private void pathSumHelper(TreeNode root, int rest) {
        if (root == null) {
            return;
        }
        System.out.println("root: "+root.val+", rest: "+rest+", res: "+this.res);
        if (root.val == rest) {
            this.res++;
            return;
        } else {
            pathSumHelper(root.left, rest - root.val);
            pathSumHelper(root.left, this.sum);
            pathSumHelper(root.right, rest - root.val);
            pathSumHelper(root.right, this.sum);
        }
    }
}
// @lc code=end

import java.util.HashMap;

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

    // testcase: [10,5,-3,3,2,null,11,3,-2,null,1]\n3

    private HashMap<Integer, Integer> map = new HashMap<>();

    private int target;

    public int pathSum(TreeNode root, int sum){

        if (root == null){
            return 0;
        }

        map.put(0, 1);

        this.target = sum;

        return pathSumHelper(root, 0);

        // return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        // 21ms
    }

    private int pathSumHelper(TreeNode root, int sum){
        
        if (root == null){
            return 0;
        }

        sum += root.val;

        int count = map.getOrDefault(sum - target, 0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        int res = count + pathSumHelper(root.left, sum) + pathSumHelper(root.right, sum);

        map.put(sum, map.get(sum) - 1);

        return res;
        
        // 2ms

    }

    // private int pathSumFrom(TreeNode root, int sum){
    //     if (root == null){
    //         return 0;
    //     }
    //     int res = root.val == sum ? 1 : 0;

    //     return res + pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val);
    // }

}
// @lc code=end

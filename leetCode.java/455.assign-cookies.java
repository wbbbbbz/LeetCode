/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 *
 * https://leetcode.com/problems/assign-cookies/description/
 *
 * algorithms
 * Easy (49.35%)
 * Likes:    636
 * Dislikes: 95
 * Total Accepted:    98.3K
 * Total Submissions: 197K
 * Testcase Example:  '[1,2,3]\n[1,1]'
 *
 * 
 * Assume you are an awesome parent and want to give your children some
 * cookies. But, you should give each child at most one cookie. Each child i
 * has a greed factor gi, which is the minimum size of a cookie that the child
 * will be content with; and each cookie j has a size sj. If sj >= gi, we can
 * assign the cookie j to the child i, and the child i will be content. Your
 * goal is to maximize the number of your content children and output the
 * maximum number.
 * 
 * 
 * Note:
 * You may assume the greed factor is always positive. 
 * You cannot assign more than one cookie to one child.
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,3], [1,1]
 * 
 * Output: 1
 * 
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3
 * children are 1, 2, 3. 
 * And even though you have 2 cookies, since their size is both 1, you could
 * only make the child whose greed factor is 1 content.
 * You need to output 1.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1,2], [1,2,3]
 * 
 * Output: 2
 * 
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2
 * children are 1, 2. 
 * You have 3 cookies and their sizes are big enough to gratify all of the
 * children, 
 * You need to output 2.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {

        // 贪心算法
        // 从贪心指数最小的小孩出发，一个一个进行满足
        // 可以反证。比如从最小的小孩出发进行满足，满足到最后。从最后的状态不管进行什么样的修改都不可能使解变得更大
        // 其实从贪心指数最大的小孩出发也可以
        if (g == null || s == null || g.length == 0 || s.length == 0){
            return 0;
        }
        
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;

        while (i < g.length && j < s.length){
            if (s[j] >= g[i]){
                i++;
            }
            j++;
        }
        return i;

        // 6ms, 40.5MB
    }
}
// @lc code=end


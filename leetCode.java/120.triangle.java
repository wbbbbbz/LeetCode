import java.util.*;
/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (42.78%)
 * Likes:    2076
 * Dislikes: 246
 * Total Accepted:    252.1K
 * Total Submissions: 571.9K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0){
            return 0;
        }

        List<Integer> list;
        List<Integer> last;

        for (int i = 1; i < triangle.size(); i++) {
            list = triangle.get(i);
            last = triangle.get(i - 1);
            list.set(0, list.get(0) + last.get(0));
            list.set(i, list.get(i) + last.get(i - 1));
            for (int j = 1; j < i; j++) {
                list.set(j, list.get(j) + Math.min(last.get(j - 1), last.get(j)));
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
        // 6ms, 41.6MB
    }
}
// @lc code=end


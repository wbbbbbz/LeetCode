import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 *
 * https://leetcode.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (16.72%)
 * Likes:    873
 * Dislikes: 1967
 * Total Accepted:    155.9K
 * Total Submissions: 922.1K
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * 
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */

// @lc code=start
class Solution {
    // testcase: [[0,0],[1,65536],[65536,0]]
    // testcase: [[1,1],[1,1],[0,0],[3,4],[4,5],[5,6],[7,8],[8,9]]
    // testcase: [[1,1],[1,1],[1,1]]
    public int maxPoints(int[][] points) {
        if (points == null){
            return 0;
        }
        if (points.length <= 2){
            return points.length;
        }

        HashMap<Integer, Long[]> lines = new HashMap<>();
        HashMap<Integer, Integer> same = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            same.merge(Arrays.hashCode(points[i]), 1, Integer::sum);
            for (int j = i + 1; j < points.length; j++) {
                if (!Arrays.equals(points[i], points[j])){
                    Long[] temp = getLine(points[i][0], points[i][1], points[j][0], points[j][1]);
                    lines.put(Arrays.hashCode(temp), temp);
                }
            }
        }

        int res = 0;

        // 同一个点算在同一条直线上
        for (int times : same.values()){
            res = Math.max(res, times);
        }
        
        for (Long[] line : lines.values()){
            int temp = 0;
            for (int i = 0; i < points.length; i++) {
                if (onLine(points[i][0], points[i][1], line)){
                    // System.out.println(Arrays.toString(line));
                    temp++;
                }
            }
            res = Math.max(temp, res);
        }
        
        return res;
//         41/41 cases passed (20 ms)
// Your runtime beats 71.09 % of java submissions
// Your memory usage beats 49.57 % of java submissions (39.5 MB)
    }
    
    private Long[] getLine(int x1, int y1, int x2, int y2){
        return new Long[]{(long)y2 - y1, (long)x1- x2, (long)x2 * y1 - x1 * y2};
    }
    
    private boolean onLine(int x, int y, Long[] line){
        return line[0] * x + line[1] * y + line[2] == 0;
    }
}
// @lc code=end


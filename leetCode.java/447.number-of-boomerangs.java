import java.util.HashMap;

/*
 * @lc app=leetcode id=447 lang=java
 *
 * [447] Number of Boomerangs
 *
 * https://leetcode.com/problems/number-of-boomerangs/description/
 *
 * algorithms
 * Easy (51.35%)
 * Likes:    398
 * Dislikes: 664
 * Total Accepted:    67.7K
 * Total Submissions: 130.8K
 * Testcase Example:  '[[0,0],[1,0],[2,0]]'
 *
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is
 * a tuple of points (i, j, k) such that the distance between i and j equals
 * the distance between i and k (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 * 
 * Example:
 * 
 * 
 * Input:
 * [[0,0],[1,0],[2,0]]
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    // testcase: [[0,0],[1,0],[2,0],[0,1],[0,2],[-1,0],[-2,0]]
    // testcase: [[0,0],[1,0],[-1,0],[0,1],[0,-1]]
    // testcase: [[0,0],[2,0],[-2,0],[0,2]]
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) {
            return 0;
        }

        // return solution1(points);

        // 参考leetcode最快方法，只用一个map，每一次clear一下
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int dis = (points[j][0] - points[i][0]) * (points[j][0] - points[i][0])
                        + (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]);
                res += map.merge(dis, 1, Integer::sum) - 1;
            }
            // System.out.println(map);
            map.clear();
        }
        // 31/31 cases passed (130 ms)
        // Your runtime beats 60.73 % of java submissions
        // Your memory usage beats 15.22 % of java submissions (108.5 MB)
        return res * 2;

    }

    private int solution1(int[][] points) {
        int res = 0;
        // 遍历，剩余点的距离进行分类
        // 分类之后
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                int dis = (points[j][0] - points[i][0]) * (points[j][0] - points[i][0])
                        + (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            // System.out.println(map);
            for (int j : map.values()) {
                if (j >= 2) {
                    // nP2
                    res += (j * (j - 1));
                }
            }
        }

        return res;

        // 31/31 cases passed (271 ms)
        // Your runtime beats 15.58 % of java submissions
        // Your memory usage beats 5.8 % of java submissions (114.5 MB)
    }
}
// @lc code=end

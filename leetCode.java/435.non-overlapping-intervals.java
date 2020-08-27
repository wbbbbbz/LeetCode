import java.util.*;

/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 *
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 *
 * algorithms
 * Medium (42.28%)
 * Likes:    1123
 * Dislikes: 37
 * Total Accepted:    78.6K
 * Total Submissions: 183K
 * Testcase Example:  '[[1,2]]'
 *
 * Given a collection of intervals, find the minimum number of intervals you
 * need to remove to make the rest of the intervals non-overlapping.
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are
 * non-overlapping.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals
 * non-overlapping.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're
 * already non-overlapping.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * You may assume the interval's end point is always bigger than its start
 * point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't
 * overlap each other.
 * 
 * 
 */

// @lc code=start
class Solution {
    // testcase: [[1,3],[1,2],[1,4],[2,5],[2,4],[2,3],[3,5],[3,4]]
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals == null) {
            return 0;
        }
        int n = intervals.length;

        if (n <= 1){
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // System.out.println(Arrays.deepToString(intervals));

        int end = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
        // 2ms, 39.4MB

        // return solution2(intervals);

    }

    private int solution2(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] temp = intervals[i];
            map.put(temp[1], Math.max(temp[0], map.getOrDefault(temp[1], Integer.MIN_VALUE)));
        }

        int lastEnd = Integer.MIN_VALUE;
        int res = 0;

        // System.out.println(map);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= lastEnd){
                res++;
                lastEnd = entry.getKey();
            }
        }

        return intervals.length - res;
        // 5ms
    }
}
// @lc code=end

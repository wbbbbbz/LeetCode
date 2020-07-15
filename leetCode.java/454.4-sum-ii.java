import java.util.HashMap;

/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 *
 * https://leetcode.com/problems/4sum-ii/description/
 *
 * algorithms
 * Medium (52.54%)
 * Likes:    1176
 * Dislikes: 72
 * Total Accepted:    109.5K
 * Total Submissions: 206.5K
 * Testcase Example:  '[1,2]\n[-2,-1]\n[-1,2]\n[0,2]'
 *
 * Given four lists A, B, C, D of integer values, compute how many tuples (i,
 * j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * 
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤
 * N ≤ 500. All integers are in the range of -2^28 to 2^28 - 1 and the result
 * is guaranteed to be at most 2^31 - 1.
 * 
 * Example:
 * 
 * 
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    // testcase: [-1,-1]\n[-1,1]\n[-1,1]\n[1,-1]
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int res = 0;

        // 暴力解法，用空间换时间。
        // n^2进行搜索, n^2建立哈希表
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put((C[i] + D[j]), map.getOrDefault((C[i] + D[j]), 0) + 1);
            }
        }

        // System.out.println(map);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += map.getOrDefault(-(A[i] + B[j]), 0);
            }
        }
        return res;
        // 48/48 cases passed (62 ms)
        // Your runtime beats 89.1 % of java submissions
        // Your memory usage beats 62.23 % of java submissions (58.7 MB)
    }
}
// @lc code=end

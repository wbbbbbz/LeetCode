import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.concurrent.ForkJoinPool;

/*
 * @lc app=leetcode id=719 lang=java
 *
 * [719] Find K-th Smallest Pair Distance
 *
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
 *
 * algorithms
 * Hard (30.85%)
 * Likes:    925
 * Dislikes: 34
 * Total Accepted:    32.5K
 * Total Submissions: 103.5K
 * Testcase Example:  '[1,3,1]\n1'
 *
 * Given an integer array, return the k-th smallest distance among all the
 * pairs. The distance of a pair (A, B) is defined as the absolute difference
 * between A and B. 
 * 
 * Example 1:
 * 
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0 
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * 
 * 
 * 
 * Note:
 * 
 * 2 .
 * 0 .
 * 1 .
 * 
 * 
 */

// @lc code=start
class Solution {
    // testcase : [1,2,3,4,5,1,13,5,6,3,2,25,523,62,35,67234,52,6,23,41,56]\n10
    // testcase : [1,6,1]\n3
    // testcase : [38,33,57,65,13,2,86,75,4,56]\n26
    public int smallestDistancePair(int[] nums, int k) {

        // 使用hashMap或者priority queue容易造成时间或者内存超标
        // 参考leetcode
        // return solution1(nums, k);

        // 2. binarySearch法
        // 首先进行排序，之后就知道数字差的范围了。对这个范围进行二分搜索
        // 并且个数计算也可以使用二分搜索，不过需要仔细处理
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        int mid = (low + high) >>> 1;
        int count = 0;
        while (low < high) {
            count = 0;
            mid = (low + high) >>> 1;
            for (int i = 0; i < nums.length - 1; i++) {
                int j = 0;
                while (j < nums.length && nums[j] <= nums[i] + mid){
                    j++;
                }
                count += j - i - 1;
            }
            if (k <= count) {
                high = mid;
            } else {
                low = mid + 1;
            }
            // System.out.println("low: " + low + ", mid: " + mid + ", high: " + high);
        }
        return low;
    }

    private int solution1(int[] nums, int k) {
        // 1. bucket sort
        // 因为题目已经给出了最大差也在1000000以内
        int[] bucket = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                bucket[Math.abs(nums[j] - nums[i])]++;
            }
        }

        for (int i = 0; i < bucket.length; i++) {
            if ((k -= bucket[i]) <= 0) {
                return i;
            }
        }
        return -1;
        // 19/19 cases passed (888 ms)
        // Your runtime beats 5.11 % of java submissions
        // Your memory usage beats 5.09 % of java submissions (89.8 MB)
    }
}
// @lc code=end

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (59.54%)
 * Likes:    2580
 * Dislikes: 184
 * Total Accepted:    343.3K
 * Total Submissions: 575.8K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Note: 
 * 
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top
 * k frequent elements is unique.
 * You can return the answer in any order.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 因为要优于nlogn，所以使用堆（java的优先队列）
        // 大小为k, 频次越高优先度越低的优先队列(也就是最小堆)
        // 使用map记录frequency

        // Testcase: [-1,-1]\n1
        // Testcase: [4,1,-1,2,-1,2,3]\n2
        // Testcase: [5,3,1,1,1,3,73,1]\n2

        if (nums.length == k){
            return nums;
        }

        // 1.创建map记录frequency:
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i : nums)
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        int n = frequency.size();
        // System.out.println(frequency);

        // // 2.创建大小为k的优先队列，元素越小优先级越高
        // PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(k,
        //         (o1, o2) -> o1.getValue() - o2.getValue());

        // int[] output = new int[k];

        // // 3.遍历每一个map元素，如果优先队列还没到size就直接加入，如果到了size就要判断现在的频率是否大于topK的最小值，是就加入
        // for (Map.Entry<Integer, Integer> e : frequency.entrySet()) {
        //     if (priorityQueue.size() < k)
        //         priorityQueue.add(e);
        //     else if (e.getValue() > priorityQueue.peek().getValue()) {
        //         priorityQueue.poll();
        //         priorityQueue.add(e);
        //     }
        // }

        // int index = 0;

        // // 4.输出topK优先队列里的所有key
        // for (Map.Entry<Integer, Integer> e : priorityQueue) {
        //     output[index++] = e.getKey();
        // }

        // return output;

        // 反过来，维持一个n-k大小的优先队列，元素越大优先级越高。这样最后不在该优先队列里的就是topK元素
        int[] output = new int[k];
        int index = 0;

        if (n == k){
            for (int i : frequency.keySet()) {
                output[index++] = i;
            }
            return output;
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(n - k,
                (o1, o2) -> o2.getValue() - o1.getValue());


        for (Map.Entry<Integer, Integer> e : frequency.entrySet()) {
            if (priorityQueue.size() < n - k)
                priorityQueue.add(e);
            else if (e.getValue() < priorityQueue.peek().getValue()) {
                output[index++] = priorityQueue.poll().getKey();
                priorityQueue.add(e);
            } else {
                output[index++] = e.getKey();
            }
            // System.out.println(priorityQueue);
        }

        return output;
    }

//     21/21 cases passed (9 ms)
    // Your runtime beats 87.12 % of java submissions
    // Your memory usage beats 9.48 % of java submissions (42.2 MB)
}
// @lc code=end

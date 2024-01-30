/*
 * @lc app=leetcode id=493 lang=scala
 *
 * [493] Reverse Pairs
 *
 * https://leetcode.com/problems/reverse-pairs/description/
 *
 * algorithms
 * Hard (24.52%)
 * Likes:    1035
 * Dislikes: 126
 * Total Accepted:    43.7K
 * Total Submissions: 169.1K
 * Testcase Example:  '[1,3,2,3,1]'
 *
 * Given an array nums, we call (i, j) an important reverse pair if i < j and
 * nums[i] > 2*nums[j].
 * 
 * You need to return the number of important reverse pairs in the given
 * array.
 * 
 * Example1:
 * 
 * Input: [1,3,2,3,1]
 * Output: 2
 * 
 * 
 * Example2:
 * 
 * Input: [2,4,3,5,1]
 * Output: 3
 * 
 * 
 * Note:
 * 
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 * 
 * 
 */

// @lc code=start
object Solution {
    // [2147483647,2147483647,2147483647,2147483647,2147483647,2147483647]
    def reversePairs(nums: Array[Int]): Int = {
        @annotation.tailrec
        def go(nums: Array[Int], counts: Int): Int = nums.length match {
            case n if n <= 1 => counts
            case _ => go(nums.tail, nums.tail.count(a => a.toLong * 2  < nums.head) + counts)
        }
        go(nums, 0)
    }
}
// @lc code=end


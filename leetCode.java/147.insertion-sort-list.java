/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
 *
 * https://leetcode.com/problems/insertion-sort-list/description/
 *
 * algorithms
 * Medium (40.00%)
 * Likes:    616
 * Dislikes: 582
 * Total Accepted:    184.2K
 * Total Submissions: 450.2K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list using insertion sort.
 * 
 * 
 * 
 * 
 * 
 * A graphical example of insertion sort. The partial sorted list (black)
 * initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and
 * inserted in-place into the sorted list
 * 
 * 
 * 
 * 
 * 
 * Algorithm of Insertion Sort:
 * 
 * 
 * Insertion sort iterates, consuming one input element each repetition, and
 * growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data,
 * finds the location it belongs within the sorted list, and inserts it
 * there.
 * It repeats until no input elements remain.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // 定义pointer辅助排序
        // head：排好序部分的尾结点。如果要插入，那么就不需要动。如果不要插入就瞬移
        // prev：需要插入的前一个结点。每一次都从dummy开始遍历寻找
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = dummy;
        ListNode next = head.next;
        
        while (head.next != null){
            next = head.next;
            if (next.val >= head.val){
                head = next;
                continue;
            }
            prev = dummy;
            while (prev.next.val <= next.val){
                prev = prev.next;
            }
            head.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;

//         22/22 cases passed (6 ms)
// Your runtime beats 76.19 % of java submissions
// Your memory usage beats 10.28 % of java submissions (41.7 MB)

    }
}
// @lc code=end


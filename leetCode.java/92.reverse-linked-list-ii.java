/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (37.68%)
 * Likes:    2359
 * Dislikes: 140
 * Total Accepted:    273.4K
 * Total Submissions: 708K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // testcase: [1,2,3,4,5,6,7,8,9,10]\n1\n10
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || n == 0) {
            return head;
        }
        // 优化
        // 原解法会出现断链，所以需要一个next
        // 将prev暂时连接到next上，保证不断链

        n -= m;
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        while (m > 1 && head != null) {
            prev = head;
            head = head.next;
            m--;
        }

        ListNode start = head;
        head = head.next;

        while (n > 0 && head != null) {
            start.next = head.next;
            head.next = prev.next;
            prev.next = head;
            head = start.next;
            n--;
        }

        return dummy.next;

        // 44/44 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 5.08 % of java submissions (39.4 MB)
    }
}
// @lc code=end

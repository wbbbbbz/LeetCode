/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (34.88%)
 * Likes:    3375
 * Dislikes: 231
 * Total Accepted:    633.2K
 * Total Submissions: 1.8M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, remove the n-th node from the end of list and return
 * its head.
 * 
 * Example:
 * 
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * 
 * Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;

        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null){
            head = head.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
        
    //     208/208 cases passed (1 ms)
    // Your runtime beats 30.64 % of java submissions
    // Your memory usage beats 59.37 % of java submissions (37.6 MB)
    }
}
// @lc code=end


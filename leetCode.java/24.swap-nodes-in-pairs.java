/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (48.91%)
 * Likes:    2304
 * Dislikes: 171
 * Total Accepted:    472.6K
 * Total Submissions: 943.4K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
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
    public ListNode swapPairs(ListNode head) {
        
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode next = head.next;

        while (next != null){
            head.next = next.next;
            next.next = head;
            prev.next = next;

            if (head.next == null){
                break;
            }
            prev = head;
            head = head.next;
            next = head.next;
        }

        return dummy.next;

//         55/55 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 62.98 % of java submissions (37 MB)
    }
}
// @lc code=end


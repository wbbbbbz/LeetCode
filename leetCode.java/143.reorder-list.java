import java.util.LinkedList;

/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (35.12%)
 * Likes:    1909
 * Dislikes: 117
 * Total Accepted:    234.5K
 * Total Submissions: 638.5K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        LinkedList<ListNode> list = new LinkedList<>();

        ListNode dummy = new ListNode(-1, head);

        while (head != null){
            list.add(head);
            head = head.next;
        }

        head = dummy;

        while (list.size() >= 2){
            head.next = list.pollFirst();
            head = head.next;
            head.next = list.pollLast();
            head = head.next;
        }

        if (!list.isEmpty()){
            head.next = list.poll();
            head = head.next;
        }
        head.next = null;

        // 13/13 cases passed (3 ms)
        // Your runtime beats 30.4 % of java submissions
        // Your memory usage beats 26.77 % of java submissions (42.8 MB)
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (40.23%)
 * Likes:    2744
 * Dislikes: 130
 * Total Accepted:    266.1K
 * Total Submissions: 634.9K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
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
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1, head);

        int length = 0;
        while (head != null){
            head = head.next;
            length++;
        }


        for (int step = 1; step < length; step >>= 1) {
            head = dummy.next;
            prev = head;
            for (int i = 0; i < step; i++) {
                head = head.next;
            }
            
        }

        
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while (true){
            if (l1 == null){
                head.next = l2;
                return dummy.next;
            }
            if (l2 == null){
                head.next = l1;
                return dummy.next;
            }
            if (l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
}
// @lc code=end


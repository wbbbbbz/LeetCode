/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (51.95%)
 * Likes:    4331
 * Dislikes: 598
 * Total Accepted:    1M
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new sorted list. The new
 * list should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

//         208/208 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 28.78 % of java submissions (39.3 MB)
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (44.60%)
 * Likes:    1557
 * Dislikes: 112
 * Total Accepted:    466.2K
 * Total Submissions: 1M
 * Testcase Example:  '[1,1,2]'
 *
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->1->2
 * Output: 1->2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->2->3->3
 * Output: 1->2->3
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
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode start = head;
        head = head.next;
        while (head != null){
            if (head.val != start.val){
                start.next = head;
                start = head;
            } 
            head = head.next;
        }
        start.next = null;
        return dummy.next;
//         165/165 cases passed (1 ms)
// Your runtime beats 39.58 % of java submissions
// Your memory usage beats 5.01 % of java submissions (41.7 MB)
    }
}
// @lc code=end


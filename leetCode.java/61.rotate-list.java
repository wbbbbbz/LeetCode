/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (29.17%)
 * Likes:    1256
 * Dislikes: 1003
 * Total Accepted:    274.9K
 * Total Submissions: 920.8K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        int length = 0;
        while (head != null){
            head = head.next;
            length++;
        }
        k %= length;
        if (k == 0){
            return dummy.next;
        }
        head = dummy.next;
        for (int i = 0; i < k - 1; i++) {
            head = head.next;
        }
        while (head.next != null){
            head = head.next;
            prev = prev.next;
        }
        head.next = dummy.next;
        dummy.next = prev.next;
        prev.next = null;
        return dummy.next;
//         231/231 cases passed (1 ms)
// Your runtime beats 48.2 % of java submissions
// Your memory usage beats 6.57 % of java submissions (40.4 MB)
    }
}
// @lc code=end


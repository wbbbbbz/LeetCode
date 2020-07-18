import java.util.Stack;

/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (60.49%)
 * Likes:    4572
 * Dislikes: 91
 * Total Accepted:    1M
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * 
 * Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 有两种方法，recursively和iteratively
        if (head == null || head.next == null) {
            return head;
        }

        // return reverseHelper(head);

        ListNode prev = null;
        ListNode next = head.next;
        while (next != null){
            head.next = prev;
            prev = head;
            head = next;
            next = next.next;
        }
        head.next = prev;
        return head;
        // 27/27 cases passed (0 ms)
        // Your runtime beats 100 % of java submissions
        // Your memory usage beats 64.3 % of java submissions (39.2 MB)
    }

    // 递归，输入需要reverse部分的头指针，返回Reversed的链表的头指针
    private ListNode reverseHelper(ListNode head) {
        // 递归终止条件。如果下一个是null就不用反转
        if (head.next == null) {
            return head;
        }

        // 递归过程
        ListNode resHead = reverseHelper(head.next);
        head.next = null;
        ListNode temp = resHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return resHead;

        // 27/27 cases passed (20 ms)
        // Your runtime beats 8.93 % of java submissions
        // Your memory usage beats 5.06 % of java submissions (40.6 MB)

    }
}
// @lc code=end

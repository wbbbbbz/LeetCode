/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
 *
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (37.32%)
 * Likes:    1320
 * Dislikes: 79
 * Total Accepted:    298.8K
 * Total Submissions: 800.3K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * 
 * 
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // // Remove All就需要完整遍历
        // // 节点在头，中，尾的情况
        // // 删完节点链表为不为空？
        // // TestCase:
        // // [1,2,3,4,5]\n1
        // // [1,2,3,4,5]\n5
        // // [1,1,1,1,1]\n1

        // ListNode dummyHead = new ListNode(-1);
        // dummyHead.next = head;
        // ListNode prev = dummyHead;
        // while (prev != null && prev.next != null) {
        // if (prev.next.val == val) {
        // prev.next = prev.next.next;
        // } else {
        // prev = prev.next;
        // }
        // }
        // return dummyHead.next;

        // 递归想法
        // 删除一个链表中所有的val元素，可以分成下列子问题：
        // 判断现在的head是不是val元素，如果不是，将head连接到removeElements(head.next, val)进行返回
        // 如果现在的head是val元素，直接返回removeElements(head.next, val)
        if (head == null) {
            return null;
        }
        if (head.val != val) {
            head.next = removeElements(head.next, val);
        } else {
            head = removeElements(head.next, val);
        }
        return head;

        // head.next = removeElements(head.next, val);
        // return head.val == val ? head.next : head;

    }
}
// @lc code=end

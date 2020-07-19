/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (40.18%)
 * Likes:    1296
 * Dislikes: 299
 * Total Accepted:    216.1K
 * Total Submissions: 524.2K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        // 保持head作为遍历原有链的pointer
        // 保持dummyleft, dummyright作为新链左右的dummyHead
        // 保持left, right作为新联左右的遍历pointer
        // 最终使left.next = dummyright.next;
        // 注意要使right.next = null，否则right之后有可能指向left的一部分！
        // return dummyLeft.next;

        ListNode dummyLeft = new ListNode();
        ListNode dummyRight = new ListNode();
        ListNode left = dummyLeft;
        ListNode right = dummyRight;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        left.next = dummyRight.next;
        right.next = null;
        return dummyLeft.next;

        // 166/166 cases passed (1 ms)
        // Your runtime beats 31.45 % of java submissions
        // Your memory usage beats 68.21 % of java submissions (38.9 MB)
    }
}
// @lc code=end

/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (38.32%)
 * Likes:    3195
 * Dislikes: 359
 * Total Accepted:    429.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        LinkedList<ListNode> list = new LinkedList<>();

        ListNode dummy = new ListNode(-1, head);

        while (head != null){
            list.add(head);
            head = head.next;
        }

        head = dummy;

        while (list.size() >= 2){
            if (list.pollFirst().val != list.pollLast().val){
                return false;
            }
        }

        return true;

//         26/26 cases passed (4 ms)
// Your runtime beats 17.87 % of java submissions
// Your memory usage beats 6.05 % of java submissions (46.4 MB)
    }
}
// @lc code=end


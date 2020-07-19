import java.util.Stack;

/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (53.23%)
 * Likes:    1447
 * Dislikes: 153
 * Total Accepted:    159.4K
 * Total Submissions: 293.4K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the
 * lists is not allowed.
 * 
 * 
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if (l1 == null && l2 == null){
            return null;
        }
        Stack<ListNode> l1S = new Stack<>();
        Stack<ListNode> l2S = new Stack<>();
        while (l1 != null){
            l1S.push(l1);
            l1 = l1.next;
        }
        while (l2 != null){
            l2S.push(l2);
            l2 = l2.next;
        }

        if (l1S.size() < l2S.size()){
            Stack<ListNode> temp = l1S;
            l1S = l2S;
            l2S = temp;
            temp = null;
        }

        int carry = 0;
        int tempSum = 0;

        while (!l1S.empty()){
            l1 = l1S.pop();
            if (l2S.empty()){
                l2.val = 0;
            } else {
                l2 = l2S.pop();
            }
            tempSum = l1.val + l2.val + carry;
            carry = tempSum / 10;
            l1.val = tempSum % 10;
        }
        if (carry != 0){
            l1 = new ListNode(1, l1);
        }
        return l1;

//         1563/1563 cases passed (6 ms)
// Your runtime beats 27.52 % of java submissions
// Your memory usage beats 12.39 % of java submissions (44.7 MB)
    }
}
// @lc code=end


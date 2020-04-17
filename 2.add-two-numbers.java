/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (33.06%)
 * Likes:    7518
 * Dislikes: 1945
 * Total Accepted:    1.3M
 * Total Submissions: 3.9M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 用while句循环l1和l2，短的结束之后遍历长的。所以需要判断谁短谁长。
        // 使用l1进行in-place calculation
        // 因为是链表，需要一个output指向结果
        // 模拟笔算加法法则，记录进位(carry)
        // 直接用int记录结果，每一次乘上10
        // 边际：最后有carry怎么办？
        // carry最后处理
        // Testcase: [2,4,9]\n[9,9,9]
        // Testcase: [1]\n[9,9]
        // Testcase: [2,4,9,9,9]\n[9,9,9]
        // Testcase: [0]\n[7,3]  --> 连接l2之后的处理！（1. 先l1跳到l1.next, 2. 将l2接到l1之后，就不是进行加法了，所以要将l2进行null化！）

        ListNode output = l1;

        ListNode tempL1 = output;

        int carry = 0;



        // 先循环l1，内部判断l2是否为null，tempL1是l1前一个node
        // 1. l2.length < l1.length时，l1 = null, l2 = null
        // 2. l2.length == l1.length时，l1 = null, l2 = null
        // 3. l2.length > l1.length时，l1 = null, l2 = ...
        while (true) {

            if (l1 == null) {
                l1 = tempL1;
                if (l2 == null) {
                    if (carry == 1) {
                        l1.next = new ListNode(1);
                    }
                    return output;
                }
                l1.next = l2;
                l2 = null;
                l1 = l1.next;
            }

            int l2Val = 0;

            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }

            int temp = l1.val + l2Val + carry;

            carry = temp >= 10 ? 1 : 0;

            l1.val = temp % 10;

            tempL1 = l1;
            l1 = l1.next;
        }

    }

    // Accepted
    // 1563/1563 cases passed (1 ms)
    // Your runtime beats 100 % of java submissions
    // Your memory usage beats 99.69 % of java submissions (39.5 MB)
}
// @lc code=end



import java.util.LinkedList;

/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (35.71%)
 * Likes:    1697
 * Dislikes: 108
 * Total Accepted:    251.3K
 * Total Submissions: 687.1K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Return the linked list sorted as well.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
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
    
    // 递归删除重复结点
    // 返回已经删除重复结点的头结点
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null || head.next == null){
            return head;
        }

        if (head.next.val == head.val){
            while (head.next != null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }

        head.next = deleteDuplicates(head.next);

        return head;

//         166/166 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 13.96 % of java submissions (39.6 MB)

    }
}
// @lc code=end


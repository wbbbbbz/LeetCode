import java.util.*;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (38.80%)
 * Likes:    4829
 * Dislikes: 292
 * Total Accepted:    657.8K
 * Total Submissions: 1.6M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0){
            return null;
        }

        ListNode dummy = new ListNode();
        ListNode head = dummy;
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for(ListNode n : lists){
            if (n != null){
                pQueue.add(n);
            }
        }
        while (!pQueue.isEmpty()){
            ListNode temp = pQueue.poll();
            head.next = temp;
            head = head.next;
            if (temp.next != null){
                pQueue.add(temp.next);
            }
        }
        return dummy.next;
//         131/131 cases passed (6 ms)
// Your runtime beats 48.52 % of java submissions
// Your memory usage beats 21.44 % of java submissions (41.6 MB)
    }
}
// @lc code=end


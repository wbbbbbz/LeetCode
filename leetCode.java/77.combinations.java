import java.util.*;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (52.77%)
 * Likes:    1503
 * Dislikes: 67
 * Total Accepted:    293.1K
 * Total Submissions: 538.3K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {

    List<List<Integer>> res = new LinkedList<>();

    private int n;

    public List<List<Integer>> combine(int n, int k) {

        this.n = n;

        for (int i = 1; i <= n; i++) {
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(i);
            genCom(i + 1, k - 1, temp);
        }

        return res;
    }

    private void genCom(int start, int rest, LinkedList<Integer> com){

        if (rest == 0){
            res.add(new LinkedList<Integer>(com));
        }

        for (int i = start; i <= n; i++) {
            com.add(i);
            genCom(i + 1, rest - 1, com);
            com.pollLast();
        }

        // 16ms
    }
}
// @lc code=end


import java.util.HashSet;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=414 lang=java
 *
 * [414] Third Maximum Number
 */
import java.util.Collections;
// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {

        int first = Integer.MIN_VALUE; 
        int second = Integer.MIN_VALUE; 
        int third = Integer.MIN_VALUE;

        HashSet<Integer> numsSet = new HashSet<>();

        for (int i : nums) {
            numsSet.add(i);
            if(i > first){
                third = second;
                second = first;
                first = i;
            } else if (i < first && i > second){
                third = second;
                second = i;
            } else if (i < second && i > third){
                third = i;
            }
        }

        if (numsSet.size() >= 3){
            return third;
        }
        return first;
    }
}
// @lc code=end
/*
 * Runtime: 6 ms, faster than 49.78% of Java online submissions for Third Maximum Number.
 * Memory Usage: 43.9 MB, less than 44.37% of Java online submissions for Third Maximum Number.
 * 用一个set以用来知道到底有多少个独特的数字。这个问题难以处理的是Integer.MIN_VALUE，不知道是否存在。使用Long.MIN_VALUE可以避免这个问题
 */


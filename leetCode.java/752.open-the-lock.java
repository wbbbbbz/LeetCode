import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 *
 * https://leetcode.com/problems/open-the-lock/description/
 *
 * algorithms
 * Medium (50.02%)
 * Likes:    805
 * Dislikes: 42
 * Total Accepted:    51.2K
 * Total Submissions: 101.1K
 * Testcase Example:  '["0201","0101","0102","1212","2002"]\n"0202"'
 *
 * 
 * You have a lock in front of you with 4 circular wheels.  Each wheel has 10
 * slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.  The wheels can
 * rotate freely and wrap around: for example we can turn '9' to be '0', or '0'
 * to be '9'.  Each move consists of turning one wheel one slot.
 * 
 * The lock initially starts at '0000', a string representing the state of the
 * 4 wheels.
 * 
 * You are given a list of deadends dead ends, meaning if the lock displays any
 * of these codes, the wheels of the lock will stop turning and you will be
 * unable to open it.
 * 
 * Given a target representing the value of the wheels that will unlock the
 * lock, return the minimum total number of turns required to open the lock, or
 * -1 if it is impossible.
 * 
 * 
 * Example 1:
 * 
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" ->
 * "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202"
 * would be invalid,
 * because the wheels of the lock become stuck after the display becomes the
 * dead end "0102".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"],
 * target = "8888"
 * Output: -1
 * Explanation:
 * We can't reach the target without getting stuck.
 * 
 * 
 * 
 * Example 4:
 * 
 * Input: deadends = ["0000"], target = "8888"
 * Output: -1
 * 
 * 
 * 
 * Note:
 * 
 * The length of deadends will be in the range [1, 500].
 * target will not be in the list deadends.
 * Every string in deadends and the string target will be a string of 4 digits
 * from the 10,000 possibilities '0000' to '9999'.
 * 
 * 
 */

// @lc code=start
class Solution {

    private int[] steps;
    private int t;

    public int openLock(String[] deadends, String target) {

        this.t = Integer.parseInt(target);
        this.steps = new int[10000];

        for (String s : deadends) {
            steps[Integer.parseInt(s)] = -1;
        }

        if (steps[0] == -1 || steps[t] == -1)
            return -1;

        return bfs();

    }

    private int bfs() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        steps[0] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : next(curr)) {
                if (steps[next] == 0) {
                    steps[next] = steps[curr] + 1;
                    queue.add(next);
                    if (next == t)
                        return steps[next];
                }
            }
        }

        return -1;

        // 43/43 cases passed (31 ms)
        // Your runtime beats 95.34 % of java submissions
        // Your memory usage beats 84.21 % of java submissions (40.1 MB)
    }

    private Iterable<Integer> next(int curr) {
        ArrayList<Integer> res = new ArrayList<>();

        int base = 1000;
        while (base > 0) {
            int d0 = (curr / base) % 10;
            for (int delta = 9; delta <= 11; delta += 2) {
                int d1 = (d0 + delta) % 10;
                res.add(curr + (d1 - d0) * base);
            }
            base /= 10;
        }
        return res;
    }
}
// @lc code=end

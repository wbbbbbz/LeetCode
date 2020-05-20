import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=773 lang=java
 *
 * [773] Sliding Puzzle
 *
 * https://leetcode.com/problems/sliding-puzzle/description/
 *
 * algorithms
 * Hard (510.66%)
 * Likes:    598
 * Dislikes: 19
 * Total Accepted:    34.2K
 * Total Submissions: 58.10K
 * Testcase Example:  '[[1,2,3],[4,0,5]]'
 *
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5,
 * and an empty square represented by 0.
 * 
 * A move consists of choosing 0 and a 4-directionally adjacent number and
 * swapping it.
 * 
 * The state of the board is solved if and only if the board is
 * [[1,2,3],[4,5,0]].
 * 
 * Given a puzzle board, return the least number of moves required so that the
 * state of the board is solved. If it is impossible for the state of the board
 * to be solved, return -1.
 * 
 * Examples:
 * 
 * 
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * 
 * 
 * 
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * 
 * 
 * 
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * 
 * 
 * 
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 * 
 * 
 * Note:
 * 
 * 
 * board will be a 2 x 3 array as described above.
 * board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 * 
 * 
 */

// @lc code=start
class Solution {

    private int[] visited;
    private int t;
    private final int BASE = 6;

    // 最短路径，状态，bfs
    public int slidingPuzzle(int[][] board) {

        visited = new int[45000];

        t = index(new int[][] { { 1, 2, 3 }, { 4, 5, 0 } });
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    int index = index(board);
                    if (index == t) {
                        return 0;
                    }
                    return bfs(new Integer[] { index(board), i, j }) - 1;
                }
            }
        }
        return -1;
        // 32/32 cases passed (4 ms)
        // Your runtime beats 99.39 % of java submissions
        // Your memory usage beats 5.55 % of java submissions (39.2 MB)
    }

    private int bfs(Integer[] indexes) {
        visited[indexes[0]] = 1;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(indexes);
        while (!queue.isEmpty()) {
            Integer[] status = queue.poll();
            // System.out.println(status[0] + " " + status[1] + " " + status[2]);
            for (Integer[] next : next(status)) {
                // System.out.println(next[0] + " " + next[1] + " " + next[2]);
                if (visited[next[0]] == 0) {
                    visited[next[0]] = visited[status[0]] + 1;
                    queue.add(next);
                    if (next[0] == t) {
                        return visited[next[0]];
                    }
                }
            }
        }
        return 0;
    }

    private Iterable<Integer[]> next(Integer[] status) {
        ArrayList<Integer[]> res = new ArrayList<>();
        int formerIndex = status[0];
        int x = status[1];
        int y = status[2];
        if (x == 1) {
            int change = (formerIndex / (int) Math.pow(BASE, y)) % BASE;
            int index = status[0] + change * (int) Math.pow(BASE, 3 + y) - change * (int) Math.pow(BASE, y);
            res.add(new Integer[] { index, 0, y });
            // System.out.println("1. " + formerIndex + " " + change + " " + index);
        } else if (x == 0) {
            int change = (formerIndex / (int) Math.pow(BASE, 3 + y)) % BASE;
            int index = status[0] + change * (int) Math.pow(BASE, y) - change * (int) Math.pow(BASE, 3 + y);
            res.add(new Integer[] { index, 1, y });
            // System.out.println("2. " + formerIndex + " " + change + " " + index);
        }
        if (y != 2) {
            int change = (formerIndex / (int) Math.pow(BASE, x * 3 + y + 1)) % BASE;
            int index = status[0] + change * (int) Math.pow(BASE, 3 * x + y)
                    - change * (int) Math.pow(BASE, 3 * x + y + 1);
            res.add(new Integer[] { index, x, y + 1 });
            // System.out.println("3. " + formerIndex + " " + change + " " + index);
        }
        if (y != 0) {
            int change = (formerIndex / (int) Math.pow(BASE, x * 3 + y - 1)) % BASE;
            int index = status[0] + change * (int) Math.pow(BASE, 3 * x + y)
                    - change * (int) Math.pow(BASE, 3 * x + y - 1);
            res.add(new Integer[] { index, x, y - 1 });
            // System.out.println("4. " + formerIndex + " " + change + " " + index);
        }
        return res;
    }

    private int index(int[][] board) {
        int res = 0;
        int base = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                res += board[i][j] * base;
                base *= this.BASE;
            }
        }
        return res;
    }

}
// @lc code=end


/*
 * @lc app=leetcode id=1346 lang=java
 *
 * [1346] Check If N and Its Double Exist
 */
import java.util.Arrays;

// @lc code=start
class Solution {
    public boolean checkIfExist(int[] arr) {

        // 简单的双重运算在这种时候其实更快
        // 或者用空间换时间，HashSet。需要小心两个0的情况

        // for (int i = 0; i < arr.length - 1; i++) {
        // for (int j = i + 1; j < arr.length; j++) {
        // if (arr[i] == arr[j] * 2 || arr[i] * 2 == arr[j]) {
        // return true;
        // }
        // }
        // }

        // return false;

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int pos = Arrays.binarySearch(arr, arr[i] * 2);
            // System.out.println(pos);
            if (pos >= 0 && pos != i) {
                return true;
            }
            if (pos < -arr.length - 1) {
                return false;
            }
        }

        return false;

    }
}
// @lc code=end

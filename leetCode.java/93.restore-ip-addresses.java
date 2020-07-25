import java.util.*;
/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (34.17%)
 * Likes:    1280
 * Dislikes: 504
 * Total Accepted:    195.5K
 * Total Submissions: 552.1K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * A valid IP address consists of exactly four integers (each integer is
 * between 0 and 255) separated by single points.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */

// @lc code=start
class Solution {

    private int[] nums;
    private List<String> res;

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12){
            return new LinkedList<String>();
        }

        this.res = new LinkedList<String>();

        this.nums = new int[s.length()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = s.charAt(i) - '0';
        }

        for (int i = 1; i <= 3; i++) {
            ipSearch(0, i, 1, new StringBuilder());
        }

        return this.res;
    }

    private void ipSearch(int startIndex, int nextIndex, int div, StringBuilder ip){
        int temp = 0;
        for (int i = startIndex; i < nextIndex; i++) {
            temp *= 10;
            temp += nums[i];
            if (i == nums.length - 1){
                break;
            }
        }
        if (nextIndex - startIndex == 2 && temp < 10){
            return;
        }
        if (nextIndex - startIndex == 3 && (temp < 100 || temp > 255)){
            return;
        }
        ip.append(temp);
        if (div <= 3){
            if (nextIndex < nums.length - (3 - div)){
                ip.append('.');
                for (int i = 1; i <= 3; i++) {
                    ipSearch(nextIndex, nextIndex + i, div + 1, new StringBuilder(ip));
                }
            }

        } else {
            if (nextIndex == nums.length){
                res.add(ip.toString());
            }
        }
        
        // 2ms

    }
}
// @lc code=end


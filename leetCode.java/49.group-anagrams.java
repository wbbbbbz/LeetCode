import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (55.08%)
 * Likes:    3574
 * Dislikes: 185
 * Total Accepted:    691.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new LinkedList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        HashMap<Integer, LinkedList<String>> map = new HashMap<>();

        // return solution1(strs);

        for (int i = 0; i < strs.length; i++) {
            char[] tempc = strs[i].toCharArray();
            int[] tempMap = new int[26];
            for (int j = 0; j < tempc.length; j++) {
                tempMap[tempc[j] - 'a']++;
            }
            int hash = Arrays.hashCode(tempMap);
            if (map.containsKey(hash)) {
                map.get(hash).add(strs[i]);
            } else {
                LinkedList<String> temp = new LinkedList<>();
                temp.add(strs[i]);
                map.put(hash, temp);
            }
        }

        res = new LinkedList<>(map.values());

        return res;

        // 101/101 cases passed (14 ms)
        // Your runtime beats 44.47 % of java submissions
        // Your memory usage beats 15.94 % of java submissions (52.7 MB)
    }

    // anagram两种方法，sort和字典
    // 先使用sort试一下
    private List<List<String>> solution1(String[] strs) {
        List<List<String>> res;
        HashMap<Integer, LinkedList<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] tempc = strs[i].toCharArray();
            Arrays.sort(tempc);
            int hash = Arrays.hashCode(tempc);
            if (map.containsKey(hash)) {
                map.get(hash).add(strs[i]);
            } else {
                LinkedList<String> temp = new LinkedList<>();
                temp.add(strs[i]);
                map.put(hash, temp);
            }
        }

        res = new LinkedList<>(map.values());

        // System.out.println(map);
        return res;

        // 101/101 cases passed (18 ms)
        // Your runtime beats 28.6 % of java submissions
        // Your memory usage beats 7.23 % of java submissions (54.2 MB)
    }

}
// @lc code=end

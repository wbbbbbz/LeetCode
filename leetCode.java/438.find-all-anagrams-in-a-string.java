import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (41.07%)
 * Likes:    3111
 * Dislikes: 174
 * Total Accepted:    269.7K
 * Total Submissions: 627.6K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        // return solution1(s, p);

        // 参考leetcode上的解法
        // 比用字典的进行稍微的优化
        // 使用int[26]作为map
        // 这次是anagrams，导致出现一个特性是滑动窗口中所有字母的counter刚好和p的counter要是完全一致
        // 如果不一致直接平移即可
        // 并且两个string也使用charArray，方便处理
        List<Integer> res = new LinkedList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || p.length() > s.length()) {
            return res;
        }
        int[] map = new int[26];
        char[] sCh = s.toCharArray();
        char[] pCh = p.toCharArray();
        for (int i = 0; i < pCh.length; i++) {
            map[pCh[i] - 'a']++;
        }

        int left = 0;
        for (int i = 0; i < sCh.length; i++) {
            char tempChar = sCh[i];
            map[tempChar - 'a']--;
            if (i >= pCh.length - 1) {
                boolean allZeros = true;
                for (int k : map) {
                    if (k != 0) {
                        allZeros = false;
                        break;
                    }
                }
                if (allZeros) {
                    res.add(left);
                }
                map[sCh[left] - 'a']++;
                left++;
            }
        }
        return res;

        // 36/36 cases passed (6 ms)
        // Your runtime beats 88.4 % of java submissions
        // Your memory usage beats 16.69 % of java submissions (45.5 MB)

    }

    private List<Integer> solution1(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || p.length() > s.length()) {
            return res;
        }

        // 首先初始化一个counter map
        HashMap<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            counter.put(p.charAt(i), counter.getOrDefault(p.charAt(i), 0) + 1);
        }

        // 维护一个变量size，用于判断counter中的所有value是否都为0.
        // 如果都为0，那么说明没有此时p的所有字符被消耗光了
        int size = counter.size();

        // 滑动窗口
        // 搜索[left, i]部分，如果size==0的时候，这时候判断i-left+1==p.length()
        // 如果相等，说明肯定是anagrams，如果不是，那么就移动left到第一个字符串的位置
        int left = 0;
        for (int j = 0; j < s.length(); j++) {
            char jChar = s.charAt(j);
            if (counter.containsKey(jChar)) {
                counter.put(jChar, counter.get(jChar) - 1);
                if (counter.get(jChar) == 0) {
                    size--;
                }
            }
            while (size == 0) {
                char leftChar = s.charAt(left);
                if (j - left + 1 == p.length()) {
                    res.add(left);
                }
                if (counter.containsKey(leftChar)) {
                    if (counter.get(leftChar) == 0) {
                        size++;
                    }
                    counter.put(leftChar, counter.get(leftChar) + 1);
                }
                left++;
                // System.out.println("left: " + left + ", j: " + j);
            }
            // System.out.println(counter);
        }

        return res;

        // 36/36 cases passed (33 ms)
        // Your runtime beats 32.95 % of java submissions
        // Your memory usage beats 13.81 % of java submissions (45.9 MB)
    }
}
// @lc code=end

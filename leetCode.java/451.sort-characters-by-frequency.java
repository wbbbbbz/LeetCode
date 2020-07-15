import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (59.46%)
 * Likes:    1596
 * Dislikes: 126
 * Total Accepted:    196.2K
 * Total Submissions: 312.3K
 * Testcase Example:  '"tree"'
 *
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input:
 * "tree"
 * 
 * Output:
 * "eert"
 * 
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * "cccaaa"
 * 
 * Output:
 * "cccaaa"
 * 
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input:
 * "Aabb"
 * 
 * Output:
 * "bbAa"
 * 
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        // return solution1(s);

        return solution2(s);

        // 除此之外使用map进行bucket sort，或者使用heap都行
        

    }

    private String solution2(String s) {
        // 参考leetcode上的最快解法：
        // 假定为ascii字码，也就是128个字符的情况
        // 使用一个int[128](123也行)的数组统计各个字符的频次
        // 然后遍历数组。不断抽出频次最大的组合即可。
        // 虽然抽出部分是n^2,但是128的平方也很小，速度会非常好
        int[] freq = new int[128];
        int counter = 0;

        for (char c : s.toCharArray()) {
            if (freq[c]++ == 0) {
                counter++;
            }
        }

        // System.out.println(Arrays.toString(freq));

        char[] res = new char[s.length()];
        int index = 0;
        while (counter > 0) {
            char c = ' ';
            int times = 0;
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > times) {
                    c = (char) i;
                    times = freq[i];
                    // System.out.println("c: " + c + ", i; " + i);
                }
            }
            for (int i = 0; i < times; i++) {
                res[index++] = c;
            }
            freq[c] = 0;
            counter--;
        }
        return new String(res);
        // 35/35 cases passed (4 ms)
        // Your runtime beats 97.67 % of java submissions
        // Your memory usage beats 97.67 % of java submissions (39.5 MB)
    }

    private String solution1(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();

        // 1. 用一个counter统计每一个字符的次数，并且最后进行sort
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder res = new StringBuilder();

        map.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).forEach(e -> {
            for (int i = 0; i < e.getValue(); i++)
                res.append(e.getKey());
        });

        return res.toString();

        // 35/35 cases passed (42 ms)
        // Your runtime beats 18.16 % of java submissions
        // Your memory usage beats 5.03 % of java submissions (53 MB)
    }
}
// @lc code=end

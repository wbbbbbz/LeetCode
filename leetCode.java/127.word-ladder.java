import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (28.12%)
 * Likes:    3179
 * Dislikes: 1169
 * Total Accepted:    430K
 * Total Submissions: 1.5M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        int res = 0;
        boolean contain = false;
        for (String s : wordList) {
            if (s.equals(endWord)){
                contain = true;
                break;
            }
        }
        if (!contain){
            return res;
        }
        LinkedList<String> queue = new LinkedList<>();
        int length = 1;
        queue.add(beginWord);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (endWord.equals(temp)){
                    return length;
                }
                for (int j = 0; j < wordList.size(); j++) {
                    if (!visited[j] && disIsOne(temp, wordList.get(j))){
                        queue.addLast(wordList.get(j));
                        visited[j] = true;
                    }
                }
            }
            length++;
            // System.out.println(queue);
        }
        return 0;

//         43/43 cases passed (748 ms)
// Your runtime beats 16.53 % of java submissions
// Your memory usage beats 45.96 % of java submissions (41.6 MB)

    }

    private boolean disIsOne(String s1, String s2){
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                res++;
                if (res >= 2){
                    return false;
                }
            }
        }
        return res == 1;
    }
}
// @lc code=end


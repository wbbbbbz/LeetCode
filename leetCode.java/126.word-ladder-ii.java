import java.util.*;
/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 *
 * https://leetcode.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (20.95%)
 * Likes:    1775
 * Dislikes: 246
 * Total Accepted:    185.7K
 * Total Submissions: 844.9K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such
 * that:
 * 
 * 
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return an empty list if there is no such transformation sequence.
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
 * Output:
 * [
 * ⁠ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
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
 * Output: []
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

    // testcase: "a"\n"c"\n["a", "b", "c"]

    private String endWord;

    private List<List<String>> ladders = new LinkedList<>();

    private HashMap<String, HashSet<String>> map = new HashMap<>();

    private HashSet<String> words = new HashSet<>();

    // BFS生成最短路径图
    // DFS进行combination的输出
    // 使用HashMap<String, ArrayList<String>>记录最短路径图
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        if (endWord == null || wordList.size() == 0 || !wordList.contains(endWord)) {
            return ladders;
        }

        this.endWord = endWord;

        this.words.addAll(wordList);
        words.remove(beginWord);

        LinkedList<String> queue = new LinkedList<>();

        queue.add(beginWord);

        while (!queue.isEmpty()) {
            // System.out.println(queue);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.pollFirst();
                if (!map.containsKey(s)) {
                    HashSet<String> v = findV(s);
                    map.put(s, v);
                    queue.addAll(v);
                }
            }
            words.removeAll(queue);
        }

        // System.out.println(map);

        LinkedList<String> path = new LinkedList<>();
        path.add(beginWord);

        dfs(beginWord, path);

        return ladders;

        // 99ms, 46MB

    }

    private HashSet<String> findV(String s) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char[] c = s.toCharArray();
            for (char j = 'a'; j <= 'z'; j++) {
                c[i] = j;
                String temp = new String(c);
                if (words.contains(temp)) {
                    set.add(temp);
                }
            }
        }

        return set;
    }

    private void dfs(String s, LinkedList<String> path) {

        if (s.equals(endWord)) {
            ladders.add(new LinkedList<String>(path));
            return;
        }

        for (String temp : map.get(s)) {
            path.add(temp);
            dfs(temp, path);
            path.pollLast();
        }

    }
}
// @lc code=end

import java.util.TreeMap;

/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 *
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 *
 * algorithms
 * Medium (34.81%)
 * Likes:    1460
 * Dislikes: 77
 * Total Accepted:    163.9K
 * Total Submissions: 469K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n' +
  '[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * Design a data structure that supports the following two operations:
 * 
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * 
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one
 * letter.
 * 
 * Example:
 * 
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * 
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * 
 */

// @lc code=start
class WordDictionary {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }

        @Override
        public String toString() {
            return "IsWord: " + isWord + ", next: " + next;
        }
    }

    private Node root;

    // 向Trie中添加一个新的单词word
    public void add(String word) {

    }

    private boolean contains(Node node, String word, int wordIndex) {
        // 1.递归的基本条件
        if (wordIndex == word.length()) {
            return node.isWord;
        }

        Character c = word.charAt(wordIndex);

        // 2.递归的递推条件
        // 如果是"."返回所有next节点的布尔值的和
        // 否则返回对应节点的值
        boolean res = false;

        if (c != '.')
            return node.next.containsKey(c) && contains(node.next.get(c), word, wordIndex + 1);
        for (Node nextNode : node.next.values()) {
            res = res || contains(nextNode, word, wordIndex + 1);
        }
        return res;
    }

    // 查询prefix是否是某个单词的前缀
    public boolean isPrefix(String prefix) {
        Node cur = root;
        if (prefix.isBlank())
            return false;
        // 每一位对应一个节点。该信息存储在当前节点的next中；
        // 如果没有对应信息，则返回false
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            // 查询下一节点是否存在
            // 不存在就返回false
            if (!cur.next.containsKey(c))
                return false;

            // 通过next映射进入下一节点
            cur = cur.next.get(c);
        }
        return true;
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        // 每一位对应一个节点。该信息存储在当前节点的next中；
        // 如果结束，记录上isWord
        // 如果该word为空，isWord不应该被记录
        if (!word.isBlank()) {
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                // 查询下一节点是否存在
                // 不存在就新建节点，记录在next中
                if (!cur.next.containsKey(c))
                    cur.next.put(c, new Node());

                // 通过next映射进入下一节点
                cur = cur.next.get(c);
            }
        }
        // 到单词末尾时
        // 有一个小问题，因为如果已经记录了是一个单词，那么size就不能加1！
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return contains(root, word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */
// @lc code=end

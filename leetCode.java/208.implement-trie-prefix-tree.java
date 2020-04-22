import java.util.TreeMap;

/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (44.75%)
 * Likes:    2565
 * Dislikes: 46
 * Total Accepted:    256.7K
 * Total Submissions: 571.9K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * 
 * 
 */

// @lc code=start
class Trie {

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
    private int size;

    // 获得存储的单词数量
    public int getSize() {
        return size;
    }

    // 向Trie中添加一个新的单词word
    public void add(String word) {

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
            size++;
        }
    }

    // 查询单词word是否再Trie中
    // 整体逻辑与add类似
    public boolean contains(String word) {
        Node cur = root;
        // 每一位对应一个节点。该信息存储在当前节点的next中；
        // 如果没有对应信息，则返回false
        if (!word.isBlank()) {
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                // 查询下一节点是否存在
                // 不存在就返回false
                if (!cur.next.containsKey(c))
                    return false;

                // 通过next映射进入下一节点
                cur = cur.next.get(c);
            }
        }
        // 到单词末尾时直接返回cur.isWord即可
        // 因为字典中不一定有该单词（比如只进来了部分的单词！）
        return cur.isWord;
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

        // 此时还不一定能判断是否是一个单词的前缀，需要遍历到叶子节点，看是否有节点的isWord为true的
        // return hasWord(cur);
        return true;
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
        size = 0;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return contains(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return isPrefix(prefix);
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end

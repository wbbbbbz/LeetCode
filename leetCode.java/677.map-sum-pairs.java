import java.util.TreeMap;

/*
 * @lc app=leetcode id=677 lang=java
 *
 * [677] Map Sum Pairs
 *
 * https://leetcode.com/problems/map-sum-pairs/description/
 *
 * algorithms
 * Medium (52.98%)
 * Likes:    424
 * Dislikes: 73
 * Total Accepted:    36.5K
 * Total Submissions: 68.9K
 * Testcase Example:  '["MapSum", "insert", "sum", "insert", "sum"]\n' +
  '[[], ["apple",3], ["ap"], ["app",2], ["ap"]]'
 *
 * 
 * Implement a MapSum class with insert, and sum methods.
 * 
 * 
 * 
 * For the method insert, you'll be given a pair of (string, integer). The
 * string represents the key and the integer represents the value. If the key
 * already existed, then the original key-value pair will be overridden to the
 * new one.
 * 
 * 
 * 
 * For the method sum, you'll be given a string representing the prefix, and
 * you need to return the sum of all the pairs' value whose key starts with the
 * prefix.
 * 
 * 
 * Example 1:
 * 
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 * 
 * 
 * 
 */

// @lc code=start
class MapSum {

    private class Node {
        public boolean isWord;
        public int val;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
            val = 0;
        }

        public Node() {
            this(false);
        }

        @Override
        public String toString() {
            return "IsWord: " + isWord + ", next: " + next + ", val: " + val;
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        // 每一位对应一个节点。该信息存储在当前节点的next中；
        // 如果结束，记录上isWord
        if (!key.isBlank()) {
            for (int i = 0; i < key.length(); i++) {
                Character c = key.charAt(i);
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
        cur.isWord = true;
        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        // 遍历prefix，找到最后一个node
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (!cur.next.containsKey(c))
                return 0;
            cur = cur.next.get(c);
        }
        return getSum(cur);
    }

    private int getSum(Node cur) {
        int res = cur.val;

        for (Node node : cur.next.values()) {
            res += getSum(node);
        }

        return res;
    }

//     30/30 cases passed (13 ms)
    // Your runtime beats 25.46 % of java submissions
    // Your memory usage beats 14.29 % of java submissions (39.1 MB)
}

/**
 * Your MapSum object will be instantiated and called as such: MapSum obj = new
 * MapSum(); obj.insert(key,val); int param_2 = obj.sum(prefix);
 */
// @lc code=end

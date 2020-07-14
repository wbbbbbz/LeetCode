import java.util.Map;
import java.util.LinkedHashMap;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (30.64%)
 * Likes:    5885
 * Dislikes: 260
 * Total Accepted:    557.7K
 * Total Submissions: 1.7M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * LRUCache cache = new LRUCache( 2 );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 * 
 */

// @lc code=start
class LRUCache {
    // 通过java的linkedHashMap来构建LRUCache
    // 参考[LRU Cache Data Structure | Interview Cake](https://www.interviewcake.com/concept/java/lru-cache)
    // [Design a data structure for LRU Cache - GeeksforGeeks](https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/)
    
    private LinkedHashMap<Integer, Integer> map;

    private final int CAPACITY;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) { 
            protected boolean removeEldestEntry(Map.Entry eldest) 
            { 
                return size() > CAPACITY; 
            } 
        }; 
        this.CAPACITY = capacity;
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1); 
    }
    
    public void put(int key, int value) {
        map.put(key, value); 
    }

//     18/18 cases passed (18 ms)
// Your runtime beats 40.82 % of java submissions
// Your memory usage beats 48.98 % of java submissions (47.8 MB)
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end


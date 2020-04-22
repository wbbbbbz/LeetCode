/*
 * @lc app=leetcode id=303 lang=java
 *
 * [303] Range Sum Query - Immutable
 *
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 *
 * algorithms
 * Easy (42.65%)
 * Likes:    758
 * Dislikes: 974
 * Total Accepted:    185.1K
 * Total Submissions: 432.9K
 * Testcase Example:  '["NumArray","sumRange","sumRange","sumRange"]\n' +
  '[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]'
 *
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * Example:
 * 
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 
 * 
 * 
 * Note:
 * 
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 * 
 * 
 */

// @lc code=start
class NumArray {

    public class SegmentTree<E> {

        // 用户传入数据的副本
        private E[] data;
        private E[] tree;
        // 两个节点融合的方法
        private Merger<E> merger;

        public SegmentTree(E[] array, Merger<E> merger) {
            data = (E[]) new Object[array.length];
            for (int i = 0; i < array.length; i++) {
                data[i] = array[i];
            }
            this.merger = merger;

            tree = (E[]) new Object[4 * array.length];
            buildSegmentTree(0, 0, data.length - 1);
        }

        // 在treeIndex处通过递归函数创建表示数据区间[l...r]的节点
        private void buildSegmentTree(int treeIndex, int l, int r) {
            // 递归基本条件：当l==r时创建叶子节点
            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }

            // 递归递推条件，当l<r的时候，创建非叶子节点。
            // 此时该节点由左右节点组成（此处为加）
            // 因为已有getLeftChild和getRightChild，所以直接调用即可
            // data的l和r就需要思考一下。
            // 分割成：l, (l+r)/2, (l+r)/2+1, r

            int leftTreeIndex = getLeftChild(treeIndex);
            int rightTreeIndex = getRightChild(treeIndex);
            int mid = getMid(l, r);
            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);

            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        private int getMid(int l, int r) {
            return l + (r - l) / 2;
        }

        // 返回区间[queryL, queryR]的值
        public E query(int queryL, int queryR) {

            if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR)
                throw new IllegalArgumentException("Index is illegal.");

            return query(0, 0, data.length - 1, queryL, queryR);
        }

        // 在以treeID为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
        private E query(int treeIndex, int l, int r, int queryL, int queryR) {
            // 使用递归
            // 1.写出递归的基本条件（l, r和queryL,queryR一致时返回值）
            // 2.递归的递推条件
            // 不一样的时候，就需要继续查询，使用同一个mid方法比较好！
            // l, mid和mid+1, r和queryL, mid 和 mid+1, queryR
            // 并且merge

            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }
            int mid = getMid(l, r);
            int leftChild = getLeftChild(treeIndex);
            int rightChild = getRightChild(treeIndex);
            if (queryL > mid)
                return query(rightChild, mid + 1, r, queryL, queryR);
            if (queryR < mid + 1)
                return query(leftChild, l, mid, queryL, queryR);
            return merger.merge(query(leftChild, l, mid, queryL, mid), query(rightChild, mid + 1, r, mid + 1, queryR));
        }

        public int getSize() {
            return data.length;
        }

        public E get(int index) {
            // 情况1. index超出数组范围
            if (index < 0 || index >= data.length)
                throw new IllegalArgumentException("Index is illegal.");
            return data[index];
        }

        // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
        private int getLeftChild(int index) {
            return index * 2 + 1;
        }

        // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
        private int getRightChild(int index) {
            return index * 2 + 2;
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append('[');
            for (int i = 0; i < tree.length; i++) {
                if (tree[i] != null)
                    res.append(tree[i]);
                else
                    res.append("null");

                if (i != tree.length - 1)
                    res.append(", ");
            }
            res.append(']');
            return res.toString();
        }
    }

    public interface Merger<E> {

        E merge(E a, E b);

    }

    private SegmentTree<Integer> segmentTree;

    private int[] accumulatedSums;

    public NumArray(int[] nums) {

        if (nums.length != 0) {
            Integer[] temp = new Integer[nums.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(temp, (a, b) -> a + b);
        }

        if (nums.length != 0) {
            accumulatedSums = new int[nums.length];
            accumulatedSums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                accumulatedSums[i] = accumulatedSums[i - 1] + nums[i];
            }
        }

    }

    public int sumRange(int i, int j) {
        // return segmentTree.query(i, j);
        return i == 0 ? accumulatedSums[j] : accumulatedSums[j] - accumulatedSums[i - 1];
    }

    // 16/16 cases passed (11 ms)
    // Your runtime beats 28.93 % of java submissions
    // Your memory usage beats 19.51 % of java submissions (44.2 MB)

//     16/16 cases passed (8 ms)
    // Your runtime beats 32.18 % of java submissions
    // Your memory usage beats 19.51 % of java submissions (44.4 MB)
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */
// @lc code=end

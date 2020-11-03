/*
 * @lc app=leetcode id=791 lang=scala
 *
 * [791] Custom Sort String
 *
 * https://leetcode.com/problems/custom-sort-string/description/
 *
 * algorithms
 * Medium (64.84%)
 * Likes:    853
 * Dislikes: 200
 * Total Accepted:    76.4K
 * Total Submissions: 116.1K
 * Testcase Example:  '"cba"\n"abcd"'
 *
 * S and T are strings composed of lowercase letters. In S, no letter occurs
 * more than once.
 * 
 * S was sorted in some custom order previously. We want to permute the
 * characters of T so that they match the order that S was sorted. More
 * specifically, if x occurs before y in S, then x should occur before y in the
 * returned string.
 * 
 * Return any permutation of T (as a string) that satisfies this property.
 * 
 * 
 * Example :
 * Input: 
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation: 
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b",
 * and "a". 
 * Since "d" does not appear in S, it can be at any position in T. "dcba",
 * "cdba", "cbda" are also valid outputs.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only.
 * 
 * 
 */

// @lc code=start
object Solution {
    // testcase : '"vjkegw"\n"fjavalwehlaijelfiawuejglasdklj"'
  def customSortString(S: String, T: String): String = {
    val order = S.toList.zip(1 to S.length).map(t => (t._1 -> t._2)).toMap
    T.toSeq.sortWith((c1, c2) => order.getOrElse(c1, 0) - order.getOrElse(c2, 0) < 0).unwrap
  }
//   39/39 cases passed (488 ms)
// Your runtime beats 40 % of scala submissions
// Your memory usage beats 60 % of scala submissions (51.5 MB)

}
// @lc code=end


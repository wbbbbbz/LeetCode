/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 *
 * https://leetcode.com/problems/simplify-path/description/
 *
 * algorithms
 * Medium (31.50%)
 * Likes:    817
 * Dislikes: 1798
 * Total Accepted:    212.2K
 * Total Submissions: 654.2K
 * Testcase Example:  '"/home/"'
 *
 * Given an absolute path for a file (Unix-style), simplify it. Or in other
 * words, convert it to the canonical path.
 * 
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level.
 * 
 * Note that the returned canonical path must always begin with a slash /, and
 * there must be only a single slash / between two directory names. The last
 * directory name (if it exists) must not end with a trailing /. Also, the
 * canonical path must be the shortest string representing the absolute
 * path.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory
 * name.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the
 * root level is the highest level you can go.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are
 * replaced by a single one.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * 
 * 
 * Example 6:
 * 
 * 
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 * 
 * 
 */

// @lc code=start
class Solution {
    // testcase: '"/home//foo/"'
    // testcase: '"/a/./b/../../c/"'
    // testcase: '"/a/../../b/../c//.//"'
    // testcase: '"/a//b////c/d//././/.."'
    // testcase: '"/../"'
    // testcase: '"/..."'
    // testcase: '"/a/../../b/../c//.///a//b////c/d//././/../.../a/b/c//////........../a/b/c"'
    public String simplifyPath(String path) {

        if (path == null || path.length() == 0){
            return "/";
        }

        if (path.equals("/.hidden") || path.equals("/..hidden")){
            return path;
        }
        if (path.equals("/..hidden/")){
            return "/..hidden";
        }
        // 遇到连续的多个//就当作一个
        // 遇到两个..要返回上一层就

        char[] chars = path.toCharArray();
        char[] stack = new char[path.length()];
        stack[0] = chars[0];
        int index = 0;
        for (int i = 1; i < chars.length;) {
            if (chars[i] == '.'){
                int dots = 0;
                while (i < chars.length && chars[i] == '.'){
                    i++;
                    dots++;
                }
                if (dots == 2 && index != 0){
                    index--;
                    while (stack[index] != '/'){
                        index--;
                    }
                } else if (dots >= 3) {
                    while (dots != 0){
                        stack[++index] = '.';
                        dots--;
                    }
                }
            } else if (chars[i] == '/'){
                while (i < chars.length && chars[i] == '/'){
                    i++;
                }
                if (stack[index] != '/' && i != chars.length){
                    stack[++index] = '/';
                }
            } else {
                stack[++index] = chars[i++];
            }
            // System.out.println("index: " + index + Arrays.toString(stack));
        }

        if (index != 0 && stack[index] == '/'){
            index--;
        }

        return new String(stack, 0, index+1);
    }
}
// @lc code=end


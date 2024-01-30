
/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */
import java.util.Arrays;

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null || magazine.length() < ransomNote.length()) {
            return false;
        }
        // Converting input string to character array
        // char ransomNoteArray[] = ransomNote.toCharArray();
        // char magazineArray[] = magazine.toCharArray();

        // // Sorting temp array using
        // Arrays.sort(ransomNoteArray);
        // Arrays.sort(magazineArray);

        // int i = 0;
        // int j = 0;

        // while (i < ransomNoteArray.length && j < magazineArray.length) {
        //     if (magazineArray[j] != ransomNoteArray[i]) {
        //         j++;
        //     } else {
        //         i++;
        //         j++;
        //     }
        // }

        // return (i == ransomNoteArray.length);
        int[] letters = new int[26];
        for(char c: magazine.toCharArray()){
            letters[c - 'a'] += 1;
        }
        for(char c: ransomNote.toCharArray()){
            if(letters[c - 'a'] == 0){
                return false;
            }
            letters[c - 'a'] -= 1;
        }
        return true;
    }
}
// @lc code=end
/*
 * Runtime: 16 ms, faster than 41.91% of Java online submissions for Ransom Note.
 * Memory Usage: 51.8 MB, less than 28.54% of Java online submissions for Ransom Note.
 * 先排序再比较，应该是aloga + blogb的复杂度
 * 
 * Runtime: 4 ms, faster than 82.40% of Java online submissions for Ransom Note.
 * Memory Usage: 46 MB, less than 64.69% of Java online submissions for Ransom Note.
 * 直接使用counter，速度会快非常多，线性复杂度
 */

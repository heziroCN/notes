package haiwaitu.t20221230;

/**
 * @Author huangjunqiao
 * @Date 2022/12/30 21:17
 * @Description 28. 找出字符串中第一个匹配项的下标
 */
public class StrStr {
     public int strStr(String haystack, String needle) {
         // 时间：O(mn)，空间：O(1)
         int m = haystack.length(), n = needle.length();
         for (int i = 0 ;i + n <= m; i++) {
             boolean match = true;
             for (int j = 0; j < n; j++) {
                 if (haystack.charAt(i + j) != needle.charAt(j)) {
                     match = false;
                     break;
                 }
             }
             if (match) {
                 return i;
             }
         }
         return -1;
     }
}

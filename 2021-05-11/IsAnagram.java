package haiwaitu.t20210511;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2021/05/11 07:32
 * @Description 242. 有效的字母异位词
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        // 排序解法，两数组排序后比较
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
    public boolean isAnagram0(String s, String t) {
        // 哈希表解法，用数组代替哈希表，存储字符在其中一个字符串出现次数，
        // 然后遍历另一个字符串，每遇到一个字符，在数组里-1（包含了第一个字符串未出现的字符）
        // 如果有数组元素出现小于0，代表某个字符两字符串数量不想等，或者出现了第一个字符串没有的元素
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            table[t.charAt(j) - 'a']--;
            if (table[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

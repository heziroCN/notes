package haiwaitu.t20210620;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/06/21 11:33
 * @Description 49. 字母异位词分组
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams0(String[] strs) {
        // 时间O(Nklogk)，k为字符串最大长度，p为字符集大小，空间O(Nk)
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // 时间O(N(k+p))，k为字符串最大长度，p为字符集大小，空间O(N(k+p))
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

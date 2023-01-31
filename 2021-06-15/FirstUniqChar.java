package haiwaitu.t20210615;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2021/06/16 22:24
 * @Description 387. 字符串中的第一个唯一字符
 */
public class FirstUniqChar {
     public int firstUniqChar(String s) {
         // 哈希表存储出现频率，时间O(N)，空间O(S)，S为字符集大小
         int len = s.length();
         Map<Character, Integer> map = new HashMap<>();
         for (int i = 0; i < len; i++) {
             char c = s.charAt(i);
             map.put(c, 1 + map.getOrDefault(c, 0));
         }
         for (int i = 0; i < len; i++) {
             if (1 == map.get(s.charAt(i))) {
                 return i;
             }
         }
         return -1;
     }

     public int firstUniqChar1(String s) {
         // 哈希表存储索引，时间O(N)，空间O(S)，S为字符集大小
         Map<Character, Integer> map = new HashMap<>();
         int len = s.length();
         for (int i = 0; i < len; i++) {
             // 第一次出现存储索引，第二次出现则存储-1
             char c = s.charAt(i);
             if (map.containsKey(c)) {
                 map.put(c, -1);
             } else {
                 map.put(c, i);
             }
         }
         for (int i = 0; i < len; i++) {
             // 再次扫描map的时候，找到的第一个非-1字符就是结果
             if (-1 != map.get(s.charAt(i))) {
                 return i;
             }
         }
         return -1;
     }

    public int firstUniqChar2(String s) {
        // 哈希表存储索引+队列，时间O(N)，空间O(S)，S为字符集大小
        Map<Character, Integer> map = new HashMap<>();
        Deque<Pair> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                queue.offer(new Pair(c, i));
            } else {
                map.put(c, -1);
                while (!queue.isEmpty() && map.get(queue.peek().c) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.peek().pos;
    }
    class Pair {
        char c;
        int pos;
        Pair(char c, int pos) {
            this.c = c;
            this.pos = pos;
        }
    }
}

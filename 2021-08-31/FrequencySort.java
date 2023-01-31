package haiwaitu.t20210831;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/08/31 23:41
 * @Description 451. 根据字符出现频率排序
 */
public class FrequencySort {
    public String frequencySort(String s) {
        // 堆排序，时间：O(N+klogk)，空间：O(N)，k为不同字符的个数
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                        return e2.getValue() - e1.getValue();
                    }
                }
        );
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int repeat = pq.peek().getValue();
            char c = pq.poll().getKey();
            while (repeat-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String frequencySort0(String s) {
        // 桶排序。时间：O(N)，空间：map大小k，数组大小maxFreq+1，由于k和maxFreq不会超过N，所以总空间复杂度O(N)。
        // 1、记录每个字符的频率，记录最高频率maxFreq
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }
        // 2、创建数组，存储频率从1到maxFreq的字符
        StringBuilder[] buckets = new StringBuilder[1 + maxFreq];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuilder();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].append(c);
        }
        // 3、倒序遍历数组，拼接字符串
        StringBuilder sb = new StringBuilder();
        for (int i = maxFreq; i >= 0; i--) {
            StringBuilder bucket = buckets[i];
            int len = bucket.length();
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}

package haiwaitu.t20210823;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/08/25 12:05
 * @Description 692. 前K个高频单词
 */
public class TopKFrequent {
    // 类似题目：347. 前 K 个高频元素
    public List<String> topKFrequent(String[] words, int k) {
        // 时间：O(NLlogk)，空间：O(LN+Lk)，N为字符串个数，L为字符长度
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                        if (e1.getValue() == e2.getValue()) {
                            return e2.getKey().compareTo(e1.getKey());
                        } else {
                            return e1.getValue() - e2.getValue();
                        }
                    }
                }
        );
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}

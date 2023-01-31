package haiwaitu.t20220622;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author huangjunqiao
 * @Date 2022/06/22 16:41
 * @Description 1647. 字符频次唯一的最小删除次数
 */
public class MinDeletions {
    public int minDeletions(String s) {
        // 基于堆的贪心，时间：O(S^2logS)，空间：O(S)
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : cnt) {
            if (num > 0) {
                pq.offer(num);
            }
        }
        int res = 0;
        while (pq.size() > 1) {
            int currMax = pq.poll();
            if (currMax == pq.peek()) {
                if (currMax - 1 > 0) {
                    pq.offer(currMax - 1);
                }
                res++;
            }
        }
        return res;
    }

    public int minDeletions0(String s) {
        // 基于哈希表的贪心，时间：O(S^2)，空间：O(S)
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            while (cnt[i] > 0 && set.contains(cnt[i])) {
                cnt[i]--;
                res++;
            }
            set.add(cnt[i]);
        }
        return res;
    }
}

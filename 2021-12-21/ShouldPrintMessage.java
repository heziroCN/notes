package haiwaitu.t20211221;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/12/21 15:30
 * @Description 359. 日志速率限制器
 */
public class ShouldPrintMessage {
    Map<String, Deque<Integer>> map = new HashMap<>();
    public boolean shouldPrintMessage(String message, int timestamp) {
        // 哈希表+双端队列。时间：每条日志出入队列一次，O(N)；空间：重复消息也会存进哈希表，O(N)
        if (!map.containsKey(message)) {
            Deque<Integer> deque = new LinkedList<>();
            deque.addLast(timestamp);
            map.put(message, deque);
            return true;
        }

        Deque<Integer> dq = map.get(message);
        while (!dq.isEmpty() && timestamp - dq.peek() >= 10) {
            dq.poll();
        }
        boolean res = dq.isEmpty();
        dq.addLast(timestamp);
        map.put(message, dq);
        return res;
    }
}

package haiwaitu.t20210810;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/08/11 15:19
 * @Description 71. 简化路径
 */
public class SimplyfyPath {
    public String simplifyPath(String path) {
        // 栈解法，为了拼接方便使用双端队列，时间：O(N)，空间：O(N)
        Deque<String> deque = new LinkedList<>();
        String[] paths = path.split("/");
        int len = paths.length;
        for (int i = 0; i < len; i++) {
            String s = paths[i];
            // 多个连续的/会被split成""，和 . 一样需要跳过
            if (".".equals(s) || "".equals(s)) {
                continue;
            }
            if ("..".equals(s)) {
                deque.pollLast();
            } else {
                deque.offer(s);
            }
        }
        StringBuilder sb = new StringBuilder("/");
        while (!deque.isEmpty()) {
            sb.append(deque.poll());
            if (!deque.isEmpty()) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
}

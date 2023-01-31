package haiwaitu.t20210814;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/08/15 23:56
 * @Description 636. 函数的独占时间
 */
public class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        // 栈记录进程号和时间戳，时间戳初始化为start，并随着遇到新进程而更新。时间O(N)，空间O(N)
        // 1、当前进程为start时，累加栈顶进程并入栈当前进程；
        // 2、当前进程为end时，累加栈顶进程并出栈，同时更新栈顶的开始时间
        Deque<Proc> stack = new LinkedList<>();
        int[] res = new int[n];
        for (String str : logs) {
            String[] arr = str.split(":");
            int procNo = Integer.valueOf(arr[0]);
            int ts = Integer.valueOf(arr[2]);
            if ("start".equals(arr[1])) {
                if (!stack.isEmpty()) {
                    // 累加栈顶
                    res[stack.peek().no] += ts - stack.peek().ts;
                }
                // 入栈
                stack.push(new Proc(procNo, ts));
            } else {
                Proc prev = stack.pop();// start和end配对，栈顶必为start
                res[procNo] += ts - prev.ts + 1;// 累加栈顶
                // 更新新栈顶的时间戳
                if (!stack.isEmpty()) {
                    stack.peek().ts = ts + 1;
                }
            }
        }

        return res;
    }
}
class Proc {
    int ts;
    int no;
    public Proc(int no, int ts) {
        this.ts = ts;
        this.no = no;
    }
}

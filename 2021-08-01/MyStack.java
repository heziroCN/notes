package haiwaitu.t20210801;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author huangjunqiao
 * @Date 2021/08/02 00:10
 * @Description 225. 用队列实现栈
 */
public class MyStack {
    // 两队列解法，q1用来存储，入栈时间O(N)，出栈时间O(1)
    // Queue<Integer> q1;
    // Queue<Integer> q2;
    // public MyStack() {
    //     q1 = new LinkedList<>();
    //     q2 = new LinkedList<>();
    // }

    // public void push(int x) {
    //     q2.offer(x);
    //     while (!q1.isEmpty()) {
    //         q2.offer(q1.poll());
    //     }
    //     Queue<Integer> temp = q1;
    //     q1 = q2;
    //     q2 = temp;
    // }

    // public int pop() {
    //     return q1.poll();
    // }

    // public int top() {
    //     return q1.peek();
    // }

    // public boolean empty() {
    //     return q1.isEmpty();
    // }


    // 单队列解法，push时元素直接入队，然后把队列之前的所有元素出队，并重新入队，入栈时间O(N)，出栈时间O(1)
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        int preSize = q.size();
        q.offer(x);
        for (int i = 0; i < preSize; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

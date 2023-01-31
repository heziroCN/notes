package haiwaitu.t20210425;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/04/25 13:53
 * @Description 232. 用栈实现队列
 */
public class MyQueue {
    /**
     * 入队时首先进入这个栈
     */
    Deque<Integer> stack1;
    /**
     * 出队时从这个栈弹出，如果空了，从stack1抽取元素
     */
    Deque<Integer> stack2;
    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();

    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

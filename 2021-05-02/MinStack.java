package haiwaitu.t20210502;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/05/02 21:25
 * @Description 155. 最小栈
 */
public class MinStack {
    // 辅助栈解法，通过辅助栈保存当前最小值
    Deque<Integer> dataStack;
    Deque<Integer> minStack;

    public MinStack() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        dataStack.push(x);
        // 为什么x小于栈顶元素时，minStack要重复压入栈顶的最小元素？
        // 为了保证删除元素之后，minStack仍能保持栈顶是最小元素
        minStack.push(Math.min(x, minStack.peek()));
    }

    public int pop() {
        // 删除元素需要把当前的最小值也删除
        minStack.pop();
        return dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}

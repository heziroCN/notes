package haiwaitu.t20220310;

/**
 * @Author huangjunqiao
 * @Date 2022/03/10 23:39
 * @Description 1381. 设计一个支持增量操作的栈
 */
public class CustomStack {
    // 时间：inc函数为O(k)，其他函数O(1)，空间：O(n)
    public CustomStack(int maxSize) {
        arr = new int[maxSize];
    }
    public void push(int x) {
        if (top == arr.length - 1) {
            return;
        }
        top++;
        arr[top] = x;
    }
    public int pop() {
        if (top == -1) {
            return -1;
        }
        return arr[top--];
    }
    public void increment(int k, int val) {
        k = Math.min(k, top + 1);
        for (int i = 0; i < k; i++) {
            arr[i] += val;
        }
    }
    int[] arr;
    int top = -1;
//    int[] add;
//    // 时间：所有函数为O(1)，空间：O(n)
//    public CustomStack(int maxSize) {
//        arr = new int[maxSize];
//        add = new int[maxSize];
//    }
//    public void push(int x) {
//        if (top == arr.length - 1) {
//            return;
//        }
//        top++;
//        arr[top] = x;
//    }
//    public int pop() {
//        if (top == -1) {
//            return -1;
//        }
//        int res = arr[top] + add[top];
//        if (top > 0) {
//            add[top - 1] += add[top];
//        }
//        add[top] = 0;
//        top--;
//        return res;
//    }
//    public void increment(int k, int val) {
//        int limit = Math.min(k - 1, top);
//        if (limit >= 0) {
//            add[limit] += val;
//        }
//    }
}

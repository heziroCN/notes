package haiwaitu.t20210430;

/**
 * @Author huangjunqiao
 * @Date 2021/04/30 16:18
 * @Description 1114. 按序打印
 */
public class Foo {
    // 用volatile保证用于控制同步变量可见性，防止指令重排即可，
    // 实测性能（12ms，击败99.86%)，优于官方的Atomic方案(16ms，击败30.91%)
    private volatile int firstDone = 0;
    private volatile int secondDone = 0;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstDone != 1) {
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone = 1;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondDone != 1) {
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}

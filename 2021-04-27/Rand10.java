package haiwaitu.t20210427;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author huangjunqiao
 * @Date 2021/04/26 16:24
 * @Description 470. 用 Rand7() 实现 Rand10()
 */
public class Rand10 {
    public int rand10() {
        BlockingQueue<String> q = new LinkedBlockingDeque<>();
        BlockingQueue<String> q1 = new LinkedTransferQueue();
        BlockingQueue<String> q2 = new PriorityBlockingQueue<>();
        while (true) {
            // 均匀地生成[1,49]之间的随机数
            int num = (rand7() - 1) * 7 + rand7();
            if (num <= 40) {
                return num % 10 + 1;
            }
            // 第一次随机的结果在[41,49]之间，则操作一次，均匀生成[1,63]之间的随机数
            num = (num - 40 - 1) * 7 + rand7();
            if (num <= 60) {
                return num % 10 + 1;
            }
            // 第二次随机结果在[61,63]之间，则继续生成[1,21]之间的随机数
            num = (num - 60 - 1) * 7 + rand7();
            if (num <= 20) {
                return num % 10 + 1;
            }
        }
    }

    public static Random rand = new Random();
    public int rand7() {
        return 1 + rand.nextInt(7);
    }

}

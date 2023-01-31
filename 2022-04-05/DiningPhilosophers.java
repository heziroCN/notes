package haiwaitu.t20220405;

import java.util.concurrent.locks.*;

/**
 * @Author huangjunqiao
 * @Date 2022/04/07 15:58
 * @Description 1226. 哲学家进餐
 */
public class DiningPhilosophers {
     Object[] forks = new Object[5];
     public DiningPhilosophers() {
         // sychrnoized 解法
         for (int i = 0; i < 5; i++) {
             forks[i] = new Object();
         }
     }
     public void wantsToEat(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException {
         if (philosopher == 4) {
             synchronized (forks[philosopher]) {
                 synchronized (forks[(philosopher + 1) % 5]) {
                     doEat(pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
                 }
             }
         } else {
             synchronized (forks[(philosopher + 1) % 5]) {
                 synchronized (forks[philosopher]) {
                     doEat(pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
                 }
             }
         }
     }

    public void doEat(Runnable pickLeftFork,
                      Runnable pickRightFork,
                      Runnable eat,
                      Runnable putLeftFork,
                      Runnable putRightFork) {
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
    }

//     Lock[] forks = new Lock[5];
//     public DiningPhilosophers() {
//         // ReentrantLock 解法
//         for (int i = 0; i < 5; i++) {
//             forks[i] = new ReentrantLock();
//         }
//     }
//     public void wantsToEat(int philosopher,
//                            Runnable pickLeftFork,
//                            Runnable pickRightFork,
//                            Runnable eat,
//                            Runnable putLeftFork,
//                            Runnable putRightFork) throws InterruptedException {
//         forks[philosopher].lock();
//         forks[(philosopher + 1) % 5].lock();
//         doEat(pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
//         forks[philosopher].unlock();
//         forks[(philosopher + 1) % 5].unlock();
//     }
}

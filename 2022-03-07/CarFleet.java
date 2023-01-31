package haiwaitu.t20220307;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2022/03/07 22:44
 * @Description 853. 车队
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        // 时间：O(nlogn)，空间：O(n)
        int n = speed.length;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }
        Arrays.sort(cars, (a, b) -> b.pos - a.pos);
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (cars[i - 1].time < cars[i].time) {
                res++;
            } else {
                cars[i].time = cars[i - 1].time;
            }
        }
        return res;
    }
    class Car {
        int pos;
        double time;
        public Car(int p, double t) {
            pos = p;
            time = t;
        }
    }
}

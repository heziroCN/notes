package haiwaitu.t20211110;

/**
 * @Author huangjunqiao
 * @Date 2021/11/10 16:12
 * @Description 495. 提莫攻击
 */
public class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // 时间：O(N)，空间：O(1)
        int last = 0;//最后一次中毒结束时间
        int sum = 0;// 中毒总时间
        for (int time : timeSeries) {
            if (time >= last) {// 中毒时间无重叠
                sum += duration;
            } else {// 有重叠
                sum += time + duration- last;
            }
            last = time + duration;
        }
        return sum;
    }
}

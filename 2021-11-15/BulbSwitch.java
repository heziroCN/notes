package haiwaitu.t20211115;

/**
 * @Author huangjunqiao
 * @Date 2021/11/16 15:48
 * @Description 319. 灯泡开关
 */
public class BulbSwitch {
    public int bulbSwitch(int n) {
        // 时间：O(1)，空间：O(1)。时间：O(24min)。第k个灯泡被切换的次数就是k的约数个数，由于约数都是成对出现的，所以只有在k为平方数时才会出现奇数。否则约数个数都是偶数
        return (int) Math.sqrt(n + 0.5);
    }
}

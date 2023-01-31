package haiwaitu.t20210514;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author huangjunqiao
 * @Date 2021/05/15 22:50
 * @Description 575. 分糖果
 */
public class DistributeCandies {
    // 妹妹要分到最多的糖果种类，限制了数量（两人平分）的情况下，就需要每种糖果尽可能少拿，即只拿一个，那么问题可以转化成，统计当前有多少种糖果。但是需要注意边界情况，糖果种类超过了糖果数量的一半时，妹妹只能拿一半数量的糖果，比如10个糖果，里面有7种类型，妹妹一样拿一刻最多只能拿到其中5颗
    // 数组去重解法
    public int distributeCandies(int[] candyType) {
        int len = candyType.length;
        int[] kind = new int[200000];
        for (int i = 0; i < len; i++) {
            kind[candyType[i] + 99999]++;
        }
        int sister = 0;
        for (int i = 0; i < kind.length; i++) {
            if (kind[i] > 0) {
                sister++;
            }
        }
        sister = sister < len / 2 ? sister : len / 2;
        return sister;
    }
    // 排序解法，排序后统计有多少个不同的糖果种类
    public int distributeCandies1(int[] candies) {
        Arrays.sort(candies);
        int count = 1;
        for (int i = 1; i < candies.length && count < candies.length / 2; i++)
            if (candies[i] > candies[i - 1])
                count++;
        return count;
    }
    // HashSet去重解法，时间O(n)
    public int distributeCandies2(int[] candies) {
        HashSet< Integer > set = new HashSet < > ();
        for (int candy: candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }
}

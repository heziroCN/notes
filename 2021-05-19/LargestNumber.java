package haiwaitu.t20210519;

import java.util.Arrays;

/**
 * @Author huangjunqiao
 * @Date 2021/05/19 15:52
 * @Description 179. 最大数
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        // 设s(x)为仅仅比x大的10次幂，则x,y拼接结果为x * s(y) + y
        // s(0)=10，设定比较规则后排序，拼接即可。
        int len = nums.length;
        Integer[] numsArr = new Integer[len];
        for (int i = 0; i < len; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (y * sx + x - (x * sy + y));
        });
        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int num : numsArr) {
            sb.append(num);
        }
        return sb.toString();
    }
}

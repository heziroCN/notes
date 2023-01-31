package haiwaitu.t20220623;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2022/06/24 12:02
 * @Description 1405. 最长快乐字符串
 */
public class LongestDiverseString {
    Map<Integer, Character> map = new HashMap<Integer, Character>() {{
        put(0, 'a');
        put(1, 'b');
        put(2, 'c');
    }};
    public String longestDiverseString(int a, int b, int c) {
        // 时间：O(a+b+c)SlogS，空间：O(S)，S为字符集大小
        int[][] cnts = new int[][] {{0, a}, {1, b}, {2, c}};
        StringBuilder res = new StringBuilder();
        while (true) {
            Arrays.sort(cnts, (x, y) -> y[1] - x[1]);
            boolean hasNext = false;
            for (int[] arr : cnts) {
                char c1 = map.get(arr[0]);
                if (arr[1] <= 0) {
                    break;
                }
                int len = res.length();
                if (len >= 2 && c1 == res.charAt(len - 1) && c1 == res.charAt(len - 2)) {
                    continue;
                }
                res.append(c1);
                arr[1]--;
                hasNext = true;
                break;
            }
            if (!hasNext) {
                break;
            }
        }
        return res.toString();
    }
}

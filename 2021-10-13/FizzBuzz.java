package haiwaitu.t20211013;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/10/14 00:13
 * @Description 412. Fizz Buzz
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        // 时间：O(n)，空间：不算返回结果O(1)
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            list.add(sb.toString());
        }
        return list;
    }
}

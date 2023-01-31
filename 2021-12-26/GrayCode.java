package haiwaitu.t20211226;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2021/12/27 17:27
 * @Description 89. 格雷编码
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        // 利用格雷码是反射码的规律，时间：O(2^N)，空间：不算返回结果O(1)
        List<Integer> grayList = new ArrayList<>();
        grayList.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = grayList.size() - 1; j >= 0; j--) {
                int preOne = 1 << i;
                grayList.add(grayList.get(j) + preOne);
            }
        }
        return grayList;
    }
}

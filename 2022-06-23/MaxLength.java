package haiwaitu.t20220623;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjunqiao
 * @Date 2022/06/23 17:42
 * @Description 1239. 串联字符串的最大长度
 */
public class MaxLength {
    int res = 0;
    public int maxLength(List<String> arr) {
        // 时间：O(L+2^n)，空间：O(n)，L为字符串总长度
        List<Integer> masks = new ArrayList<>();
        for (String s : arr) {
            int mask = 0;
            for (char c : s.toCharArray()) {
                int bit = c - 'a';
                if (((mask >> bit) & 1) != 0) {
                    mask = 0;
                    break;
                }
                mask |= (1 << bit);
            }
            if (mask != 0) {
                masks.add(mask);
            }
        }
        backtrack(masks, 0, 0);
        return res;
    }
    public void backtrack(List<Integer> masks, int idx, int curr) {
        if (idx == masks.size()) {
            res = Math.max(res, Integer.bitCount(curr));
            return;
        }
        int mask = masks.get(idx);
        if ((mask & curr) == 0) {
            backtrack(masks, idx + 1, curr | mask);
        }
        backtrack(masks, idx + 1, curr);
    }

    public int maxLength0(List<String> arr) {
        // 时间：O(L+2^n)，空间：O(2^n)，L为字符串总长度
        List<Integer> masks = new ArrayList<>();
        masks.add(0);
        for (String s : arr) {
            int mask = 0;
            for (char c : s.toCharArray()) {
                int bit = c - 'a';
                if (((mask >> bit) & 1) != 0) {
                    mask = 0;
                    break;
                }
                mask |= (1 << bit);
            }
            if (mask == 0) {
                continue;
            }
            int n = masks.size();
            for (int i = 0; i < n; i++) {
                int m = masks.get(i);
                if ((m & mask) == 0) {
                    masks.add(m | mask);
                    res = Math.max(res, Integer.bitCount(m | mask));
                }
            }
        }
        return res;
    }
}

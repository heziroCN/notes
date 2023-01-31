package haiwaitu.t20210817;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/08/18 19:52
 * @Description 726. 原子的数量
 */
public class CountOfAtoms {int idx = 0;
    public String countOfAtoms(String formula) {
        // 栈+哈希表
        // 时间：循环内遍历内层括号，最坏情况下N层括号，N^2，排序NlogN，总体O(N^2)。空间：O(N)
        Deque<HashMap<String, Integer>> stk = new LinkedList<>();
        stk.push(new HashMap<>());
        int len = formula.length();
        while (idx < len) {
            char c = formula.charAt(idx);
            if (c == '(') {
                stk.push(new HashMap<>());
                idx++;
            } else if (c == ')') {
                idx++;
                int num = getNum(formula, len);// 获取括号外的数字
                Map<String, Integer> currMap = stk.pop();
                Map<String, Integer> prevMap = stk.peek();
                for (Map.Entry<String, Integer> entry : currMap.entrySet()) {
                    // 累加map
                    String atom = entry.getKey();
                    int val = entry.getValue();
                    prevMap.put(atom, prevMap.getOrDefault(atom, 0) + num * val);
                }
            } else {
                String atom = getAtom(formula, len);
                int num = getNum(formula, len);
                Map<String, Integer> currMap = stk.peek();
                currMap.put(atom, currMap.getOrDefault(atom, 0) + num);
            }
        }
        TreeMap<String, Integer> treeMap = new TreeMap<>(stk.peek());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            sb.append(entry.getKey());
            int cnt = entry.getValue();
            if (cnt > 1) {
                sb.append(cnt);
            }
        }
        return sb.toString();
    }
    public String getAtom(String s, int len) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(idx++));// 首字母
        while (idx < len && Character.isLowerCase(s.charAt(idx))) {
            sb.append(s.charAt(idx++));
        }
        return sb.toString();
    }
    public int getNum(String s, int len) {
        if (idx == len || !Character.isDigit(s.charAt(idx))) {
            return 1;
        }
        int res = 0;
        while (idx < len && Character.isDigit(s.charAt(idx))) {
            res = res * 10 + s.charAt(idx++) - '0';
        }
        return res;
    }
}

package haiwaitu.t20220508;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangjunqiao
 * @Date 2022/05/09 08:55
 * @Description 8. 字符串转换整数 (atoi)
 */
public class MyAtoi {
     public int myAtoi(String s) {
         // 时间：O(n)，空间：O(1)
         int idx = 0, n = s.length();
         while (idx < n && s.charAt(idx) == ' ') {
             idx++;
         }
         int positive = 1;
         if (idx < n && s.charAt(idx) == '+') {
             idx++;
         } else if (idx < n && s.charAt(idx) == '-') {
             idx++;
             positive = -1;
         }
         long res = 0;
         while (idx < n && Character.isDigit(s.charAt(idx))) {
             res = res * 10 + s.charAt(idx++) - '0';
             if (res * positive > Integer.MAX_VALUE) {
                 return Integer.MAX_VALUE;
             } else if (res * positive < Integer.MIN_VALUE) {
                 return Integer.MIN_VALUE;
             }
         }

         return (int) res * positive;
     }

    public int myAtoi0(String s) {
        // 确定有限状态自动机，时间：O(n)，空间：O(state^2)
        Automation a = new Automation();
        for (char c : s.toCharArray()) {
            a.get(c);
        }
        return (int) (a.signed * a.res);
    }
}
class Automation {
    public int signed = 1;
    public long res = 0;
    private String state = "start";//全局状态
    private Map<String, String[]> map = new HashMap<String, String[]>() {{
        put("start", new String[] {"start", "signed", "in_number", "end"});
        put("signed", new String[] {"end", "end", "in_number", "end"});
        put("in_number", new String[] {"end", "end", "in_number", "end"});
        put("end", new String[] {"end", "end", "end", "end"});
    }};
    public void get(char c) {
        // 状态转移
        state = map.get(state)[nextState(c)];
        if ("signed".equals(state)) {
            signed = c == '-' ? -1 : 1;
        } else if ("in_number".equals(state)) {
            res = res * 10 + c - '0';
            res = signed == 1 ? Math.min(res, Integer.MAX_VALUE) : Math.min(res, -(long) Integer.MIN_VALUE);
        }
    }
    public int nextState(char c) {
        if (c == ' ') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else if (Character.isDigit(c)) {
            return 2;
        } else {
            return 3;
        }
    }
}

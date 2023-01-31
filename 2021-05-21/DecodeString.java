package haiwaitu.t20210521;

import java.util.LinkedList;

/**
 * @Author huangjunqiao
 * @Date 2021/05/21 18:14
 * @Description 394. 字符串解码
 */
public class DecodeString {
    static int idx = 0;
    public String decodeString0(String s) {
        LinkedList<String> stack = new LinkedList<>();
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                // 记录数字并移动指针
                String digit = getDigit(s);
                stack.add(digit);
            } else if (Character.isLetter(c) || '[' == c) {
                stack.add(String.valueOf(c));
                idx++;
            } else {
                idx++;
                // 遇到右括号时，在栈里寻找匹配的左括号
                LinkedList<String> subList = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    subList.addFirst(stack.pollLast());
                }
                // 弹出左括号
                stack.pollLast();
                // 把subList里的子字符串合并
                String subStr = combineStr(subList);
                StringBuilder sb = new StringBuilder();
                // 弹出数字cnt，循环拼接cnt次当前子串
                int cnt = Integer.valueOf(stack.pollLast());
                while (cnt > 0) {
                    sb.append(subStr);
                    cnt--;
                }
                stack.add(sb.toString());
            }
        }
        return combineStr(stack);
    }

    public static String getDigit(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(idx))) {
            sb.append(s.charAt(idx++));
        }
        return sb.toString();
    }
    public String combineStr(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static String decodeString(String s) {
        return decodeCore(s);
    }
    public static String decodeCore(String s) {
        if (idx == s.length() || s.charAt(idx) == ']') {
            return "";
        }
        int cnt = 1;
        String res = "";
        if (Character.isDigit(s.charAt(idx))) {
            cnt = Integer.valueOf(getDigit(s));
            // 跳过左括号
            idx++;
            //拿到递归处理括号内的子字符串
            String str = decodeCore(s);
            // 跳过右括号
            idx++;
            while (cnt > 0) {
                res += str;
                cnt--;
            }
        } else if (Character.isLetter(s.charAt(idx))) {
            res = String.valueOf(s.charAt(idx++));
        }
        // 需要继续处理下一个字符
        return res + decodeCore(s);
    }
}

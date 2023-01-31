package haiwaitu.t20211029;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author huangjunqiao
 * @Date 2021/10/30 00:53
 * @Description 301. 删除无效的括号
 */
public class RemoveInvalidParentheses {
    List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses0(String s) {
        // 回溯
        int lRemove = 0, rRemove = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if ('(' == s.charAt(i)) {
                lRemove++;
            } else if (')' == s.charAt(i)) {
                if (lRemove > 0) {
                    lRemove--;
                } else {
                    rRemove++;
                }
            }
        }
        backtrack(lRemove, rRemove, s, 0);
        return res;
    }
    public void backtrack(int lRemove, int rRemove, String s, int start) {
        if (lRemove == 0 && rRemove == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;// 如果s无效，也没必要继续递归了，lRemove和rRemove只会越来越小
        }
        int len = s.length();
        for (int i = start; i < len; i++) {// 从start开始尝试移除每个字符
            if (i != start && s.charAt(i - 1) == s.charAt(i)) {
                continue;// 遇到重复字符只需要处理（移除）第一个
            }
             if (lRemove + rRemove > len - i) {
                 return;
             }
            if (lRemove > 0 && '(' == s.charAt(i)) {
                backtrack(lRemove - 1, rRemove, s.substring(0, i) + s.substring(i + 1), i);
            }
            if (rRemove > 0 && ')' == s.charAt(i)) {
                backtrack(lRemove, rRemove - 1, s.substring(0, i) + s.substring(i + 1), i);
            }
        }
    }
    public boolean isValid(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        // bfs，每轮移除一个字符。设至少要移除k个字符才出现有效字符串，则所有有效的子串会在第k轮出现。
        Set<String> currSet = new HashSet<>();
        currSet.add(s);
        while (true) {
            for (String subStr : currSet) {
                if (isValid(subStr)) {
                    res.add(subStr);
                }
            }
            if (res.size() > 0) {
                return res;
            }

            Set<String> nextSet = new HashSet<>();
            for (String subStr : currSet) {
                int len = subStr.length();
                for (int i = 0; i < len; i++) {
                    if (i != 0 && subStr.charAt(i - 1) == s.charAt(i)) {
                        continue;
                    }
                    if (subStr.charAt(i) == '(' || subStr.charAt(i) == ')') {
                        nextSet.add(subStr.substring(0, i) + subStr.substring(i + 1));
                    }
                }
            }
            currSet = nextSet;
        }

    }

    public static void main(String[] args) {
        RemoveInvalidParentheses o = new RemoveInvalidParentheses();
        String s = ")(";
        System.out.println(o.removeInvalidParentheses(s));
    }
}

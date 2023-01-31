package haiwaitu.t20220518;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/05/18 16:33
 * @Description 17. 电话号码的字母组合
 */
public class LetterCombinations {
    List<String> res = new ArrayList<>();
    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        // 回溯，时间：O(nL)，空间：O(n)，n为字符串长度，L为数字对应的字符数量。
        if (digits.length() > 0) {
            backtrack(digits, new StringBuilder(), 0);
        }
        return res;
    }
    public void backtrack(String digits, StringBuilder sb, int idx) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String s = map.get(digits.charAt(idx));
        for (char c : s.toCharArray()) {
            sb.append(c);
            backtrack(digits, sb, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

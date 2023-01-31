package haiwaitu.t20210511;

/**
 * @Author huangjunqiao
 * @Date 2021/05/11 08:06
 * @Description 844. 比较含退格的字符串
 */
public class BackspaceCmp {
    public boolean backspaceCompare(String s, String t) {
        // 重构字符串（模拟栈） 时间O(N+M) 空间O(N+M)
        return build(s).equals(build(t));
    }
    public String build(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }
    public boolean backspaceCompare0(String s, String t) {
        // 双指针法，从后往前处理，遇到#退格 时间O(N+M)，空间O(1)
        int sIdx = s.length() - 1;
        int tIdx = t.length() - 1;
        // s当前未处理的#数
        int sCount = 0;
        // t当前未处理的#数
        int tCount = 0;
        while (sIdx >= 0 || tIdx >= 0) {
            while (sIdx >= 0) {
                if (s.charAt(sIdx) == '#') {
                    sCount++;
                    sIdx--;
                } else if (sCount > 0) {
                    // 还有#则需要跳格
                    sCount--;
                    sIdx--;
                } else {
                    break;
                }
            }
            while (tIdx >= 0) {
                if (t.charAt(tIdx) == '#') {
                    tCount++;
                    tIdx--;
                } else if (tCount > 0) {
                    tCount--;
                    tIdx--;
                } else {
                    break;
                }
            }
            if (sIdx >= 0 && tIdx >= 0) {
                // 两个字符串都还有字符剩余时需要比较大小
                if (s.charAt(sIdx) != t.charAt(tIdx)) {
                    return false;
                }
            } else {
                // 其中一个已经遍历完了而另一个还有剩余字符的话，说明两字符串不等
                if (sIdx >= 0 || tIdx >= 0) {
                    return false;
                }
            }
            sIdx--;
            tIdx--;
        }
        return true;
    }
}

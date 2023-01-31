package haiwaitu.t20210820;

/**
 * @Author huangjunqiao
 * @Date 2021/08/21 20:24
 * @Description 316. 去除重复字母
 */
public class RemoveDuplicateLetters {
    // 相似题目：402. 移掉 K 位数字
    public String removeDuplicateLetters(String s) {
        // 单调栈+贪心，字典序小的字符尽可能排在左边。时间：O(N)，空间：O(N)
        int len = s.length();
        int[] num = new int[26];// 字符频率
        boolean[] exist = new boolean[26];// 字符是否存在于栈里
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            num[c - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 如果字符已经存在栈中，不能再添加，保持每个字符在栈里最多出现一次。
            if (!exist[c - 'a']) {
                while (sb.length() > 0 && c < sb.charAt(sb.length() - 1)) {
                    char removed = sb.charAt(sb.length() - 1);
                    // 如果已经是最后一个字符，不能再删除了
                    if (num[removed - 'a'] == 0) {
                        break;
                    } else {
                        exist[removed - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
                sb.append(c);
            }
            exist[c - 'a'] = true;
            num[c - 'a']--;
        }

        return sb.toString();
    }
}

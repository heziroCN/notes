package haiwaitu.t20210622;

/**
 * @Author huangjunqiao
 * @Date 2021/06/23 15:23
 * @Description 424. 替换后的最长重复字符
 */
public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        // 双指针，时间O(N)，空间O(S)，S为字符集大小
        int l = 0, r = 0;
        int len = s.length();
        int maxn = 0;
        // 字符频率数组，记录当期窗口字符出现次数
        int[] nums = new int[26];
        // 两指针从0开始逐个枚举，求最长子串，窗口长度是单调递增的
        while (r < len) {
            nums[s.charAt(r) - 'A']++;
            // 1、maxn记录历史最大值
            maxn = Math.max(maxn, nums[s.charAt(r) - 'A']);
            // 2、如果[l,r]区间内，刨去替换的k个字符，剩下的字符数不足maxn，自然也不可能产生比maxn长的重复子串，因此左指针和右指针一起移动，继续寻找答案
            if (r - l + 1 - maxn > k) {
                nums[s.charAt(l) - 'A']--;
                l++;
            }
            r++;
        }
        return r - l;
    }
}

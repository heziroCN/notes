package haiwaitu.t20211123;

/**
 * @Author huangjunqiao
 * @Date 2021/11/24 16:28
 * @Description 423. 从英文中重建数字
 */
public class OriginalDigits {
    public String originalDigits(String s) {
        // 时间：O(N)，空间：O(1)
        // zero one two three four five six seven eight nine
        // 字符集：e f g h i n o r s t u v w x z
        // 1、u g w x z 分别只存在于 four,eight,two,six,zero中。
        // 2、h只存在于three,eight，eight数量已知，three数量可求；f只存在于five,four，four数量已知，five数量可求；s只存在于six,seven中，six数量已知，seven可求；o只存在于four,two,zero,one，four,two,zero数量已知，one数量可求。
        // 3、i只存在于five,six,eight,nine中，five,six,eight数量已知，nine数量可求。
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int[] cnt = new int[10];
        cnt[0] = freq['z' - 'a'];
        cnt[2] = freq['w' - 'a'];
        cnt[4] = freq['u' - 'a'];
        cnt[6] = freq['x' - 'a'];
        cnt[8] = freq['g' - 'a'];

        cnt[3] = freq['h' - 'a'] - cnt[8];
        cnt[5] = freq['f' - 'a'] - cnt[4];
        cnt[7] = freq['s' - 'a'] - cnt[6];
        cnt[1] = freq['o' - 'a'] - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = freq['i' - 'a'] - cnt[5] - cnt[6] - cnt[8];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                res.append(i);
            }
        }
        return res.toString();
    }
}

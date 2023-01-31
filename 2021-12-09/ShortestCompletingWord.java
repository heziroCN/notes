package haiwaitu.t20211209;

/**
 * @Author huangjunqiao
 * @Date 2021/12/12 18:30
 * @Description 748. 最短补全词
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // 统计字符频率，时间：O(N(L+S))，空间：O(S)，S为字符集大小，L为最长word长度，N为word数量
        int[] freq = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                freq[Character.toLowerCase(c) - 'a']++;
            }
        }
        String res = "";
        int shortest = 1001;
        for (String word : words) {
            int[] f = new int[26];
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    f[c - 'a']++;
                }
            }
            boolean cover = true;
            for (int i = 0; i < 26; i++) {
                if (f[i] < freq[i]) {
                    cover = false;
                    break;
                }
            }
            if (cover && word.length() < shortest) {
                shortest = word.length();
                res = word;
            }
        }
        return res;
    }
}

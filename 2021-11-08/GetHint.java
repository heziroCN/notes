package haiwaitu.t20211108;

/**
 * @Author huangjunqiao
 * @Date 2021/11/09 10:19
 * @Description 299. 猜数字游戏
 */
public class GetHint {
    public String getHint(String secret, String guess) {
        // 时间：O(N)，空间：O(1)
        int bull = 0, cow = 0;
        int[] bulls = new int[10];
        int[] cows = new int[10];
        int len = secret.length();
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                bulls[secret.charAt(i) - '0']++;
                cows[guess.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cow += Math.min(bulls[i], cows[i]);
        }

        return bull + "A" + cow + "B";
    }
}

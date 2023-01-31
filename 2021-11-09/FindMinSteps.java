package haiwaitu.t20211109;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/11/09 12:10
 * @Description 488. 祖玛游戏
 */
public class FindMinSteps {
    public int findMinStep(String board, String hand) {
        // BFS
        char[] arr = hand.toCharArray();
        Arrays.sort(arr);
        hand = new String(arr);
        int len = board.length();
        Deque<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(new State(board, hand, 0));
        visited.add(board + "#" + hand);

        while (!q.isEmpty()) {
            State state = q.poll();
            String currBoard = state.board;
            String currHand = state.hand;
            int currStep = state.step;
            for (int i = 0; i <= currBoard.length(); i++) {
                for (int j = 0; j < currHand.length(); j++) {
                    // 剪枝1，手上球同色时选一个（第一个）即可
                    if (j > 0 && currHand.charAt(j - 1) == currHand.charAt(j)) {
                        continue;
                    }
                    // 剪枝2，桌上球连续两个同色选一个(开头位置)位置插入即可
                    if (i > 0 && currHand.charAt(j) == currBoard.charAt(i - 1)) {
                        continue;
                    }
                    // 剪枝3，只在手球与目标位置右侧球同色，或者左右两侧球同色时放置
                    boolean choose = false;
                    if (i < currBoard.length() && currHand.charAt(j) == currBoard.charAt(i)) {
                        choose = true;
                    }
                    // 能将连续的球拆分到不同的组合消除
                    if (i > 0 && i < currBoard.length() && currBoard.charAt(i - 1) == currBoard.charAt(i) && currBoard.charAt(i - 1) != currHand.charAt(j)) {
                        choose = true;
                    }
                    if (choose) {
                        String newBoard = clean(currBoard.substring(0, i) + currHand.charAt(j) + currBoard.substring(i));
                        if ("".equals(newBoard)) {
                            return currStep + 1;
                        }
                        String newHand = currHand.substring(0, j) + currHand.substring(j + 1);
                        if (visited.add(newBoard + "#" + newHand)) {
                            q.offer(new State(newBoard, newHand, currStep + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
    public String clean(String s) {
        String prev = "";
        while (!s.equals(prev)) {// 消除，直到没有“三连”为止
            int same = 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
                    same++;
                } else {
                    if (same >= 3) {
                        sb.delete(sb.length() - same, sb.length());
                    }
                    same = 1;
                }
                sb.append(s.charAt(i));
            }
            if (same >= 3) {
                sb.delete(sb.length() - same, sb.length());
            }
            prev = s;
            s = sb.toString();
        }
        return s;
    }
}
class State {
    String board;// 桌上的球
    String hand;// 手上的球，不要求顺序，可以用数组代替，但是字符串方便拼接，放入哈希集合
    int step;// 回合数
    public State(String board, String hand, int step) {
        this.board = board;
        this.hand = hand;
        this.step = step;
    }
    public State() {}
}

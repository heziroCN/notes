package haiwaitu.t20220527;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/05/28 18:22
 * @Description 212. 单词搜索 II
 */
public class FindWords {
    Set<String> res = new HashSet<>();
    int m, n;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<String> findWords(char[][] board, String[] words) {
        // 前缀树+回溯，时间：O(mn3^(l-1))，空间：O(wl)，w是words长度，l是单词最大长度
        m = board.length;
        n = board[0].length;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, board, trie);
            }
        }
        return new ArrayList<>(res);
    }
    public void dfs(int i, int j, char[][] board, Trie curr) {
        if (!curr.children.containsKey(board[i][j])) {
            return;
        }
        curr = curr.children.get(board[i][j]);
        if (!"".equals(curr.word)) {
            res.add(curr.word);
        }
        char temp = board[i][j];
        board[i][j] = '#';
        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && y >= 0 && x < m && y < n) {
                dfs(x, y, board, curr);
            }
        }
        board[i][j] = temp;
    }

//    List<String> ans = new ArrayList<>();
//    public List<String> findWords(char[][] board, String[] words) {
//        // 前缀树+回溯+移除找到字符串优化，时间：O(mn3^(l-1))，空间：O(wl)，w是words长度，l是单词最大长度
//        m = board.length;
//        n = board[0].length;
//        Trie trie = new Trie();
//        for (String word : words) {
//            trie.insert(word);
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                dfs(i, j, board, trie);
//            }
//        }
//        return ans;
//    }
//    public void dfs(int i, int j, char[][] board, Trie curr) {
//        if (!curr.children.containsKey(board[i][j])) {
//            return;
//        }
//        Trie child = curr.children.get(board[i][j]);
//        if (!"".equals(child.word)) {
//            ans.add(child.word);
//            child.word = "";
//        }
//        char temp = board[i][j];
//        board[i][j] = '#';
//        for (int[] d : directions) {
//            int x = i + d[0], y = j + d[1];
//            if (x >= 0 && y >= 0 && x < m && y < n) {
//                dfs(x, y, board, child);
//            }
//        }
//        board[i][j] = temp;
//        if (child.children.isEmpty()) {
//            curr.children.remove(board[i][j]);
//        }
//    }
}

class Trie {
    String word;
    Map<Character, Trie> children;
    public Trie() {
        word = "";
        children = new HashMap<>();
    }
    public void insert(String s) {
        Trie curr = this;
        for (char c : s.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Trie());
            }
            curr = curr.children.get(c);
        }
        curr.word = s;
    }
}
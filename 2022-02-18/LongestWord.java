package haiwaitu.t20220218;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/02/19 11:02
 * @Description 720. 词典中最长的单词
 */
public class LongestWord {
     public String longestWord(String[] words) {
         // 排序+暴力搜索，时间：O(ns)，空间：O(ns)，ns为所有字符长度和
         Set<String> set = new HashSet<>();
         for (String word : words) {
             set.add(word);
         }
         Arrays.sort(words, (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
         String res = "";
         for (String word : words) {
             boolean good = true;
             for (int i = 1; i < word.length(); i++) {
                 if (!set.contains(word.substring(0, i))) {
                     good = false;
                     break;
                 }
             }
             if (good) {
                 return word;
             }
         }
         return "";
     }
    public String longestWord0(String[] words) {
        // 前缀树，时间：O(ns)，空间：O(ns)，ns为所有字符长度和
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }
        String res = "";
        // bfs
        Deque<Node> q = new LinkedList<>();
        q.offer(trie.root);
        while (!q.isEmpty()) {
            int sz = q.size();
            boolean isFirst = true;
            for (int i = 0; i < sz; i++) {
                Node node = q.poll();
                if (isFirst && node != trie.root) {
                    res = words[node.pos];
                    isFirst = false;
                }
                for (Node child : node.children) {
                    if (child != null && child.pos != -1) {
                        q.offer(child);
                    }
                }
            }
        }
        return res;
    }

}
class Node {
    int pos = -1;
    Node[] children = new Node[26];
}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    public void insert(String s, int idx) {
        Node curr = root;
        for (char c : s.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node();
            }
            curr = curr.children[c - 'a'];
        }
        curr.pos = idx;
    }
}
package haiwaitu.t20211019;

/**
 * @Author huangjunqiao
 * @Date 2021/10/19 15:22
 * @Description 208. 实现 Trie (前缀树)
 */
public class Trie {
    Trie[] children;// 子节点列表，长度26，对应26个字母
    boolean isEnd;// 标志一个单词的结束，可以用来判断单词是否存在
    public Trie() {
        isEnd = false;
        children = new Trie[26];
    }

    public void insert(String word) {
        int len = word.length();
        Trie node = this;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
    public Trie searchPrefix(String word) {
        int len = word.length();
        Trie node = this;
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return null;
            }
            node = node.children[idx];
        }
        return node;
    }
}

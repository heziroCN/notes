package haiwaitu.t20211019;

/**
 * @Author huangjunqiao
 * @Date 2021/10/19 16:29
 * @Description 211. 添加与搜索单词 - 数据结构设计
 */
public class WordDictionary {
    // 在Trie树基础上，改写搜索逻辑：遇到’.‘遍历所有子节点
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int i, Trie node) {
        if (i == word.length()) {
            return node.isEnd;
        }
        char c = word.charAt(i);
        int idx = c - 'a';
        if (c == '.') {
            for (Trie child : node.children) {
                if (child != null && dfs(word, i + 1, child)) {
                    return true;
                }
            }
            return false;
        }
        if (node.children[idx] == null) {
            return false;
        }
        return dfs(word, i + 1, node.children[idx]);
    }

}


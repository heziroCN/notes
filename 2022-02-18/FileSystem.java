package haiwaitu.t20220218;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2022/02/19 15:34
 * @Description 588. 设计内存文件系统
 */
public class FileSystem {
    Trie trie;
    public FileSystem() {
        this.trie = new Trie();
    }

    public List<String> ls(String path) {
        List<String> fileList = new ArrayList<>();
        Node node = trie.find(path);
        for (Map.Entry<String, Node> e : node.children.entrySet()) {
            fileList.add(e.getKey());
        }
        if (node.isFile) {
            fileList.add(node.path);
        }
        Collections.sort(fileList);
        return fileList;
    }

    public void mkdir(String path) {
        trie.findAndCreate(path);
    }

    public void addContentToFile(String filePath, String content) {
        Node node = trie.findAndCreate(filePath);
        node.isFile = true;
        node.content += content;
    }

    public String readContentFromFile(String filePath) {
        return trie.find(filePath).content;
    }
    class Trie {
        Node root;
        public Trie() {
            root = new Node("/");
        }
        public Node find(String path) {
            Node curr = root;
            String[] subPaths = path.split("/");
            for (String subPath : subPaths) {
                if ("".equals(subPath)) {
                    continue;
                }
                if (!curr.children.containsKey(subPath)) {
                    return null;
                }
                curr = curr.children.get(subPath);
            }
            return curr;
        }
        public Node findAndCreate(String path) {
            Node curr = root;
            String[] subPaths = path.split("/");
            for (String subPath : subPaths) {
                if ("".equals(subPath)) {
                    continue;
                }
                curr.children.putIfAbsent(subPath, new Node(subPath));
                curr = curr.children.get(subPath);
            }
            if (curr.content == null) {
                curr.content = "";
            }
            return curr;
        }
    }
    class Node {
        Map<String, Node> children = new HashMap<>();
        boolean isFile;
        String content;
        public String path;
        public Node(String path) {
            this.path = path;
        }
    }
}

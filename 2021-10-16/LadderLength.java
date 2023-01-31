package haiwaitu.t20211016;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/10/17 17:12
 * @Description 127. 单词接龙
 */
public class LadderLength {
    List<List<Integer>> edges = new ArrayList<>();
    Map<String, Integer> wordId = new HashMap<>();
    int nodeNum = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 单向BFS
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] distant = new int[nodeNum];
        Arrays.fill(distant, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        distant[beginId] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(beginId);
        while (!q.isEmpty()) {
            int id = q.poll();
            if (id == endId) {
                return distant[id] / 2 + 1;
            }
            for (int nextId : edges.get(id)) {
                if (distant[nextId] == Integer.MAX_VALUE) {
                    distant[nextId] = distant[id] + 1;
                    q.offer(nextId);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id = wordId.get(word);
        int n = word.length();
        for (int i = 0; i < n; i++) {
            String newStr = word.substring(0, i) + "*" + word.substring(i + 1);
            addWord(newStr);
            int newId = wordId.get(newStr);
            edges.get(id).add(newId);
            edges.get(newId).add(id);
        }
    }
    public void addWord(String word) {
        if (wordId.containsKey(word)) {
            return;
        }
        wordId.put(word, nodeNum++);
        edges.add(new ArrayList<>());
    }

    public int ladderLength0(String beginWord, String endWord, List<String> wordList) {
        // 双向BFS
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        int[] beginDistant = new int[nodeNum], endDistant = new int[nodeNum];
        Arrays.fill(beginDistant, Integer.MAX_VALUE);
        Arrays.fill(endDistant, Integer.MAX_VALUE);
        beginDistant[beginId] = 0;
        endDistant[endId] = 0;
        Queue<Integer> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        beginQueue.offer(beginId);
        endQueue.offer(endId);
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int dist1 = twoQueueBfs(beginQueue, endQueue, beginDistant, endDistant);
            if (dist1 != -1) {
                return dist1;
            }
            int dist2 = twoQueueBfs(endQueue, beginQueue, endDistant, beginDistant);
            if (dist2 != -1) {
                return dist2;
            }
        }
        return 0;
    }
    public int twoQueueBfs(Queue<Integer> q1, Queue<Integer> q2, int[] d1, int[] d2) {
        int sz = q1.size();
        for (int i = 0; i < sz; i++) {
            int id = q1.poll();
            if (d2[id] != Integer.MAX_VALUE) {
                return (d1[id] + d2[id]) / 2 + 1;
            }
            for (int nextId : edges.get(id)) {
                if (d1[nextId] == Integer.MAX_VALUE) {
                    d1[nextId] = d1[id] + 1;
                    q1.offer(nextId);
                }
            }
        }
        return -1;
    }
}

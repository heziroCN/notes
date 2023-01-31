package haiwaitu.t20211207;

import java.util.*;

/**
 * @Author huangjunqiao
 * @Date 2021/12/08 22:00
 * @Description 355. 设计推特
 */
public class Twitter {
    class User {
        Set<Integer> followee;
        LinkedList<Integer> tweet;
        public User() {
            followee = new HashSet<>();
            tweet = new LinkedList<>();
        }
    }
    private Map<Integer, User> map;
    private Map<Integer, Integer> timeMap;
    private int time;// 要自己记录并模拟时间流动 - -!
    public Twitter() {
        map = new HashMap<>();
        timeMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)) {
            map.put(userId, new User());
        }
        LinkedList<Integer> tweet = map.get(userId).tweet;
        tweet.addFirst(tweetId);
        if (tweet.size() > 10) {
            tweet.removeLast();// 只需保留最新10条
        }
        timeMap.put(tweetId, time++);
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!map.containsKey(userId)) {
            map.put(userId, new User());
        }
        Set<Integer> followee = map.get(userId).followee;
        followee.add(userId);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> timeMap.get(a) - timeMap.get(b));
        for (int f : followee) {
            LinkedList<Integer> tweet = map.get(f).tweet;
            for (int t : tweet) {//最新10条推
                pq.offer(t);
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll());
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new User());
        }
        if (!map.containsKey(followeeId)) {
            map.put(followeeId, new User());
        }
        map.get(followerId).followee.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        // consider followee's key is null?
        map.get(followerId).followee.remove(followeeId);
    }
}

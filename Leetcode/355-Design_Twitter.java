class Twitter {
    class Tweet {
        int userId;
        int tweetId;
        Tweet prev;
        Tweet next;

        public Tweet(int userId, int tweetId) {
            this.tweetId = tweetId;
            this.userId = userId;
        }
    }

    public Tweet add(Tweet head, Tweet tail, Tweet n) {
        Tweet temp = tail.prev;
        tail.prev = n;
        n.next = tail;
        n.prev = temp;
        temp.next = n;

        return n;
    }

    public void getTweets(int userId, HashMap<Integer, HashSet<Integer>> hm, List<Integer> tweets, Tweet tail,
            Tweet head) {
        int i = 0;
        HashSet<Integer> following = hm.getOrDefault(userId, new HashSet());
        following.add(userId);
        Tweet temp = tail.prev;

        while (temp != null && temp != head) {
            if(tweets.size()==10) break;
            if (following.contains(temp.userId)) {
                tweets.add(temp.tweetId);
            }

            temp = temp.prev;
        }
        following.remove(userId);

    }

    Tweet head;
    Tweet tail;
    // user x following
    HashMap<Integer, HashSet<Integer>> userToFollowMap = new HashMap();

    public Twitter() {
        head = new Tweet(-1000, -1000);
        tail = new Tweet(-1000, -1000);
        head.next = tail;
        tail.prev = head;
    }

    public void postTweet(int userId, int tweetId) {
        Tweet n = new Tweet(userId, tweetId);
        if (!userToFollowMap.containsKey(userId)) {
            userToFollowMap.put(userId, new HashSet());
        }
        n = add(head, tail, n);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweets = new ArrayList();
        getTweets(userId, userToFollowMap, tweets, tail, head);

        return tweets;
    }

    public void follow(int followerId, int followeeId) {
        if (!userToFollowMap.containsKey(followerId)) {
            HashSet<Integer> hs = new HashSet();
            hs.add(followeeId);
            userToFollowMap.put(followerId, hs);
        } else {
            HashSet<Integer> hs = userToFollowMap.get(followerId);
            hs.add(followeeId);
            userToFollowMap.put(followerId, hs);
        }
        userToFollowMap.put(followeeId, userToFollowMap.getOrDefault(followeeId, new HashSet()));
    }

    public void unfollow(int followerId, int followeeId) {
        if (userToFollowMap.containsKey(followerId)) {
            HashSet<Integer> hs = userToFollowMap.get(followerId);
            hs.remove(followeeId);
            userToFollowMap.put(followerId, hs);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
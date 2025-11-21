class Twitter {

    private Map<Integer, Set<Integer>> followers;  // who each user follows
    private Map<Integer, List<Tweet>> tweets;      // tweets for each user
    private int timestamp;

    class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq =
          new PriorityQueue<>((a,b) -> b.time - a.time);  // max heap

        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));
        }

        // Add tweets from followees
        if (followers.containsKey(userId)) {
            for (int followeeId : followers.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    pq.addAll(tweets.get(followeeId));
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int count = 0;

        while (!pq.isEmpty() && count < 10) {
            res.add(pq.poll().id);
            count++;
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
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
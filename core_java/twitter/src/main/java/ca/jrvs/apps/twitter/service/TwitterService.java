package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TwitterService implements Service{
    private CrdDao dao;

    @Autowired
    public TwitterService(CrdDao dao) {
        this.dao = dao;
    }

    /**
     * verify  the tweet from user
     * @param tweet tweet to be created
     * @return
     */
    @Override
    public Tweet postTweet(Tweet tweet) throws IllegalArgumentException {
        if (tweet.getText().length() > 140) {
            throw new IllegalArgumentException("over 140 characters");
        }
        Double lon = tweet.getCoordinates().getCoordinates()[0];
        Double lat = tweet.getCoordinates().getCoordinates()[1];
        if (Math.abs(lon) > 180 || Math.abs(lat) > 90) {
            throw new IllegalArgumentException("invalid geo tag");
        }
        return (Tweet) dao.create(tweet);
    }



    /**
     * search tweet by ID
     * @param id tweet id
     * @param fields set fields not in the list to null
     * @return
     */
    @Override
    public Tweet showTweet(String id, String[] fields) throws IllegalArgumentException {
        Tweet tweet = (Tweet) dao.findById(id);
        tweet.select(fields);
        return tweet;
    }

    @Override
    public Tweet showTweet(String id) throws IllegalArgumentException {
        return showTweet(id, null);
    }


    @Override
    public List<Tweet> deleteTweets(String[] ids) throws IllegalArgumentException {
        ArrayList<Tweet> tweets = new ArrayList<>();
        for (String id : ids) {
            Tweet tweet = (Tweet) dao.deleteById(id);
            tweets.add(tweet);
        }
        return tweets;
    }
}

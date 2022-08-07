package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.tweetUtils.TweetUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


    public class TwitterController implements Controller{
        private static final String COORD_SEP = ":";
        private static final String COMMA = ",";
        private Service service;

        @Autowired
        public TwitterController(Service service) {
            this.service = service;
        }

        /**

         * @param args
         * @return a posted tweet
         * @throws IllegalArgumentException if args are invalid
         */
        @Override
        public Tweet postTweet(String[] args) {
            if (args.length != 3) {
                throw new IllegalArgumentException("USAGE: TwitterCLIApp post \"tweet_text\" \"latitude:longitude\"");
            }
            String text = args[1];
            String[] coordinates = args[2].split(COORD_SEP);
            if (coordinates.length != 2 || text.equals("")) {
                throw new IllegalArgumentException("Empty tweet text");
            }
            Double lat;
            Double lon;
            try {
                lat = Double.parseDouble(coordinates[0]);
                lon = Double.parseDouble(coordinates[1]);
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid location format", e);
            }
            Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);
            return service.postTweet(postTweet);
        }

        /**

         * @param args
         * @return a tweet
         * @throws IllegalArgumentException if args are invalid
         */
        @Override
        public Tweet showTweet(String[] args) {
            if (args.length != 2 && args.length !=3) {
                throw new IllegalArgumentException("USAGE: TwitterCLIApp show \"tweet_id\" \"[field1,field2,...]\"");
            }
            if (args.length == 2) {
                return service.showTweet(args[1]);
            } else {
                String[] fields = args[2].split(COMMA);
                return service.showTweet(args[1], fields);
            }
        }

        /**

         * @return a list of deleted tweets
         * @throws IllegalArgumentException if args are invalid
         */
        @Override
        public List<Tweet> deleteTweet(String[] args) {
            if (args.length != 2) {
                throw new IllegalArgumentException("USAGE: TwitterCLIApp delete [id1,id2,...]");
            }
            String[] ids = args[1].split(COMMA);
            return service.deleteTweets(ids);
        }


}

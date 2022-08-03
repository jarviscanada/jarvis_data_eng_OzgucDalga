package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


public class TwitterDaoUnitTest {
    final private String tweetJonsStr = "{\n"
            + "   \"created_at\":\"Mon Feb 18 21:24:39 +0000 2019\",\n"
            + "   \"id\":1097607853932564480,\n"
            + "   \"id_str\":\"1097607853932564480\",\n"
            + "   \"text\":\"dao_unit_test\",\n"
            + "   \"entities\":{\n"
            + "      \"hashtags\":[],\n"
            + "      \"user_mentions\":[]\n"
            + "   },\n"
            + "   \"coordinates\":null,\n"
            + "   \"retweet_count\":0,\n"
            + "   \"favorite_count\":0,\n"
            + "   \"favorited\":false,\n"
            + "   \"retweeted\":false\n"
            + "}";

    @Mock
    HttpHelper mockHelper;

    @InjectMocks
    TwitterDao dao;

    @Test
    public void postTweet() throws Exception {
        try {
            dao.create(new Tweet());
            fail();
        } catch (RuntimeException e) {
            assertTrue(true);
        }

        TwitterDao spyDao = Mockito.spy(dao);
        Tweet expectedTweet = JsonParser.toObjectFromJson(tweetJonsStr, Tweet.class);
        doReturn(expectedTweet).when(spyDao).create(any());
        Tweet tweet = spyDao.create(expectedTweet);
        assertNotNull(tweet);
        assertNotNull(tweet.getText());
        assertEquals(tweet.getText(), "test");
    }

    @Test
    public void showTweet() throws Exception {
        when(mockHelper.httpGet(isNotNull())).thenThrow(new RuntimeException("mock test show tweet"));
        try {
            dao.findById("");
            fail();
        } catch (RuntimeException e) {
            assertTrue(true);
        }

        TwitterDao spyDao = Mockito.spy(dao);
        Tweet expectedTweet = JsonParser.toObjectFromJson(tweetJonsStr, Tweet.class);
        doReturn(expectedTweet).when(spyDao).findById(any());
        Tweet tweet = spyDao.findById("");
        assertNotNull(tweet);
        assertNotNull(tweet.getText());
        assertEquals(tweet.getText(), "test");
    }

    @Test
    public void deleteTweet() throws Exception {
        when(mockHelper.httpPost(isNotNull())).thenThrow(new RuntimeException("mock"));
        try {
            dao.deleteById("");
            fail();
        } catch (RuntimeException e) {
            assertTrue(true);
        }

        TwitterDao spyDao = Mockito.spy(dao);
        Tweet expectedTweet = JsonParser.toObjectFromJson(tweetJonsStr, Tweet.class);
        doReturn(expectedTweet).when(spyDao).deleteById(any());
        Tweet tweet = spyDao.deleteById("");
        assertNotNull(tweet);
        assertNotNull(tweet.getText());
        assertEquals(tweet.getText(), "dao_unit_test");
    }

}

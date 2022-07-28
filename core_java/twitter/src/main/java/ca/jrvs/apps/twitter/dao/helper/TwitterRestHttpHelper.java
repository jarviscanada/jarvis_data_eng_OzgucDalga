package ca.jrvs.apps.twitter.dao.helper;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.net.URI;

public class TwitterRestHttpHelper {

    public static void main(String[] args) throws Exception  {
        String consumerKey= System.getenv("consumerKey");
        String consumerSecret= System.getenv("consumerSecret");
        String accessToken= System.getenv("accessToken");
        String tokenSecret= System.getenv("tokenSecret");
        System.out.println(consumerKey+ "|" + consumerSecret+ "|" + accessToken+ "|" +tokenSecret+"|");
        // Creating components

        HttpHelper httpHelper = new TwitterHttpHelper(consumerKey,consumerSecret, accessToken, tokenSecret);
        HttpResponse response = httpHelper.httpPost(new URI("https://api.twitter.com//1.1/statuses/update.json?status=first_tweet2"));
        System.out.println(EntityUtils.toString(response.getEntity()));

    }


}

package ca.jrvs.apps.twitter.dao.helper;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.net.URI;

/**
 * Dependencies are specified as private number variables
 */
public class TwitterHttpHelper implements HttpHelper {
    private OAuthConsumer consumer;
    private HttpClient httpClient;

    public TwitterHttpHelper(String consumerKey, String consumerSecret,
                             String accessToken, String tokenSecret) {
        consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
        consumer.setTokenWithSecret(accessToken, tokenSecret);

        httpClient = new DefaultHttpClient();
    }
    public TwitterHttpHelper(){
        this(System.getenv("consumerKey"),System.getenv("consumerSecret"),
        System.getenv("accessToken"), System.getenv("tokenSecret"));
    }


    @Override
    public HttpResponse httpPost(URI uri) {
        HttpPost request= new HttpPost(uri);
        try {
            consumer.sign(request);
            return httpClient.execute(request);
        } catch (OAuthException | IOException e) {
            throw new RuntimeException("Failed to execute", e);
        }
    }

    @Override
    public HttpResponse httpGet(URI uri) {
        HttpGet request = new HttpGet(uri);
        try{
            consumer.sign(request);
            return httpClient.execute(request);
        }catch(OAuthException | IOException e) {
            throw new RuntimeException("Faile to execute ", e);
        }
    }
}
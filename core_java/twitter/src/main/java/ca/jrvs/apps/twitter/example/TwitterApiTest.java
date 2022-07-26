package ca.jrvs.apps.twitter.example;

import com.google.gdata.util.common.base.PercentEscaper;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.util.Arrays;

public class TwitterApiTest {

  private static String CONSUMER_KEY= System.getenv ("Z2x4yT6EFlGq7ko46Kkig5ba0");
  private static String CONSUMER_SECRET = System.getenv("N1K4BviusNHKjaw7vIyLV9Iex1bCV8ET4D55196nNiTqKZaa1z");
  private static String ACCESS_TOKEN =System.getenv("1529479207817977856-3KW3Q3QcFcvBrcK7ijDEy8fZSOIcQR");
  private static String TOKEN_SECRET = System.getenv("mkylqLYclnRJXksIlla8SyxKTlGCViW06iVTvby99ITLG");


  public static void main(String[] args)  throws Exception{

    //setup OAuth
    OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
    consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);

    //create an http request
    String status  = "Today is a good day";
    PercentEscaper percentEscaper = new PercentEscaper(  "",  false);
    HttpPost request = new HttpPost(
         "https://api.twitter.com/1.1/statueses/update.json?status=" +percentEscaper.escape(status));

    // sign the request(add headers);
      consumer.sign(request);

      System.out.println("Http Request Header");
      Arrays.stream(request.getAllHeaders()).forEach(System.out::println);

      //send the request
      HttpClient httpClient = HttpClientBuilder.create().build();
      HttpResponse response = httpClient.execute(request);
      System.out.println(EntityUtils.toString(response.getEntity()));
  }
}

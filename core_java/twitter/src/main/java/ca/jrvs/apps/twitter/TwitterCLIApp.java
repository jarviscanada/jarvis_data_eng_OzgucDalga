package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.controller.Controller;
import ca.jrvs.apps.twitter.controller.TwitterController;
import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.service.TwitterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TwitterCLIApp {
    public static final String USAGE = "USAGE: TwitterCLIApp post|show|delete [options]";

    private Controller controller;

    public TwitterCLIApp(Controller controller) {
        
    }

    @Autowired
    public void TwitterCLIApp(Controller controller) {
        this.controller = controller;
    }
    public static void main(String[] args){
        //get secret from env vars
        String consumerKey= System.getenv("consumerKey");
        String consumerSecret= System.getenv("consumerSecret");
        String accessToken= System.getenv("accessToken");
        String tokenSecret= System.getenv("tokenSecret");
        
        HttpHelper httpHelper= new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
        CrdDao dao = TwitterDao(httpHelper);
        Service service =  new TwitterService(dao);
        Controller controller= new TwitterController(service);
        TwitterCLIApp app = new TwitterCLIApp(controller);

        
        app.run(args);

    }

    // there is an error point here fix it
    private static CrdDao TwitterDao(HttpHelper httpHelper) {
        return (CrdDao) httpHelper;
    }


    public void run(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException(USAGE);
        }
        switch (args[0].toLowerCase()) {
            case "post":
                printTweet(controller.postTweet(args));
                break;
            case "show":
                printTweet(controller.showTweet(args));
                break;
            case "delete":
                controller.deleteTweet(args).forEach(this::printTweet);
                break;
            default:
                throw new IllegalArgumentException(USAGE);
        }
    }

    public void printTweet(Tweet tweet) {
        try {
            System.out.println(JsonParser.toJson(tweet,true,false));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert Tweet to JSON", e);
        }
    }
}

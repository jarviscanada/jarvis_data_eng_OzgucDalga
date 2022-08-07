package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.controller.Controller;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TwitterCliApp {
    public static final String USAGE = "USAGE: TwitterCLIApp post|show|delete [options]";

    private Controller controller;

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

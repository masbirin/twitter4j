/**
 * @(#)NamexTweet.java
 *
 *
 * @author 
 * @version 1.00 2018/5/14
 */


import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "zDsMgNRo9VvIxf43BJuN4H84K";
    private final static String CONSUMER_KEY_SECRET = "uzV2YGd6tcGKeY9FYt8H2CBTfhnA8AppaAj0dGVNvU1eScOi56";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("birin");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "VQQjUbyuNfcC745KVom8n82LjREYyxOCDY25JlSq6Fgyc";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "995972897024847872-TIycKvkaBjMYndLP7M6m1Voe53NYu2b";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}
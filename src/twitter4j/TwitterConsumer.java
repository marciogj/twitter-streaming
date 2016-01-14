package twitter4j;

import java.io.IOException;
import java.util.logging.Logger;

import twitter4j.auth.AccessToken;

public class TwitterConsumer {
	public static final String TWITTER_ACCOUNT = "email@domain";
	public static final String TWITTER_CONSUMER_KEY = "";
	public static final String TWITTER_CONSUMER_SECRET = "";
	public static final String TWITTER_ACCESS_TOKEN = "";
	public static final String TWITTER_ACCESS_TOKEN_SECRET = "";


	public static void main(String[] args) throws TwitterException, IOException{
		System.out.println("=========================================");
		System.out.println("twitter listener");
		System.out.println("=========================================");
		String[] keywordsArray = args;
		

		System.out.println("Requesting access to Twitter from " + TWITTER_ACCOUNT);
		AccessToken accessToken = new AccessToken(TWITTER_ACCESS_TOKEN, TWITTER_ACCESS_TOKEN_SECRET);
		System.out.print("Listening tweets composed by keywords: ");
		for (String word : keywordsArray) {
			System.out.print(word);
			System.out.print(", ");
		}
		System.out.println("");
		System.out.println("");
		

		StatusListener listener = new TwitterStatusListener();
		System.out.println("Authenticating twitter account with consumer credentials");
		TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
		twitterStream.setOAuthConsumer(TWITTER_CONSUMER_KEY, TWITTER_CONSUMER_SECRET);
		twitterStream.setOAuthAccessToken(accessToken);
		twitterStream.addListener(listener);


		FilterQuery filter = new FilterQuery();
		filter.track(keywordsArray);
		Logger.getGlobal().info("Listening Twitter Stream...");
		twitterStream.filter(filter);
	}
	
}
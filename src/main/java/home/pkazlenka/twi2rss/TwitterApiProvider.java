package home.pkazlenka.twi2rss;

import com.twitter.clientlib.TwitterCredentialsBearer;
import com.twitter.clientlib.api.TwitterApi;

public class TwitterApiProvider {
    private final TwitterApi apiInstance;
    private static TwitterApiProvider instance = null;

    private TwitterApiProvider(String bearer) {
        TwitterCredentialsBearer credentials = new TwitterCredentialsBearer(bearer);
        apiInstance = new TwitterApi();
        apiInstance.setTwitterCredentials(credentials);
    }

    private TwitterApi getApiInstance() {
        return apiInstance;
    }

    public static TwitterApi getApi(String bearer) {
        if (instance == null) {
            instance = new TwitterApiProvider(bearer);
        }
        return instance.getApiInstance();
    }
}

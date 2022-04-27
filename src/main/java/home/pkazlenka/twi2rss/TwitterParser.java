package home.pkazlenka.twi2rss;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.model.TweetSearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

import static java.lang.String.format;

@Component
public class TwitterParser {
    @Value("${twitter.author}")
    String author;
    //TODO: move bearer configuration to TwitterApiProvider singleton
    @Value("${twitter.bearer}")
    String bearer;

    public TweetSearchResponse getTweets() {
        String query = format("(from:%s) -is:retweet", author);
        OffsetDateTime startTime = OffsetDateTime.now().minusWeeks(1).plusMinutes(1);
        OffsetDateTime endTime = OffsetDateTime.now().minusSeconds(15);
        Integer maxResults = 10;
        String sortOrder = "recency";
        try {
            return TwitterApiProvider.getApi(bearer)
                    .tweets()
                    .tweetsRecentSearch(query, startTime, endTime,
                            null, null, maxResults, sortOrder, null, null, null, null, null, null, null, null);
        } catch (ApiException e) {
            System.err.println("Exception when calling TweetsApi#tweetsRecentSearch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
            return null;
        }
    }
}

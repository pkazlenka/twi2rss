package home.pkazlenka.twi2rss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LastXController {
    @Autowired
    TwitterParser twitterParser;

    @GetMapping("/last")
    public String getLast() {
        return twitterParser.getTweets().toJson();
    }
}

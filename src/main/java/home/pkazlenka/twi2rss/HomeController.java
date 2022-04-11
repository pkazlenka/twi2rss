package home.pkazlenka.twi2rss;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HomeController {
    @GetMapping
    public String helloGradle() {
        return "Hello Gradle!";
    }
}

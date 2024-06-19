package vrize.community.moviereview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@SpringBootApplication
public class MovieReviewBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieReviewBackendApplication.class, args);
    }
}

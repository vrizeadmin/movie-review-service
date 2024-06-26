package vrize.community.moviereview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaRepositories
public class MovieReviewServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieReviewServiceApplication.class, args);
    }
}

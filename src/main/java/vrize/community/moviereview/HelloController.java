package vrize.community.moviereview;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api")
@RestController
public class HelloController {

    @GetMapping("/say-hello")
    public String sayHello() {
        return "Hello";
    }

}

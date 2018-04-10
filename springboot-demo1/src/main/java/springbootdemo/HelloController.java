package springbootdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // inject via application.properties
    @Value("${greetings.message:some default value}")
    private String message;

    @RequestMapping
    public String index() {
        return message;
    }
}

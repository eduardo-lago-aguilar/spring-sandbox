package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/")
	public Greeting sayHi() {
		return new Greeting(123, "Hello world YES!!");
	}

}

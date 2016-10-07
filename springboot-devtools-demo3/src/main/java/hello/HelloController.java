package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private AtomicLong count = new AtomicLong(0L);

	@RequestMapping
	public Greeting sayHi() {
		return new Greeting(count.getAndIncrement(), "Hello world YES!!");
	}

}

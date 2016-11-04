package ae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	@Autowired
	GreetingsService gs;

	@Autowired
	@Qualifier("oldFashioned")
	GreetingsService oldGs;

	@RequestMapping(path = "/greeting")
	public String greeting() {
		return gs.greeting();
	}

	@RequestMapping(path = "/old")
	public String oldGreeting() {
		return oldGs.greeting();
	}
}

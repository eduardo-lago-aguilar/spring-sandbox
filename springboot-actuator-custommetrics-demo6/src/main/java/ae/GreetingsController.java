package ae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	@Autowired
	GreetingsService gs;

	@RequestMapping(path = "/greeting")
	public String greeting() {
		return gs.greeting();
	}
}

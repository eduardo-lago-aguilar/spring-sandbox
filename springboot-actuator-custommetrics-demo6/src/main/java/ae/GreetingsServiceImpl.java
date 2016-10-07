package ae;

import org.springframework.stereotype.Service;

@Service
public class GreetingsServiceImpl implements GreetingsService {

	// @Autowired
	// private CounterService counter;

	public String greeting() {
		// a la old fashioned
		// counter.increment("greetings_call_counter");
		return "Hi";
	}
}

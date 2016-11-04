package ae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

@Service
@Qualifier("oldFashioned")
public class OldFashionedGreetingsServiceImpl implements GreetingsService {

	@Autowired
	private CounterService counter;

	@Override
	public String greeting() {
		counter.increment("greetings_call_counter");
		return "Hi old fashioned";
	}

}

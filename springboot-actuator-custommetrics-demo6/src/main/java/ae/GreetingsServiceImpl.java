package ae;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GreetingsServiceImpl implements GreetingsService {

	@Override
	public String greeting() {
		return "Hi";
	}
}

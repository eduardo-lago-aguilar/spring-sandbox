package ae;

import static org.springframework.boot.actuate.health.Health.down;
import static org.springframework.boot.actuate.health.Health.up;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealth implements HealthIndicator {

	private static Random random = new Random();

	public Health health() {
		int guess = random.nextInt(100);
		Builder health = guess % 2 == 0 ? down() : up();
		return health.build();
	}

}

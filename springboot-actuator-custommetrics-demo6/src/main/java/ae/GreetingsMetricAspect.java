package ae;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingsMetricAspect {

	@Autowired
	CounterService counter;

	@AfterReturning(pointcut = "execution(* ae.GreetingsService.greeting(..))")
	public void afterCall() {
		counter.increment("greetings_ok");
	}
}

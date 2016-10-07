package ae;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

@RestController
public class MetricsController {

	@RequestMapping(path = "sayhi/{name}")
	@Timed
	public String sayHi(@PathVariable("name") String name) {
		return "hi " + name;
	}

}

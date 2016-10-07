package ae;

import static java.lang.String.format;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String TEMPLATE = "Hello, %s";

	@RequestMapping(path = "/greeting")
	public GreetingResource sayHi(@RequestParam(defaultValue = "world") String name) {
		GreetingResource greeting = new GreetingResource(format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).sayHi(name)).withSelfRel());
		return greeting;
	}
}

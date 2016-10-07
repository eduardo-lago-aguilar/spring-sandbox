package ae;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

public class GreetingResource extends ResourceSupport {

	@Getter
	private final String content;

	public GreetingResource(@JsonProperty String content) {
		this.content = content;
	}
}

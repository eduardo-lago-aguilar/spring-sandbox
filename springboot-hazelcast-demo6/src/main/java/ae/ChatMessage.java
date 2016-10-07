package ae;

import java.io.Serializable;

import lombok.Data;

@Data
public class ChatMessage implements Serializable {
	private final String content;
}

package ae;

import static java.lang.Math.random;
import static java.text.MessageFormat.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

	@Autowired
	private ChatService chat;

	@RequestMapping(path = "/send")
	public void send() {
		chat.send(new ChatMessage(format("hello {0}", random())));
	}

	@RequestMapping(path = "/receive")
	public ChatMessage receive() {
		return chat.receive();
	}

}

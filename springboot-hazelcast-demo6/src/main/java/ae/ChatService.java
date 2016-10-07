package ae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;

@Service
public class ChatService {

	@Autowired
	private HazelcastInstance hazelcast;

	public void send(ChatMessage msg) {
		hazelcast.getQueue("my_queue")
				.offer(msg);
	}

	public ChatMessage receive() {
		return (ChatMessage) hazelcast.getQueue("my_queue")
				.poll();
	}
}

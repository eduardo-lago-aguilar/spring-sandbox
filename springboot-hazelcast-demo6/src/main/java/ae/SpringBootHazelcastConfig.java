package ae;

import static java.util.Arrays.asList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MapConfig;

@Configuration
public class SpringBootHazelcastConfig {

	@Bean
	public Config config() {
		// using a Hazelcast cluster config
		MapConfig mapConfig = new MapConfig().setName("messages")
				.setEvictionPolicy(EvictionPolicy.LRU)
				.setTimeToLiveSeconds(60);
		Config config = new Config();

		JoinConfig join = getJoin();

		config.getNetworkConfig()
				.setJoin(join);

		config.addMapConfig(mapConfig);
		return config;
	}

	protected JoinConfig getJoin() {
		JoinConfig join;
		join = new JoinConfig();

		join.getMulticastConfig()
				.setEnabled(false);

		join.getTcpIpConfig()
				.setEnabled(true)
				.setMembers(asList("192.168.1.113", "192.168.1.124"));
		return join;
	}
}

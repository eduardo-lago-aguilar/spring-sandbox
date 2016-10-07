package ae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.metrics.repository.InMemoryMetricRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MetricsExporterApp {

	public static void main(String[] args) {
		SpringApplication.run(MetricsExporterApp.class, args);
	}

	@Bean
	public InMemoryMetricRepository mr() {
		return new InMemoryMetricRepository();
	}
}

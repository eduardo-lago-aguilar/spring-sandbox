package ae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

@SpringBootApplication
@EnableMetrics(proxyTargetClass = true)
public class MetricsApp {

	@Bean
	MetricsConfigurerAdapter metricsConfigurerAdapter() {
		return new BaseMetricsConfigurerAdapter();
	}

	public static void main(String[] args) {
		SpringApplication.run(MetricsApp.class, args);
	}
}

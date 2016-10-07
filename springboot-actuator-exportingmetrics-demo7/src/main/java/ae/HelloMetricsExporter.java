package ae;

import static net.logstash.logback.marker.Markers.append;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.boot.actuate.metrics.repository.MetricRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class HelloMetricsExporter {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloMetricsExporter.class);

	@Autowired
	MetricRepository actuatorMetricRepository;

	@Scheduled(initialDelay = 5000, fixedDelay = 1000)
	public void export() {
		actuatorMetricRepository.findAll()
				.forEach(this::log);
		System.out.println("reporting...");
	}

	public void log(Metric<?> capture) {

		LOGGER.info(append("metric", capture), "Reporting metric {}={}", capture.getName(), capture.getValue());
	}
}

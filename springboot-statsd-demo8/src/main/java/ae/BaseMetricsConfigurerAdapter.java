package ae;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.readytalk.metrics.StatsDReporter;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

public class BaseMetricsConfigurerAdapter extends MetricsConfigurerAdapter {

	@Override
	public void configureReporters(MetricRegistry metricRegistry) {

		// configure statsd reporter for metric registry
		StatsDReporter.forRegistry(metricRegistry)
				.prefixedWith("ae.metrics.demo")
				.build("localhost", 8125)
				.start(10000, MILLISECONDS);

		// log to console for development purposes
		ConsoleReporter.forRegistry(metricRegistry)
				.build()
				.start(10000, MILLISECONDS);
	}

}

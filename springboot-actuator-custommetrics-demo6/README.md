# Spring Boot Actuator Custom Metrics Demo 6

## Goal 
Bootstrap an Spring Boot REST service with complementary service for collecting custom metrics about your application. Actuator is extended to include metrics defined by user. 

Two implementations are provided, one using the aspects to calculate the metrics and the other a la old fashioned code-pluming style.  


## Launch using Maven:

`$ mvn spring-boot:run`

## Launch using java
`mvn package  && java -jar target/springboot-actuator-custommetrics-demo6-0.0.1-SNAPSHOT.jar`

## Testing the service
When `http://localhost:8080/greeting` is reached via `GET` a simple `Hi` string reply is sent to client, and a custom metrics `counter.greetings_ok` is updated.  
```
$ curl http://localhost:8080/greeting
Hi
```

## Test metrics and environmental info of boot app 
There are many endpoints provided by Actuator once the application is launched:

### health
Notice the `customHealth` status established to `UP` or `DOWN` depending on service developer decision, current implementation provides the status randomly.
```
$ curl http://localhost:8080/health
{"status":"UP","customHealth":{"status":"UP"},"diskSpace":{"status":"UP","total":123918757888,"free":10684481536,"threshold":10485760}}
...
$ curl http://localhost:8080/health
{"status":"DOWN","customHealth":{"status":"DOWN"},"diskSpace":{"status":"UP","total":123918757888,"free":10684387328,"threshold":10485760}}
```

### metrics
Metrics about memory, heap, etc. for the currently running application. The user defined metric is also returned in the `JSON` object: `counter.greetings_ok`.

```
$ curl http://localhost:8080/metrics
{
	"mem":592596,
	"mem.free":492506,
	"processors":4,
	"instance.uptime":921348,
	"uptime":925671,
	"systemload.average":0.33,
	"heap.committed":541184,
	"heap.init":247808,
	"heap.used":48677,
	"heap":3522560,
	"nonheap.committed":53952,
	"nonheap.init":2496,
	"nonheap.used":51416,
	"nonheap":0,
	"threads.peak":21,
	"threads.daemon":19,
	"threads.totalStarted":25,
	"threads":21,
	"classes":6489,
	"classes.loaded":6489,
	"classes.unloaded":0,
	"gc.ps_scavenge.count":9,
	"gc.ps_scavenge.time":119,
	"gc.ps_marksweep.count":2,
	"gc.ps_marksweep.time":158,
	"httpsessions.max":-1,
	"httpsessions.active":0,
	"gauge.response.greeting":4.0,
	"gauge.response.health":2.0,
	"gauge.response.metrics":2.0,
	"gauge.response.star-star":16.0,
	"counter.status.200.metrics":3,
	"counter.status.404.star-star":1,
	"counter.status.200.health":6,
	"counter.status.503.health":2,
	"counter.greetings_ok":2,
	"counter.status.200.greeting":2
}
```



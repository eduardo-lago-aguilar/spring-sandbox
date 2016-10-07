# Spring Boot Actuator Demo 5

## Goal 
Bootstrap an Spring Boot REST service with complementary services for collecting metrics about your application. The demo
shows up how to collect different metrics using the Spring Boot Actuator features. 

## Launch using Maven:

`$ mvn spring-boot:run`

## Launch using java
`$ mvn package && java -jar target/springboot-actuator-demo5-0.1.0.jar `

## Test it
```
$ curl http://localhost:8080
{"id":123,"message":"Hello world YES!!"}
```

## Test metrics and environmental info of boot app 
There are many endpoints provided by Actuator once the application is launched:

### health
```
$ curl http://localhost:8081/health
{"status":"UP","diskSpace":{"status":"UP","total":123918757888,"free":14205902848,"threshold":10485760}}
```

### autoconfig
Auto-configuration details
```
$ curl http://localhost:8081/autoconfig
{
	"positiveMatches": {
		"AuditAutoConfiguration#auditListener": [{
			"condition": "OnBeanCondition",
			"message": "@ConditionalOnMissingBean (types: org.springframework.boot.actuate.audit.listener.AbstractAuditListener; SearchStrategy: all) found no beans"
		}],
	"AuditAutoConfiguration.AuditEventRepositoryConfiguration": [{
		"condition": "OnBeanCondition",
		"message": "@ConditionalOnMissingBean (types: org.springframework.boot.actuate.audit.AuditEventRepository; SearchStrategy: all) found no beans"
		}],
	...
}		
```

### beans
All beans loaded by the application:
```
$ curl http://localhost:8081/beans
[
	{
		"context": "application",
		"parent": null,
		"beans": [
			{
				"bean": "helloWorldConfiguration",
				"scope": "singleton",
				"type": "hello.HelloWorldConfiguration$$EnhancerBySpringCGLIB$$87db183a",
				"resource": "null",
				"dependencies": []
			},
			{
				"bean": "org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory",
				"scope": "singleton",
				"type": "org.springframework.core.type.classreading.CachingMetadataReaderFactory",
				"resource": "null",
				"dependencies": []
			},
			{
				"bean": "helloController",
				"scope": "singleton",
				"type": "hello.HelloController",
				"resource": "URL [jar:file:springboot-actuator-demo5-0.1.0.jar!/BOOT-INF/classes!/hello/HelloController.class]",
				"dependencies": []
			}
			...			
]
```

### configprops
```
$ curl http://localhost:8081/configprops
{
	"endpoints-org.springframework.boot.actuate.endpoint.EndpointProperties": {
		"prefix": "endpoints",
		"properties": {
			"enabled": true,
			"sensitive": null
		}
	},
	"management.info-org.springframework.boot.actuate.autoconfigure.InfoContributorProperties": {
		"prefix": "management.info",
		"properties": {
			"git": {
				"mode": "SIMPLE"
			}
		}
	},
	"metricsEndpoint": {
		"prefix": "endpoints.metrics",
		"properties": {
			"id": "metrics",
			"sensitive": true,
			"enabled": true
		}
	},
...
}
```

### dump
Thread dump

```
$ curl http://localhost:3000/dump
{
	"endpoints-org.springframework.boot.actuate.endpoint.EndpointProperties": {
		"prefix": "endpoints",
		"properties": {
			"enabled": true,
			"sensitive": null
		}
	},
	"management.info-org.springframework.boot.actuate.autoconfigure.InfoContributorProperties": {
		"prefix": "management.info",
		"properties": {
			"git": {
				"mode": "SIMPLE"
			}
		}
	},
	"metricsEndpoint": {
		"prefix": "endpoints.metrics",
		"properties": {
			"id": "metrics",
			"sensitive": true,
			"enabled": true
		}
	},
...
}
```

### env
Retrieves the Spring properties

```
$ curl http://localhost:8081/env
{
	"profiles": [],
	"server.ports": {
		"local.management.port": 8081,
		"local.server.port": 8080
	},
	"servletContextInitParams": {
		
	},
	"systemProperties": {
		"java.runtime.name": "Java(TM) SE Runtime Environment",
		"java.protocol.handler.pkgs": "null|org.springframework.boot.loader",
...
}
```

### info 
Displays application information like version, description, etc.

### metrics
Metrics about memory, heap, etc. for the currently running application

### mappings
Displays a list of all @RequestMapping paths.

### shutdown
This endpoint allows to shutdown the application. This is not enabled by default.

### trace
Displays trace information for the current application.

### logfile 
Provides access to the configured log files

### flyway
This endpoint provides the details of any flyway database migrations have been applied

### liquibase
This endpoint provides the details of any liquibase database migrations have been applied

## Change settings
Change Actuator management settings at `src/main/resources/application.properties`

## Change security settings
Actuator security settings can customized at `src/main/resources/application.properties`

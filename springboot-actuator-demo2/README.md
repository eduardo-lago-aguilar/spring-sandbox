# Spring Boot Actuator Demo 1

## Goal 
Bootstrap an Spring Boot REST service with complementary health service 

## Launch using Maven:

`$ mvn spring-boot:run`

## Launch using java
`$ java -jar target/springboot-demo1-0.0.1-SNAPSHOT.jar`

## Test it
```
$ curl http://localhost:8080
{"id":123,"message":"Hello world YES!!"}
```

## Test health
```
$ curl http://localhost:8080/health
{"status":"UP","diskSpace":{"status":"UP","total":123918757888,"free":14205902848,"threshold":10485760}}
```

# Spring Boot Dev Tools Demo 3

## Goal 
Bootstrap an Spring Boot REST service with hotswapping capabilities 

## Launch using Maven:

`$ mvn spring-boot:run`

## Test it
```
$ curl http://localhost:8080
{"id":123,"message":"Hello world YES!!"}
```

## Test hotswapping
Only works using Maven launch:

```
$ mvn spring-boot:run 
$ watch curl http://localhost:8080
{"id":123,"message":"Hello world YES!!"}
```

Then change the `HelloController#sayHi()` return message, and save (using Eclipse), the changes should be reloaded. For IntelliJ check for [Intellij IDEA – Spring boot template reload is not working](https://www.mkyong.com/spring-boot/intellij-idea-spring-boot-template-reload-is-not-working/)

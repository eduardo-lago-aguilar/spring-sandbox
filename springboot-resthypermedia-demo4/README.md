# Spring Boot Hypermedia-Driven RESTful Web Service Demo 4

## Goal 
Bootstrap an Spring Boot REST service with Hypermedia Links.

Hypermedia is an important aspect of REST. It allows you to build services that decouple client and server to a large extent and allow them to evolve independently. The representations returned for REST resources contain not only data, but links to related resources. Thus the design of the representations is crucial to the design of the overall service. 

## Launch using Maven:

`$ mvn spring-boot:run`

## Test it
```
$ curl http://localhost:8080/greeting?name=ed
{"content":"Hello, world","_links":{"self":{"href":"http://localhost:8080/greeting?name=world"}}}
```

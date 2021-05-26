# 4W_Movies
API for fetching movie data

## How to run
1. put you API key to application.properties file under key 'provider.api.key'
2. execute it from IDE of your choice as standard Spring Boot application 

Swagger is available under standard url /swagger-ui.html 
e.g http://localhost:8080/swagger-ui.html

## Technology stack
Kotlin

Spring (Web,Data,JPA)

H2 - in memory database

Swagger

## Ideas
Packages were organised with business process encapsulation in mind. In this particular project no JPA advanced features were used, in production code I would use no-sql DB instead of H2 - it has been used to ease off configuration and execution.
There are not many unit tests - business logic is minimal, therefore integration tests using SpringBoot/TestRestTemplate were better option. 


## Possible further development
better error handling (descriptive error message instead of raw exception)

securing /internal endpoint with Spring Security

introduction of separate Spring profiles (dev/production)

replacing h2 with 'real' DB if production profile was used
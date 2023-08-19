# PoC: Projeto Spring com Java 17, Spring Boot 3.x, Mongo e TestContainers

## Stack
- API Rest
- Spring `3.1.2`
- Java `17`
- Spring Data
- MongoDB
- JUnit `5`
- TestConainers
- Docker | Docker Compose
- Lombok

## Objetivo
- [x] Implementar uma `API REST` com Spring usando boas práticas.
- [x] Implementar um `Repository` usando Spring Data `MongoRepository`.
- [ ] Implementar Testes Integrados usando `TestContainers`.

## Motivações
- Usar a nova versão do `Spring 6` com `Spring Boot 3.X` e testar novas funcionalidades.
  - [ ] GraalVM Native Image Support
  - [ ] OpenTelemetry
  - [ ] Integração do Spring com TestContainers
- Usar `Java 17` com novos recursos como:
  - [x] Record
  - [ ] Sealed Classes
  - [ ] Pattern Matching para Switch
  - [ ] Inferência de variáveis
  - [ ] Switch expression
  - [ ] HTTP 2 Client Async
- Usar uma abordagem mais `Funcional` para praticar o paradigma e os recursos que o Java oferece para isso.
- Usar a lib `TestContainers` para gerenciar os Containers Docker durante os Testes Integrados. 

## Referecias 
- [Hypertext Transfer Protocol (HTTP/1.1): Semantics and Content](https://www.rfc-editor.org/rfc/rfc7231)
- [Common Application Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html)
- [Spring Academy - Building a REST API with Spring Boot](https://spring.academy/courses/building-a-rest-api-with-spring-boot)
- [TestContainers SpringBoot Quickstart](https://github.com/testcontainers/testcontainers-java-spring-boot-quickstart)
- [DB Integration Tests with Spring Boot and Testcontainers](https://www.baeldung.com/spring-boot-testcontainers-integration-test)

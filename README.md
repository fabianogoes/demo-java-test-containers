# PoC: Projeto Spring com Java, Mongo e TestContainers

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
- [x] Implementar uma `API REST` com Spring
- [x] Implementar um `Repository` usando Spring Data `MongoRepository`
- [ ] Implementar Testes Integrados usando `TestContainers`

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
- Usar uma abordagem mais funcional
- Usar a lib `TestContainers` para gerenciar os Containers Docker durante os Testes Integrados. 

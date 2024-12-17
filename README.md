# API Notificações
API RESTful desenvolvida com Spring Boot para consumir os dados de uma fila do RabbitMQ, enviar um e-mail de boas-vindas ao usuário e demonstrar o funcionamento de mensageria entre duas APIs.

## Tecnologias utilizadas:
 * Java 21
 * Spring Boot
 * Spring Mail
 * Maven
 * JPA / Hibernate
 * Swagger
 * H2
 * RabbitMQ

## Funcionalidade:
A API de Notificações consome as informações enviadas pelo API Pessoas da fila, processa os dados recebidos e envia um e-mail de boas-vindas ao usuário utilizando o Spring Mail. Depois de enviar o e-mail, um log é registrado no banco de dados.

## Como executar o projeto:

### Requisitos
* Java 21+
* Spring Boot 3.4.0+
* Um servidor de mensageria no CloudAMQP

#### 1. Clone o repositório
```bash
   git clone https://github.com/samuelmsilva2v/apiNotificacoes.git
   cd apiNotificacoes
```
#### 2. Instale as dependências e compile o projeto com Maven:
```bash
./mvnw clean install
```
#### 3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

A aplicação vai rodar em http://localhost:8081/swagger-ui/index.html#

Caso seja necessário configure `app.properties` com os dados necessários para utilizar o Spring Mail
```properties
spring.mail.host=smtp-mail.outlook.com
spring.mail.port=587
spring.mail.username=
spring.mail.password=
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

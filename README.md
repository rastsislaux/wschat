# WsChat

This is a simple chat implemented in Kotlin, using Spring Boot.<br>
Functionality:
 - Login as a user (no authentication required)
 - Send/receive messages using WebSocket protocol
 - Search for messages with full-text search (using ElasticSearch)

## Tech stack
 - Kotlin
 - Spring Boot (Data Elasticsearch, WebSocket)
 - Elasticsearch
 - Angular Framework (Front-end)

## Quick start

1. Install JRE 17
2. Build backend application with
```$ ./gradlew build```
3. Run the backend application with ```$ java -jar {PROJECT_DIR}/build/libs/wschat-0.0.1-SNAPSHOT.jar```
4. Install NodeJS (try using Node Version Manager)
5. Install needed dependencies with ```$ npm install```
6. Run frontend application with ```$ ng server```

Congratulations! Now you can use this chat if you go to `http://localhost:4200`
FROM eclipse-temurin:17-jre-alpine AS builder
WORKDIR app/
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew build

FROM eclipse-temurin:17-jre-alpine
WORKDIR app/
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

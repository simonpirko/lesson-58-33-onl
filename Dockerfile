FROM maven:3.9.11-eclipse-temurin-21-alpine AS build-jar
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:21-slim
COPY --from=build-jar /target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
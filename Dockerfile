# Use an official OpenJDK 17 runtime as a parent image
FROM maven:3.8-openjdk-17-slim AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests


FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/nexus-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
#CMD ["tail", "-f", "/dev/null"]

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

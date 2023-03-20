# Use an official Java runtime as a parent image
FROM openjdk:17-alpine

VOLUME /temp

ARG JAR_FILE=target/demospringboot-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the Spring Boot application when the container is started
ENTRYPOINT ["java","-jar", "/app.jar"]
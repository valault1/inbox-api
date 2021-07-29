# Note: run with command: 
# docker build -t springio/inbox-spring-boot-docker .
# docker run -p 8085:8085 springio/inbox-spring-boot-docker

#FROM jdk-11.0.11_9-alpine
FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
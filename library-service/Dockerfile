FROM --platform=linux/amd64/v4 amazoncorretto:17-alpine-jdk AS build
ARG JAR_FILE=target/library-service.jar
COPY ${JAR_FILE} library-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/library-service.jar"]

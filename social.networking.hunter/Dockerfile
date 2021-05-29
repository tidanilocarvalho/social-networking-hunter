FROM openjdk:8-jdk-alpine
RUN addgroup -S danilo && adduser -S danilo -G danilo
USER danilo:danilo
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
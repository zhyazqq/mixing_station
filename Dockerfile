FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
#ADD user-server-0.0.1-SNAPSHOT.jar app.jar
COPY ${JAR_FILE} app.jar
ENV url=''
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
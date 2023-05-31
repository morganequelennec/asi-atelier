FROM openjdk:17.0.2-jdk

VOLUME /tmp
ARG JAR_FILE=target/cardgame-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
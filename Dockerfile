#
# Build stage
#
FROM maven:3.6.3-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true

#
# Package stage
#
FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=/home/app/target/*.jar
#COPY --from=build ${JAR_FILE} application.jar
COPY target/social-network-gateway-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
EXPOSE 9090
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /application.jar"]
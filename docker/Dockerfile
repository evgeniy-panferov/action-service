FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} action-service-admitad.jar
CMD ["java", "-jar", "/action-service-admitad.jar"]
FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} discount-service.jar
CMD ["java", "-jar", "/discount-service.jar"]
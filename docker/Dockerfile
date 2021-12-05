FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} coupon-service-admitad.jar
CMD ["java", "-jar", "/coupon-service-admitad.jar"]
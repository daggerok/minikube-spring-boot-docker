FROM openjdk:8u131-jre-alpine
MAINTAINER Maksim Kostromin "daggerok@gmail.com"
COPY build/libs/ /opt/apps/
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/opt/apps/minikube-spring-boot-docker-latest.jar"]
VOLUME ["/tmp"]

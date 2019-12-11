FROM maven:3.6-jdk-8 AS build
COPY imageCo/src /imageCo/src
COPY imageCo/pom.xml /imageCo
WORKDIR imageCo
EXPOSE 8080
CMD mvn spring-boot:run


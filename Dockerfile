FROM maven:3.6.0-jdk-11-slim AS build
RUN mvn -f /home/app/pom.xml clean package
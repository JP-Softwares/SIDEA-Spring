FROM maven:4.0.0 AS build
RUN mvn -f ./pom.xml clean package
#
# Build stage
#
FROM maven:4.0.0 AS build
COPY src ./src
COPY pom.xml ./
RUN mvn -f ./pom.xml clean package
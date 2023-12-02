#
# Build stage
#
FROM maven:4.0.0-openjdk:17-oracle AS build
COPY src ./src
COPY pom.xml ./
RUN mvn -f ./pom.xml clean package

#
# Package stage
#
FROM openjdk:17-oracle
COPY --from=build ./target/sidea-0.0.1-SNAPSHOT.jar ./demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","./demo.jar"]
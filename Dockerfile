### Build
FROM maven:3.8.3-openjdk-21 AS build
WORKDIR /app

COPY clarity/pom.xml .
RUN mvn -B dependency:resolve dependency:resolve-plugins

COPY clarity/src src
RUN mvn package



### Run
FROM openjdk:21
WORKDIR /app

COPY --from=build /app/target/clarity/*.jar .

CMD ["java", "-jar", ""]

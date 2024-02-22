# Build
FROM maven:3.9.6-amazoncorretto-21 AS build
WORKDIR /app

COPY clarity/pom.xml .
RUN mvn -B dependency:resolve dependency:resolve-plugins

COPY clarity/src src
RUN mvn package



# Run
FROM amazoncorretto:21 As run
WORKDIR /app

COPY clarity/lib /app/lib
COPY --from=build /app/target/clarity-1.0-SNAPSHOT-jar-with-dependencies.jar .
VOLUME /app/input

ENTRYPOINT ["java", "-jar", "clarity-1.0-SNAPSHOT-jar-with-dependencies.jar", "/app/input" ]

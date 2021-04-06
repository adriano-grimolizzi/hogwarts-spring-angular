FROM maven:alpine

COPY . .

RUN ["mvn", "package", "-DskipTests"]

CMD ["java", "-jar", "/target/hogwarts-server-0.0.1-SNAPSHOT.jar"]
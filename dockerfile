FROM openjdk:17-jdk-alpine

WORKDIR /app

RUN apk add --no-cache maven

COPY . .

RUN mvn clean install

EXPOSE 8080

CMD ["java", "-jar", "target/BOARD-API-0.0.1-SNAPSHOT.jar"]
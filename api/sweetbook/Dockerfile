FROM openjdk:11-jre-slim
WORKDIR /app
COPY ./api/sweetbook/target/sweetbook-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "/app/sweetbook-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
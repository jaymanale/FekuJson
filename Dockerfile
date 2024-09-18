# Stage 1: Build the Spring Boot application
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Create the final Docker image
FROM prasadlvi/openjdk-17-jre

WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/Mockify-API-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port your Spring Boot application listens on
EXPOSE 8080


# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]

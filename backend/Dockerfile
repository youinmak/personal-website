# Stage 1: Build the application
# We use a full Maven image to build the JAR file
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy only the pom.xml first to leverage Docker layer caching for dependencies
COPY pom.xml .
COPY src ./src

# Build the JAR, skipping tests for faster builds in CI/CD
RUN mvn clean package -DskipTests

# Stage 2: Run the application
# We use a lightweight JRE image for the runtime
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Create a non-privileged user to run the app
# This is a security best practice to prevent root access if the container is compromised
RUN addgroup --system spring && adduser --system --group spring
USER spring:spring

# Copy the compiled JAR from the build stage with correct ownership
COPY --from=build --chown=spring:spring /app/target/*.jar app.jar

# Spring Boot default port
EXPOSE 8080

# Execute the application
ENTRYPOINT ["java", "-jar", "app.jar"]

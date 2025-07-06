# Build Stage (Java 21)
# Uses Maven with Java 21 for building
# Creates and sets /app as working directory
# Copies project files into container
# Makes Maven wrapper executable
# Builds the JAR file
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Runtime Stage (Java 21)
# Uses Eclipse Temurin JDK 21 Alpine for a lightweight runtime
# Sets /app as working directory
# Copies the built JAR file from the build stage
# Exposes port 8080
# Sets the active Spring profile to 'docker'
# Sets the entry point to run the JAR file
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE=docker
ENTRYPOINT ["java", "-jar", "app.jar"]

# First stage: Build the application using Maven
FROM maven:3.9-eclipse-temurin-21-alpine AS build

# Set the working directory
WORKDIR /app

# Copy the Maven build file and the source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Second stage: Create the final image with JRE
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

# Copy the built jar file from the first stage
COPY --from=build /app/target/k8sapp-0.0.1-SNAPSHOT.jar /app/k8sapp.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/k8sapp.jar"]
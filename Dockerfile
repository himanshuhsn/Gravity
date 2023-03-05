## Build the application
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn package -DskipTests

## Package the Application
FROM openjdk:11-jdk-slim

# Create user to run app (instead of root user)
RUN adduser --system --group app

# Use user "app"
USER app

# Copy the jar file into the docker image
COPY --from=build target/*.jar app.jar

# Access the app through port 8080
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
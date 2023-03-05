FROM openjdk:11-jdk-slim

# Set the environemnt variable
ENV CROSS_ORIGIN_ALLOW_URL "https://www.logigame.tk"

# Create user to run app (instead of root user)
RUN adduser --system --group app

# Use user "app"
USER app

# Copy the jar file into the docker image
COPY target/*.jar app.jar

# Access the app through port 8080
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
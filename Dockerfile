FROM openjdk:17-jdk-alpine

# Set the environemnt variable
ENV CROSS_ORIGIN_ALLOW_URL "https://www.logigame.tk"

# Create user to run app (instead of root user)
RUN addgroup -S app && adduser -S app -G app

# Use user "app"
USER app

# Copy the jar file into the docker image
COPY target/*.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
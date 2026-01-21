FROM eclipse-temurin:21-jre
WORKDIR /app
# This copies the JAR from your Mac's target folder into the container
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
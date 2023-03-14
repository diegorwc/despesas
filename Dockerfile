FROM maven:latest AS build
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean test package -DskipTests

FROM eclipse-temurin:17-jre
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]


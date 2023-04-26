FROM adoptopenjdk/openjdk11:latest

WORKDIR /backend

COPY target/*.jar ./backend.jar

CMD ["java", "-jar", "backend.jar"]
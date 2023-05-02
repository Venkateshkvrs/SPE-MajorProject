#FROM openjdk:latest
#ADD ./target/E-bill-pay-0.0.1-SNAPSHOT.jar E-bill-pay-0.0.1-SNAPSHOT.jar
#EXPOSE 5000
#ENTRYPOINT ["java", "-jar", "E-bill-pay-0.0.1-SNAPSHOT.jar"]

FROM openjdk
COPY ./target/E-bill-pay-0.0.1-SNAPSHOT.jar ./
CMD ["java", "-jar", "E-bill-pay-0.0.1-SNAPSHOT.jar"]
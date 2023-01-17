# baase docker image
FROM openjdk:17
ADD build/libs/pay-gate-0.0.1-SNAPSHOT.jar pay-gate-docker.jar
ENTRYPOINT ["java", "-jar","pay-gate-docker.jar"]
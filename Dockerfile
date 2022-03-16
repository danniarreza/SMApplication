FROM adoptopenjdk/openjdk11
COPY /build/libs/SMA-0.0.1-SNAPSHOT.jar .
CMD java -jar SMA-0.0.1-SNAPSHOT.jar
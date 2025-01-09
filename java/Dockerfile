##use maven 3 and jdk 17 for building the app
FROM maven:3.8.3-openjdk-17-slim AS BUILD

#use JDk 17 for build
#
COPY . /usr/src/app
RUN mvn --batch-mode -f /usr/src/app/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jre
ENV PORT 8080
EXPOSE 8080
COPY --from=BUILD /usr/src/app/target /opt/target
WORKDIR /opt/target

CMD ["/bin/bash", "-c", "find -type f -name 'apmdemo.jar' | xargs java -jar"]

FROM gradle:jdk11 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/usr/app/
RUN mkdir -p $APP_HOME/src/main/java
WORKDIR $APP_HOME
COPY ../../../build.gradle settings.gradle gradlew gradlew.bat $APP_HOME
COPY ../../../gradle $APP_HOME/gradle
RUN ./gradlew build -x test || return 0
COPY src/main/docker .
RUN ./gradlew build -x test

FROM adoptopenjdk/openjdk8-openj9
MAINTAINER Ochieng Olanga "o@o.com"
ENV ARTIFACT_NAME=greetings-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE /usr/app/build/libs/$ARTIFACT_NAME app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Xms128m","-Xmx256m","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
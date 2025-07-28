#FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
#COPY *.jar authenticator-app.jar
#ENV JAVA_OPTS=" -Xshareclasses:name=cacheapp,cacheDir=/cache,nonfatal -XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
## Replace with a non-root user to avoid running the container with excessive privileges
#USER appuser
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar authenticator-app.jar" ]

from gradle:8.14-jdk17-corretto as builder
WORKDIR /usr/app
COPY build.gradle main.gradle settings.gradle gradle.properties lombok.config ./
COPY applications ./applications
COPY domain ./domain
COPY infrastructure ./infrastructure
RUN gradle bootJar --no-daemon --info --stacktrace

from eclipse-temurin:17-jdk-alpine
ENV APP_HOME=/usr/app
ENV JAR_FILE=authenticator-app.jar
ENV JAVA_OPTS='-XX:+UseContainerSupport -XX:MaxRAMPercentage=70'
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR $APP_HOME

COPY --from=builder $APP_HOME/applications/app-service/build/libs/*.jar $JAR_FILE
USER appuser

EXPOSE 9000

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar $JAR_FILE"]

FROM openjdk:11
ARG JAR_FILE=*.jar
ARG CFG_FILE=*.yaml
COPY ${JAR_FILE} app.jar
COPY ${CFG_FILE} /var/application.yaml
ENTRYPOINT ["java","-jar","/app.jar","--spring.config.location=/var/application.yaml"]

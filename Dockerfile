FROM amazoncorretto:21-alpine3.16

WORKDIR /workspace/app

RUN mkdir logs

COPY target/*.jar app.jar

EXPOSE 80

ENTRYPOINT ["sh", "-c", "java -jar app.jar"]

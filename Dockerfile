FROM openjdk:11
VOLUME /tmp
ADD target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]

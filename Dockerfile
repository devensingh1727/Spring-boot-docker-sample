FROM openjdk:17

EXPOSE 8080
ADD target/Spring-boot-docker-application.war /app/deven/

WORKDIR /app/deven

ENTRYPOINT ["java", "-jar", "/app/deven/Spring-boot-docker-application.war"]
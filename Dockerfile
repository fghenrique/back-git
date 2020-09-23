FROM openjdk:14
VOLUME /tmp
EXPOSE 7777
ADD ./build/libs/apigit-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","oauth.jar"]
FROM openjdk:23-jdk
ADD target/userhub.jar userhub.jar
ENTRYPOINT ["java","-jar","/userhub.jar","-Dspring.profiles.active=dev"]

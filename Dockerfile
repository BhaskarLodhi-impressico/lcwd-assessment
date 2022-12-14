FROM openjdk:17
EXPOSE 8080
ADD target/lcwd-assessment.jar lcwd-assessment.jar
ENTRYPOINT ["java","-jar","lcwd-assessment.jar"]

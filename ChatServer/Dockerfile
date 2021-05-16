FROM adoptopenjdk/openjdk15
ADD target/ChatService-0.0.1-SNAPSHOT.jar chat.jar
EXPOSE 8185
ENTRYPOINT ["java", "-jar", "chat.jar"]
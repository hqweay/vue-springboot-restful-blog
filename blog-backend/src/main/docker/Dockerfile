FROM aglover/java8-pier
VOLUME ["/tmp"]
ADD blog-backend-1-0.jar blog-backend-docker.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
EXPOSE 8082
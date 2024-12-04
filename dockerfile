FROM amazoncorretto:21 AS base
COPY ./target/demo-*.jar /opt/app/app.jar
FROM scratch
COPY --from=base / /
ENV PATH="$PATH:/opt/java/openjdk/bin"
EXPOSE 8080
CMD sleep 30 && java -jar /opt/app/app.jar
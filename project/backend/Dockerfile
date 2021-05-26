FROM maven:3-jdk-11 AS build
WORKDIR /app
COPY . .
RUN --mount=type=cache,target=/root/.m2 mvn clean package

FROM openjdk:11-jre
WORKDIR /app
COPY --from=build /app/target/thin/root/repository ./repository
COPY --from=build /app/target/thin/root/*.jar ./app.jar
RUN java -jar app.jar --thin.root=/app --thin.dryrun=true --thin.debug=true
CMD java -jar app.jar --thin.root=/app

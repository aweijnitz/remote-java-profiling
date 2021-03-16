FROM openjdk:8

EXPOSE 8080
EXPOSE 7474
EXPOSE 7687


WORKDIR /app
COPY ./target/*.jar /app/app.jar

ENTRYPOINT ["java", "-Xms128M","-Xmx256M","-Xdebug", "-Djava.rmi.server.hostname=localhost","-Dcom.sun.management.jmxremote.rmi.port=7687","-Xrunjdwp:transport=dt_socket,address=7575,server=y,suspend=n", "-Dcom.sun.management.jmxremote", "-Dcom.sun.management.jmxremote.port=7474", "-Dcom.sun.management.jmxremote.ssl=false", "-Dcom.sun.management.jmxremote.authenticate=false", "-Dcom.sun.management.jmxremote.local.only=false", "-jar","/app/app.jar"]
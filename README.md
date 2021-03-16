# Java Remote Profiling Test Project

This project is intended for testing how to attach a Java profiler, like VisualVM, to a remote Java process, 
running in a Docker container.

## Building and Running the Docker image

    mvn clean package && docker build --no-cache -t profiler:1.4 .
    docker run -p 7474:7474 -p 8080:8080 -p 7687:7687 profiler:1.4
    
The debug port is now available on __localhost:7687__ and the JMX remote port on __localhost:7474__.

Attach VisualVM to JMX on localhost:7474 to start profiler.


## Links

- VisualVM: https://visualvm.github.io/
- OpenJDK at DockerHub https://hub.docker.com/_/openjdk
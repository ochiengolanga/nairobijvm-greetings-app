# Dockerizable Spring Greetings Application

This is a simple demo application presented during NairobiJVM's meetup ["From Development to Production: Deploying Java and Scala Apps on Kubernetes"](https://www.meetup.com/nairobi-jvm/events/258119823). It's comprised of a Spring Boot application that exposes a single API that returns a greeting as a string. Cliche. Right? That needs to find its way to Kubernetes. Not so cliche for a Greetings app. Huh?

### Packaging to jar

```sh
$ ./gradlew build
```

Build and skip tests...

```sh
$ ./gradlew build -x test
```

Test application....
```sh
$ curl localhost:8080
```

### Packaging to Docker image using gradle plugin jib

```sh
$ ./gradlew jibDockerBuild
```
List docker images....
```sh
$ docker images
```
Running a container from the docker image....
```sh
$ docker run --name greetings-app -p 8080:8080 -d nairobijvm/greetings
```
Test application....
```sh
$ curl localhost:8080
```

### Packaging to Docker image and Push to a registry using gradle plugin jib

```sh
$ ./gradlew jib
```
Pull and use [registry:v2](https://hub.docker.com/_/registry) to quicky setup a local docker image registry.

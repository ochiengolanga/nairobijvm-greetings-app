# Dockerizable Spring Greetings Application

This is a simple demo application presented during NairobiJVM's meetup ["From Development to Production: Deploying Java and Scala Apps on Kubernetes"](https://www.meetup.com/nairobi-jvm/events/258119823). It's comprised of a Spring Boot application that exposes a single API that returns a greeting as a string. Cliche. Right? That's needs find its way to Kubernetes. Not so cliche for a Greetings app. Huh?

### Packaging to jar

```bash
$ ./gradlew build
```

Build and skip tests...

```bash
$ ./gradlew build -x test
```

Test application....
```bash
$ curl localhost:8080
```

### Packaging to Docker image using gradle plugin jib

```bash
$ ./gradlew jibDockerBuild
```

List docker images....
```bash
$ docker images
```

Running a container from the docker image....
```bash
$ docker run --name greetings-app -p 8080:8080 -d nairobijvm/greetings
```

or with an environment variable

```bash
$ docker run --name greetings-app -p 8080:8080 --env GREETINGS_SALUTATION=Niaje! -d greetings
```

Test application....
```bash
$ curl localhost:8080
```

### Packaging to Docker image and Push to a registry using gradle plugin jib

```bash
$ ./gradlew jib
```
Pull and use [registry:v2](https://hub.docker.com/_/registry) to quicky setup a local docker image registry.

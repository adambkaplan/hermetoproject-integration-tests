# Maven Spring Boot Integration Test

This integration test represents a sample [Spring Boot](https://spring.io/guides/gs/spring-boot)
Java project that is compiled, installed, and deployed with Maven. The project utilizes the
plugins and settings recommended by the [Spring Initializer](https://start.spring.io/) tool.
Settings for the [Maven Lockfile Plugin](https://github.com/chains-project/maven-lockfile)
complement the Spring starter configuration.

## Preparation

Generate the lockfile (`lockfile.json`) with the following command:

```sh
rm -f lockfile.json && \
mvn io.github.chains-project:maven-lockfile:generate
```

This will re-generate the complete dependency tree with plugins included, and a checksum algorithm
(SHA-1) commonly found with Maven Central artifacts. These settings are configured in the project's
`pom.xml` file.

## Validation

First, fetch the dependencies with Hermeto:

```sh
hermeto fetch-deps x-maven
```

Next, run the Maven build in "offline" mode using the Hermeto output directory as the "local" Maven
repository:

```sh
mvn clean package -o \
-Dmaven.repo.local=hermeto-output/deps/maven \
-DskipTests=true
```

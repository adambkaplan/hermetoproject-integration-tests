# Maven Single Module Integration Test

This integration test represents a simple "Hello World" Java project that is compiled, installed, and deployed with Maven.
The project utilizes the following tools that are widely adopted in the Maven ecosystem:

* JUnit for unit testing
* Spotless plugin to ensure code formatting consistency
* Standard Maven plugins to compile JARs and run tests (compiler, surefire, etc.)
* Maven Lockfile Plugin to generate the lockfile for Hermeto

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

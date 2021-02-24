## Loan Process


### Architecture Example - Blog post

https://medium.com/slalom-engineering/clean-architecture-with-java-11-f78bba431041

### Pre-requisite

Install Java 14+ using sdk-man

```
Install SDK-MAN
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version

Install Java
sdk list java

using latest version:
sdk default java 15.0.0.hs-adpt

or using LTS:
sdk default java 11.0.8.j9-adpt
```

### Check for Java 14+ installation
```
> java -version
openjdk version "15" 2020-09-15
OpenJDK Runtime Environment AdoptOpenJDK (build 15+36)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 15+36, mixed mode, sharing)
```

### Compile

`./gradlew clean build`

### Run Spring

`java -jar application/spring-app/build/libs/spring-app-0.0.1-SNAPSHOT.jar`

#### Commit Loan Use Case
```
  import postman collections examples from:
  /loan-process/spring-app/src/main/resources/Loan Submission.postman_collection.json
```

#### Commit Unit Tests
```
Run the verification tasks as usual, from the root folder:

:~/IdeaProjects/loan-process$ ./gradlew test
```



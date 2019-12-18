# JSON String comparator

## The assignment

- Provide 2 http endpoints that accepts JSON base64 encoded binary data on both
endpoints
    - <host>/v1/diff/<ID>/left and <host>/v1/diff/<ID>/right
        - The provided data needs to be diff-ed and the results shall be available on a third end
point
    - <host>/v1/diff/<ID>
        - The results shall provide the following info in JSON format
            - If equal return that
            - If not of equal size just return that
            - If of same size provide insight in where the diffs are, actual diffs are not needed. 
                - So mainly offsets + length in the data
## Project Description
This is a git project, so it is divided by "main" features like:
- project set-up
- repository support
- json input
- validators
- dto

For each feature a branch have been created, then once if could be considered
as finished, merged into develop branch.

Once we get the basic required functionality, released into a v0.1 branch and started on QA process.

Based on QA results some improvements were added.

## Reference Documentation
* Java 8: https://docs.oracle.com/javase/8/docs/api/
* Spring Boot 2: https://spring.io/projects/spring-boot
* Swagger 2: https://swagger.io/tools/swagger-ui/

### Guides

#### Building and running the tests

* Compile and package the project

```bash
$ mvn clean package
```


* Compile and package without running the tests

```bash
$ mvn clean package -DskipTests
```

#### Running

```bash
$ java -jar target/json-comparator-0.0.1-SNAPSHOT.jar
```

#### Running using maven
```bash
$ mvn spring-boot:run
```

### URL's
* API - http://localhost:8080/swagger-ui.html
* Compare endpoint status - http://localhost:8080/v1/diff/results/status
* Compare endpoint - http://localhost:8080/v1/input/status

* Input endpoint status - http://localhost:8080/v1/diff/{id}/left
* Left input endpoint - http://localhost:8080/v1/diff/{id}/right
* Right input endpoint - http://localhost:8080/v1/diff/{id}/left

* Encode input: http://localhost:8080/v1/input/encode
* Decode input: http://localhost:8080/v1/input/decode



## Next steps

- Remove 'type' property on JsonInputForm since it can be guessed based on entry point url.
- Add hibernate support in order to keep track of inputs and results into a MySQL database.
- Add a security layer using JWT and or enable Spring Security.
- Improve tests having a in memory db like h2 `https://www.h2database.com/html/main.html`.
- Create test suites and split integration and unit tests.
- We could add Spring Forms or use given endpoints on modern javascript web framework app.
- Deploy this app/jar into a AWS beanstalk app.

# Pet Lover
* This is a project that mimics a veterinary store registration application.

* Pet Lover is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). 

## Running the project locally on your pc
* You can build a jar file and run it from the command line:

```
git clone https://github.com/NdiranguMuchai/pet-lover.git
cd pet-lover
./mvnw package
java -jar target/*.jar
```

You can then access it here: http://localhost:8080/

* Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```

## Database configuration
No database configuration is required since the project uses an in-memory `H2` database.
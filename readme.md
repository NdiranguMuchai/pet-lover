# Pet Lover
* This is a project that mimics a veterinary store registration application.

* Pet Lover is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). 

## Prerequisites
The following  should be installed in your system:
* [Java 8 or newer](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Git command line tool](https://help.github.com/articles/set-up-git)
* Your preferred IDE
    * Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
      not there, just follow the install process here: https://www.eclipse.org/m2e/
    * [Spring Tools Suite](https://spring.io/tools) (STS)
    * IntelliJ IDEA
    * [VS Code](https://code.visualstudio.com)

## Database configuration
No database configuration required since the project uses an in-memory `H2` database.

## Running Pet Lover locally 
* You can build a jar file and run it from the command line:

```
git clone https://github.com/NdiranguMuchai/pet-lover.git
cd pet-lover
./mvnw package
java -jar target/*.jar
```


* Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```

You can then access it here: http://localhost:8080/

<img width="1042" alt="home" src="https://user-images.githubusercontent.com/47880944/125268963-eb347e80-e310-11eb-8843-3337a6ef5b57.png">

### Owners
* This tab provides information on an owner, their pets and the number of visits made to the store

<img width="1042" alt="find_owners" src="https://user-images.githubusercontent.com/47880944/125269962-e2907800-e311-11eb-8b36-c97dcc8b2742.png">

Here you can view details about an individual owner

<img width="1042" alt="individual_owner" src="https://user-images.githubusercontent.com/47880944/125270246-24b9b980-e312-11eb-9bd9-22c07b56e494.png">

Or you can view a full list of owners who have visited the store

<img width="1042" alt="owners_list" src="https://user-images.githubusercontent.com/47880944/125270355-44e97880-e312-11eb-9771-6f55cbea552f.png">

### Vets
This section provides a list of all available vets at the facility and their specialities.

<img width="1042" alt="vets_list" src="https://user-images.githubusercontent.com/47880944/125271544-8fb7c000-e313-11eb-88b4-64c2b6269045.png">

### Error Page

A custom error page has been included that can be used to display user-friendly errors messages.

<img width="1042" alt="error_page" src="https://user-images.githubusercontent.com/47880944/125271985-ffc64600-e313-11eb-9914-40b893748c64.png">

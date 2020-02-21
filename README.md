# rest-test-exercise
Moo - Rest Test Exercise

### Prerequisites

* Java 8
* Maven 3.6.x (tested on Maven 3.6.3)

### Running the application

* Build the project using maven:
 ```
mvn clean install
 ```

* Run the program using:
 ```
mvn spring-boot:run 
 ```

### REST API

* Search by Surname
```
http://localhost:8080/search?surname=bloggs
````
* Get Customer by ID:
```
http://localhost:8080/customers/1
````

### Future development and features:
* Security
* Full REST CRUD support
* Spring Boot spring-boot-starter-actuator Actuator production-ready management and monitoring support 
# Spring Unit Testing

PetStore example that has an example of 2 types of unit testing. 1- actual unit tests, 2 - mock tests.

## Installation
```bash
cd ~/pet-store/
maven clean install
```
## Details
Once the maven process kicks in, it will start to build just like any other maven project that we have work with. The maven process will pull down dependencies, compile, build the project jar file. Most importantly, it will run the unit tests.

There are 6 tests in the pet.store.entity.controller package. The AbstractController.java Class contains some base functionality. PetStoreControllerTest.java holds the real tests.

I have created 2 types of unit tests. A standard unit test and what they call a mock unit test. The mock unit test we discussed last week. The mock process allows you to simulate the test without executing the real request. You can test for results or error conditions. 

The unit tests take an Object and simulates a real request and validates the results. When maven finishing building, it will execute the unit test class. You should see the following:


[INFO] --- maven-surefire-plugin:3.0.0:test (default-test) @ pet-store ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running pet.store.entity.controller.PetStoreControllerTest

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.2)

The @SpringBootTest annotation will execute SpringBoot give the main class. I have setup up this: @SpringBootTest(classes = PetStoreApplication.class). This is the main trigger to start the unit tests.

Once the tests are finished, it will print out the results.

[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.364 s - in pet.store.entity.controller.PetStoreControllerTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:3.3.0:jar (default-jar) @ pet-store ---
[INFO] Building jar: / workspace-spring-tool-suite/pet-store/target/pet-store-0.0.1-SNAPSHOT.jar

From the output above you can see: 
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

That means that all 6 tests executed successfully.

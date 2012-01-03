Pong
====

This is a project I am taking on to reacquaint myself with Java and the Java
ecosystem as well as practice some basic game design and multi-threaded
programming.

This project uses the following libraries and frameworks:
    
* Maven - for managing builds, external dependencies, and file layout
* Google Guice - for dependency injection
* JUnit - for automated tests
* Mockito - for mocking objects for unit tests
* Failsafe Maven plugin - for running integration tests inside Maven
* Cobertura - for generating test code coverage statistics

Setting up a Maven-based Eclipse development environment on Ubuntu
------------------------------------------------------------------

1. Install eclipse and maven (which will also install a JDK and JRE):
   `sudo apt-get install eclipse maven2`
2. Go to the project root and enter:
   `mvn -Declipse.workspace=<path-to-eclipse-workspace> eclipse:add-maven-repo`
3. Download the appropriate dependencies, compile, and test the project with:
   `mvn verify`
4. Generate the Eclipse project and classpath files: `mvn eclipse:eclipse`
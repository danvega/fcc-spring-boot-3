# Building web applications in Java with Spring Boot 3

This course is a beginner's step-by-step guide to developing web applications using Spring Boot, the most popular framework for building Java applications. You'll learn about Spring Boot 3 and its role in enabling developers to deliver enterprise-grade applications. We'll dive into Spring's fundamentals by creating a REST API that communicates with a database and is supported by a comprehensive suite of tests. By the end of this course you will have learned what you need to start building your own web applications with Spring Boot 3.

## Agenda

- Module 1: Course Introduction
  - Who am I?
  - Outcomes
  - Prerequisites
  - What is Spring?
- Module 2: Create the project
    - [start.spring.io](http://start.spring.io)
        - Java Build Tools (Maven + Gradle)
    - How to organize your code
        - Where your code should go (create a simple class)
        - No default package
    - How to run your application (IDE/Maven/Command Line)
    - Model
      - Run + Location Class
      - Records
    - Logging
    - Spring Boot DevTools
- Module 3: Web Application (REST API)
    - [Spring MVC](https://docs.spring.io/spring-framework/reference/web.html)
    - CRUD (in-memory)
    - @Component / Controller / RestController / Service / Repository
    - REST API Testing
        - Postman
        - Http Client (IntelliJ)
        - curl / HTTPie
    - Dependency Injection
    - Data Validation
    - Configuration
    - Error Handling
- Module 4: Database
    - H2 Database
    - JDBC Client (Keep it simple)
    - Command Line Runner
      - Loading JSON data
    - Docker Compose & PostgreSQL
    - Spring Data
- Module 5: REST Client
  - What is a client
    - Rest Template
    - WebClient
    - GraphQL Client
    - Rest Client
    - Http Interfaces
- Module 6: Testing
    - Spring Boot Testing Toolkit
      - No need to opt in to testing 
      - `contextLoads()` test
      - `@SpringBootTest` annotation
      - Documentation 
    - Writing Tests
      - `InMemoryRunRepositoryTest`
      - `RunControllerTest`
      - `RunControllerIntTest`
    - Spring Boot Slice Tests
      - `JDBCRunRepositoryTest`
    - Spring Rest Client Test
      - `UserRestClientTest`
- Resources

## Who am I?

- Husband + Father (2 daughters) #girldad 
- Cleveland, OH
- Spring Developer Advocate @Broadcom
- Java Champion
- Spring Academy Instructor
- 23+ years of Software Development Experience

## Prerequisites

- Java Fundamentals (Beginner - Intermediate)
- JDK 17+
  - Check current version `java --version`
  - [SDKMAN](https://sdkman.io/)
- Java Build Tools (Maven / Gradle)
- IDE / Text Editor
  - [IntelliJ IDEA](https://www.jetbrains.com/idea/) 
  - [Spring Tools](https://spring.io/tools)
    - Visual Studio Code
    - Eclipse
- API Testing Tool
  - Postman
  - Http Client (IntelliJ)
  - cURL / HTTPie
- [Docker Desktop](https://www.docker.com/)

## Outcomes

- "Learn Spring"
  - What Spring is and what it can do
  - How to build a web application with Spring Boot
  - How to test a Spring Boot application
  - How to use Spring Data to interact with a database
- What are you going to build? 
  - A fitness application that allows you to track runs through a REST API

The important part here is to take what you learn and apply it to your own projects.

## What is Spring?

- [What / Why Spring?](https://spring.io/)

## Resources

This is a list of resources I recommend you check out to continue your learning.

### Dan Vega
  - [Website](https://www.danvega.dev/)
  - [YouTube](https://www.youtube.com/@danvega)
  - [Twitter](https://twitter.com/therealdanvega)

### Spring
  - [Spring Academy](https://www.youtube.com/c/SpringAcademy)
  - [Spring I/O](https://spring.io/blog)
  - [Spring Blog](https://spring.io/blog)
  - [SpringOne at VMware Explore](https://springone.io/) 

### Documentation

- [Spring Framework Reference](https://docs.spring.io/spring-framework/docs/current/reference/html/)
- [Spring Framework API](https://docs.spring.io/spring-framework/docs/current/javadoc-api/)
- [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/html/index.html)
- [Spring Boot API](https://docs.spring.io/spring-boot/docs/current/api/)
- [Spring Boot Guides](https://spring.io/guides)

### Books

- [Spring Boot Up and Running - Mark Heckler](https://amzn.to/3WOSutb)
- [Learning Spring Boot 3.0 - Greg Turnquist](https://amzn.to/3CuCgxc)
- [Spring Boot in Action - Craig Walls](https://amzn.to/3ZcI3kx)

### Podcasts

- [Bootiful Podcast - Josh Long](http://bootifulpodcast.fm/)
- [Spring Office Hours](https://www.springofficehours.io)

### YouTube

- [Spring Developer](https://www.youtube.com/@SpringSourceDev)
- [Josh Long](https://www.youtube.com/@coffeesoftware)
- [DaShaun Carter](https://www.youtube.com/@dashaun)
- [Spring Boot Learning](https://www.youtube.com/@SpringBootLearning)
- [Spring Tips](https://www.youtube.com/playlist?list=PLgGXSWYM2FpPw8rV0tZoMiJYSCiLhPnOc)
- [Amigoscode](https://www.youtube.com/@amigoscode)
- [Java Brains](https://www.youtube.com/c/JavaBrainsChannel)
- [Daily Code Buffer](https://www.youtube.com/@DailyCodeBuffer)

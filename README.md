This project is a [POC](https://en.wikipedia.org/wiki/Proof_of_concept) project to demonstrate using [Spring Cloud](http://projects.spring.io/spring-cloud/) to build a microservice structured [Single Page Application](https://en.wikipedia.org/wiki/Single-page_application).

## Table of contents

* [Project strucutre](#project-structure)
* [How to run](#how-to-run)
* [How to develop](#how-to-develop)
* [FAQ](#faq)

## Project Structure

### Description

This project uses several Spring Cloud modules to construct a simple microservice structured web application.

* [config-server](config-server) uses `Spring Cloud Config Server` to manage configurations
* [eureka-server](eureka-server) uses `Spring Cloud Netflix Eureka` to support service registry and discovery
* [gateway-server](gateway-server) uses `Spring Cloud Gateway` to support gateway, authentication and web portal are also included in this module
* [message-service](message-service) is a `Spring Boot Application` microservice which registers to eureka-server and requests can be routed from gateway-server

For the front end under [gateway-server](gateway-server/src/main/webapp), it's developed with [Vue.js](https://vuejs.org/).

### Detailed structure tree

```
    moments
    ├── config-server
    │   └── src
    │       └── main
    │           ├── java
    │           └── resources
    │               ├── shared         // configuration files
    │               └── bootstrap.yml 
    │
    ├── eureka-server                  // eureka server for service registry and discovery
    │   └── src
    │       └── main
    │           ├── java
    │           └── resources
    │               └── bootstrap.yml 
    │
    ├── gateway-server
    │   └── src
    │       └── main
    │           ├── java
    │           ├── resources
    │           │   ├── static
    │           │   │    └── dist      // webpack bundled resources after npm build
    │           │   └── bootstrap.yml 
    │           └── webapp             // front end resources
    │               └── src
    │                   ├── api
    │                   ├── components // Vue components
    │                   └── lib
    │
    ├── message-service
    │   └── src
    │       └── main
    │           ├── java
    │           └── resources
    │               └── bootstrap.yml 
    │
    └── moments-parent                // parent maven pom for other modules mainly for dependency management
```


## How to run

### Run with maven

1. Package the gateway-server front end resources.

    ```bash
    $ cd gateway-server
    $ npm install
    $ npm run build
    
    $ cd .. && mvn clean install
    ```

2. Start servers one after another under each module folder:

    config-server, eureka-server, message-service, gateway-server

    ```bash
    $ cd config-server
    $ mvn spring-boot:run
    
    $ cd eureka-server
    $ mvn spring-boot:run
    
    $ cd message-service
    $ mvn spring-boot:run
    
    $ cd gateway-server
    $ mvn spring-boot:run
    ```

### How to access

1. Gateway:
 
   http://localhost:8080/
   
   Log in with user/password or admin/password
   
   
2. Message service through gateway

   http://localhost:8080/message/get
   
   http://localhost:8080/message/admin/get // Only accessible by admin
   

## How to develop

Modules beside [gateway-server](gateway-server) are normal Spring Boot applications, no special configurations are configured for development.

### Develop gateway front end

In the gateway-server module, webpack is used to bundle the web resources. In order to develop without frequently re-packaging the web resources and restart Spring Boot application server, this project uses [webpack dev server](https://webpack.js.org/configuration/dev-server/) for local development and auto refresh. 

Under gateway-server module root, start gateway server:

```bash
$ mvn spring-boot:run
```

Start webpack dev server:

```bash
$ npm run start
```

Access http://localhost:9090.

## FAQ

#### Why Spring Webflux is used in gateway-server but not Spring MVC?

In this project, websocket is used, Spring Netflix Zuul does not support websocket, so Spring Cloud Gateway is used to support websocket. But Spring Cloud Gateway cannot work well with Spring MVC with warning message `Spring MVC found on classpath, which is incompatible with Spring Cloud Gateway at this time. Please remove spring-boot-starter-web dependency`. So Spring Webflux is used.

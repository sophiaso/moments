### How to run

#### Run with maven

```bash
$ cd gateway-server
$ npm install
$ npm run build

$ cd .. && mvn clean install

Start servers one after another under each module folder.
config-server, eureka-server, message-service, gateway-server

$ cd config-server
$ mvn spring-boot:run

$ cd eureka-server
$ mvn spring-boot:run

$ cd message-service
$ mvn spring-boot:run

$ cd gateway-server
$ mvn spring-boot:run
```

#### How to access

1. Gateway:
 
   http://localhost:8080/
   
   Log in with user/password or admin/password
   
   
2. Message service through gateway

   http://localhost:8080/message/get
   
   http://localhost:8080/message/admin/get // Only accessible by admin
   

### How to develop

#### gateway development

Start gateway server:

$ mvn spring-boot:run

Start webpack dev server:

$ npm run start

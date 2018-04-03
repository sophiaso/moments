`auth-service` is not currently used, all authentication and filter is done in the gateway.

### How to run

#### Run with maven

```bash
$ cd gateway-server
$ npm install
$ npm run build

$ cd .. && mvn clean install

Start servers one after another under each module folder.
config-server, eureka-server, notification-service, gateway-server

$ cd config-server
$ mvn spring-boot:run

$ cd eureka-server
$ mvn spring-boot:run

$ cd notification-service
$ mvn spring-boot:run

$ cd gateway-server
$ mvn spring-boot:run
```

#### How to access

1. Gateway:
 
   http://localhost:8080/
   
   Log in with user/password or admin/password
   
   
2. Notification service through gateway

   http://localhost:8080/notification/get
   
   http://localhost:8080/notification/admin/get // Only accessible by admin
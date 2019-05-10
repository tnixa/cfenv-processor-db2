## Test project for DB2 via JPA on IBM Cloud using Spring Boot Starter and CFEnv
Project to test a DB2 service instance on IBM Cloud using Spring Boot Starter: https://github.com/watson-developer-cloud/spring-boot-starter. A sample DB entry with be written and read. 

Uses the CFEnv processor to set the properties from the service entry in VCAP_SERVICES.
- https://github.com/pivotal-cf/java-cfenv

## Setup
1. You'll need ibm cloud CLI from https://cloud.ibm.com/docs/cli/reference/ibmcloud?topic=cloud-cli-install-ibmcloud-cli#install_use and bx cf installed and configured to talk to the appropriate cf org/space etc.
2. You'll need to create a DB table and test entries. Sample SQL...
```
create table things (id int, name varchar(255))
insert into things (id,name) values (1,'fish'),(2,'wibble'),(3,'stiletto'
```

## Build
```
./mvnw package
```

## Deploy
```
bx cf push -b java_buildpack -p target/testapp-0.0.1-SNAPSHOT.jar YourAppname
```

## Verify
1. navigate to http://YourAppname.mybluemix.net/test
2. check log: 
```
bx cf logs YourAppname --recent
```
Spring Boot, Camunda BPM, H2 Embedded
---------------------------------------------------

Tools used:
-----------

* Maven 3.5
* Spring Boot 2.3.1.RELEASE
* H2 1.4.200
* Camunda 7.14.0

BPMN
-

![Alt text](./src/main/resources/process-message.png?raw=true "Workflow")


Respository
---------

Clone the repository:

    $ git clone https://github.com/thiagomarsal/spring-boot-camunda-workflow.git

Run Project
-----------

**Run Application**

    $ mvn spring-boot:run
    http://localhost:8080/camunda/app
    Username and Password: demo

Post message to start "process-message" flow:

Run the command:

```
curl --location --request POST 'http://localhost:8080/engine-rest/process-definition/key/process-message/start' \
--header 'Content-Type: application/json' \
--data-raw '{
    "variables": {
        "process-message": {
            "value": "Hello World !!!",
            "type": "String"
        }
    }
}'
```
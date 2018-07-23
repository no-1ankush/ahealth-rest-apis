# ahealth-rest-apis

REST APIs to retrieve the Patient, Physician Information.

### Uses: ###
* Spring Boot Application
* Mongo DB
* Model Wrappers

### Provides: ###
* CRUD APIs to Retrieve, Add, Update, Delete information
* HATEOAS implementation

### End-Points: ###
| API           | URIs                                 | Supported Methods|
| ------------- | ------------------------------------ | -----------------|
| Patients      | http://localhost:8999/patients       |GET, POST         |
| Patients      | http://localhost:8999/patients/{id}  |GET, PUT, DELETE  |
| Physicians    | http://localhost:8999/physicians     |GET, POST         |
| Physicians    | http://localhost:8999/physicians/{id}|GET, PUT, DELETE  |
| Resources     | http://localhost:8999/resources      |GET               |
| Resources     | http://localhost:8999/resources/{id} |GET               |

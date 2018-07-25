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

### Challenge Statement ###
https://github.com/no-1ankush/ahealth-rest-apis/blob/master/Challenge_Statement.pdf

### Design Diagram ###
https://github.com/no-1ankush/ahealth-rest-apis/blob/master/A_Health_Challege_Design.pdf

### Demo Video ###
https://www.dropbox.com/s/nspm2ky1xij9mnr/AHealth_Coding_Challenge_Demo.mp4



***Note:*** Please check out [Duplo](https://github.com/no-1ankush/duplo) to see UI Code

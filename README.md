# AutomobileWebService

Automobile Web Service created using Spring Boot and Rest Assured that performs CRUD operations (Create, Read, Update, and Delete) for a Vehicle
(automobile) entity.
A Vehicle is a simple object and following menthods were implemented for it.

* GET vehicles <br />
* GET vehicles/{id} <br />
* CREATE vehicles <br />
* UPDATE vehicles <br />
* DELETE vehicles/{id}

Following features were included in the project:
1) Added validation to web service.
Vehicles must have a non-null / non-empty make and model specified, and the year must be between 1950 and 2050.
2) Added filtering to your service.
The GET vehicles route support filtering vehicles based on one or more vehicle properties. (Example: retrieving all vehicles where the ‘Make’ is ‘Toyota’)
3) Used Postman to be used as a client to consume the web service

# travellerStorage
Static content importer microservice for traveller.
It parses the data from the static files and sent it to RabbitMQ.

# Getting Started

### Reference Documentation

To compile the project you have to install 
* sudo apt-get install openjdk-17-jdk

To successfully start the application you need to run following commands:
* docker run -d --name rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:3-management
* mvn clean install && mvn spring-boot:run

The application will start on port 8080.

At the moment, there are no endpoints available.
All the data will be sent to rabbitmq automatically during the application startup.

In order to save new cities and countries to the database, as well as to get access to these data, you have to run travellerStorage application.

### Guides

New docker image creation:
* mvn clean install
* DOCKER_BUILDKIT=1 docker build . -t traveller_importer:0.0.1
* docker images
* docker tag traveller_storage:0.0.1 sorokinandrey/traveller_importer:0.0.1
* docker login
* docker push sorokinandrey/traveller_importer:0.0.1
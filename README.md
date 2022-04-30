# travellerStaticContentImporter
Static content importer microservice for traveller.
It parses the data from the static files and sent it to RabbitMQ.

# Getting Started

### Reference Documentation

To compile the project you have to install 
* sudo apt-get install openjdk-17-jdk

To successfully start the application you need to run following commands:
* docker run -d --name rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:3-management
* mvn clean install && mvn spring-boot:run

The application will start on port 8082.

At the moment, there are following endpoints are available:
* GET http://localhost:8082/cities - read all city data from file and sent it to RabbitMQ
* GET http://localhost:8082/countries - read all country data from file and sent it to RabbitMQ

In order to save new cities and countries to the database, as well as to get access to these data, you have to run travellerStorage application.

### Guides

New docker image creation:
* mvn clean install
* DOCKER_BUILDKIT=1 docker build . -t sorokinandrey/traveller_importer:0.0.1
* docker login
* docker push sorokinandrey/traveller_importer:0.0.1
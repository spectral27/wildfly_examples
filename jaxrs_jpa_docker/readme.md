## Java - WildFly - MySQL - Docker-Compose

Ok, this is not -that- easy.
Example application deployed on a WildFly server, using a MySQL database, running on Docker.
Maybe I'll add a frontend soon.

### How it works
The Java application has two simple GET and POST requests.
You first do:

	mvn clean package

Inside main_backend folder, so you can get the target/run.war file to deploy.
Commands in Dockerfile:

- Switch to root user and create a new folder
- Copy the datasource.cli file (needed for creating the WildFly datasource when booting the project)  and the driver jar file (needed for creating the datasource driver) in the new folder, then copy the main war file in WildFly Docker image deployments directory
- Add an admin user to server ("admin")
- Start the server just for executing the datasource.cli script mentioned above

What does this script do?
Adds a new module to server, then a new driver, then a new datasource.

- Clean that directory so you won't have an error message at startup 
- Start the server

Database scripts
Inside "scripts" folder in root of project, there are these two files that initialize the database when building the image with docker-compose.

Docker compose:

Define scripts to execute to database when building image, links a local Docker volume with container volume. Set right ports for the application.

### Start 
	docker-compose up --build

To stop and remove containers, images and volumes:

	docker-compose down --rmi local -v

### Test
GET request (show all items):

	curl localhost:8080/main/items | json_pp

POST request:
Same URL, JSON body:
	
	{
		"itemValue": "<valueToInsert>"
	}

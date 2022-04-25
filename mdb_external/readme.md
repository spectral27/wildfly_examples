## Message Driven Bean - Remote ActiveMQ Artemis broker

Thanks 

https://github.com/tommaso-borgato  

for your amazing tutorial :)

### Configuration

Download Apache ActiveMQ Artemis and extract the archive.  
Create a new folder inside it (e.g. brokers) and run inside that folder:  

``../bin/artemis create broker1``

Insert a new username/password and allow anonymous access.  
Then start the broker:  

``<activemq-artemis-root>/brokers/broker1/bin/artemis run``  

Then add the binding and the queue to WildFly with the .cli script:  

``<wildfly-home>/bin/jboss-cli.sh --file=<path-to>/remote-artemis.cli``

Deploy the application and start the server, go to url:  

``localhost:8080/mdb_ext/send``  

To find a servlet for sending messages to the queue. When done, check the message in WildFly console.

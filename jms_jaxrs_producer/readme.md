To create the queue, run add-queue.cli script first:

```
<wildfly-home>/bin/jboss-cli.sh --file=<path-of>/add-queue.cli
```

To send a message, simply make a POST request to url:

```
http://localhost:8080/jms_jaxrs_producer/send
```

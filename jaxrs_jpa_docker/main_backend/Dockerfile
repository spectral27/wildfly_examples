FROM quay.io/wildfly/wildfly

WORKDIR /

USER root
RUN mkdir /resources
USER jboss

COPY ./mysqldriver.jar /resources
COPY ./datasource.cli /resources
COPY ./target/run.war /opt/jboss/wildfly/standalone/deployments

RUN ls /resources

RUN /opt/jboss/wildfly/bin/add-user.sh -u admin -p admin --silent
RUN /opt/jboss/wildfly/bin/jboss-cli.sh --file=/resources/datasource.cli

# Fix for Error: Could not rename /opt/jboss/wildfly/standalone/configuration/standalone_xml_history/current
RUN rm -rf /opt/jboss/wildfly/standalone/configuration/standalone_xml_history

EXPOSE 8080 9990

CMD /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0

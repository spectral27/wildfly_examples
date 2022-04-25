package mdb_external;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.jboss.ejb3.annotation.ResourceAdapter;

@MessageDriven(name = "ConsumerMDB", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "testQueueRemoteArtemis"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "useJNDI", propertyValue = "false"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
@ResourceAdapter("remote-artemis")
public class ConsumerMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println(message.getBody(String.class));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}

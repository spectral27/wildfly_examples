package jaxrs_jms;

import java.util.Properties;
import java.util.UUID;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/send")
public class ProducerController {
	
	private ConnectionFactory connectionFactory;
	private Destination destination;
	private JMSContext jmsContext;
	
	{
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		env.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
		env.put(Context.SECURITY_PRINCIPAL, "appuser");
		env.put(Context.SECURITY_CREDENTIALS, "appuser");
		
		try {
			Context context = new InitialContext(env);
			connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
			destination = (Destination) context.lookup("jms/queue/testQueue");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@POST
	public String sendMessage() {
		jmsContext = connectionFactory.createContext("appuser", "appuser");

		JMSProducer producer = jmsContext.createProducer();
		String message = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
		producer.send(destination, message);

		jmsContext.close();
		return "Message \"" + message + "\" sent.";
	}

}

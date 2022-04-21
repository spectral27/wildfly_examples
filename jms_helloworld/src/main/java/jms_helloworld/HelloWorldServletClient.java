package jms_helloworld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@JMSDestinationDefinitions(value = {
		@JMSDestinationDefinition(name = "java:/queue/HELLOWORLDMDBQueue", interfaceName = "javax.jms.Queue", destinationName = "HelloWorldMDBQueue"),
		@JMSDestinationDefinition(name = "java:/topic/HELLOWORLDMDBTopic", interfaceName = "javax.jms.Topic", destinationName = "HelloWorldMDBTopic")
})
@WebServlet("HelloWorldServletClient")
public class HelloWorldServletClient extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final int MSG_COUNT = 5;

	@Inject
	private JMSContext context;

	@Resource(lookup = "java:/queue/HELLOWORLDMDBQueue")
	private Queue queue;

	@Resource(lookup = "java:/topic/HELLOWORLDMDBTopic")
	private Topic topic;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.write("<h1>Quickstart: Example demonstrates the use of <strong>JMS 2.0</strong> and <strong>EJB 3.2 Message-Driven Bean</strong> in JBoss EAP.</h1>");
		try {
			boolean useTopic = req.getParameterMap().keySet().contains("topic");
			final Destination destination = useTopic ? topic : queue;

			out.write("<p>Sending messages to <em>" + destination + "</em></p>");
			out.write("<h2>The following messages will be sent to the destination:</h2>");
			for (int i = 0; i < MSG_COUNT; i++) {
				String text = "This is message " + (i + 1);
				context.createProducer().send(destination, text);
				out.write("Message (" + i + "): " + text + "</br>");
			}
			out.write("<p><i>Go to your JBoss EAP server console or server log to see the result of messages processing.</i></p>");
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

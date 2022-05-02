package mdb_external;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/send")
public class ProducerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	@JMSConnectionFactory("java:/jms/remoteCF")
	private JMSContext context;

	@Resource(lookup = "java:/queue/testQueueRemoteArtemis")
	private Queue queue;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");

		try (PrintWriter out = res.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");

			out.println("<head>");
			out.println("<link rel=\"stylesheet\" href=\"resources/styles.css\">");
			out.println("</head>");

			out.println("<body>");
			out.println("<div class=\"main\">");

			out.println("<div class=\"logos\">");
			out.println("<img src=\"resources/wildfly.svg\">");
			out.println("<img src=\"resources/activemq.png\">");
			out.println("</div>");

			out.println("<form method=\"get\">");
			out.println("<h2>Send a message to remote ActiveMQ Artemis queue:</h2>");
			out.println("<input type=\"text\" name=\"message\" autocomplete=\"off\">");
			out.println("<p></p>");
			out.println("<div class=\"buttons\">");
			out.println("<input type=\"submit\" value=\"Send\"/>");
			out.println("<input type=\"reset\" value=\"Reset\"/>");
			out.println("</div>");
			out.println("</form>");

			String message = req.getParameter("message");

			if (message != null && message.length() > 0) {
				context.createProducer().send(queue, message);

				out.println("<h3>Message was sent. Check server console!</h3>");
			}

			out.println("</div>");
			out.println("</body>");

			out.println("</html>");
		}
	}

}

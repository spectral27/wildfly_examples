package servlet_hello2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
        	out.println("<!DOCTYPE html>");
        	out.println("<html>");
        	
        	out.println("<head>");
        	out.println("<link rel=\"stylesheet\" href=\"resources/styles.css\">");
        	out.println("</head>");
        	
        	out.println("<body>");
        	out.println("<div class=\"main\">");
        	out.println("<div class=\"duke\">");
        	out.println("<img src=\"resources/Duke_waving.svg\">");
        	out.println("</div>");
        	
        	out.println("<form method=\"get\">");
        	out.println("<h2>Hello, my name is Duke. What's yours?</h2>");
        	out.println("<input type=\"text\" name=\"username\" autocomplete=\"off\">");
        	out.println("<p></p>");
        	out.println("<div class=\"buttons\">");
        	out.println("<input type=\"submit\" value=\"Submit\"/>");
        	out.println("<input type=\"reset\" value=\"Reset\"/>");
        	out.println("</div>");
        	out.println("</form>");
        	
            String username = request.getParameter("username");

            if (username != null && username.length() > 0) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/response");
                
                if (dispatcher != null) {
                    dispatcher.include(request, response);
                }
            }
        	
        	out.println("</div>");
        	out.println("</body>");
        	
        	out.println("</html>");
        }
	}

}

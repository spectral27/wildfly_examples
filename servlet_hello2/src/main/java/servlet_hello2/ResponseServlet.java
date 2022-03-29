package servlet_hello2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			String username = request.getParameter("username");
			
			if (username != null && username.length() > 0) {
				out.println("<h2>Hello, " + username + "!</h2>");
			}
		}
	}

}

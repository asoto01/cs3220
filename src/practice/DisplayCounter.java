package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayCounter")
public class DisplayCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the counter
		Integer counter = (Integer) getServletContext().getAttribute("counter");

		// display the message "The counter is incremented"
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<!DOCTYPE><html lang=\"en\"><head><title>Display Counter</title></head><body>"
				+ "<p>The counter value is currently: " + counter +"</p></body></html>");
	}

}

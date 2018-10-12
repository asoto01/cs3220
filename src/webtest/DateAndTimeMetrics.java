package webtest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DateAndTimeMetrics")
public class DateAndTimeMetrics extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get a reference to the servlet context (application scope)
		ServletContext context = this.getServletContext();
		
		// Get a reference
		int counter = (int) context.getAttribute("dateTimeCounter");
		
		// Set content type
		response.setContentType("text/html");
		
		// Get a reference to the Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate our template text
		out.print("<!DOCTYPE HTML>");
		out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstra    p/4.1.1/css/bootstrap.min.css\" integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47    jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\" crossorigin=\"anonymous\">");
		out.print("<title>Date and Time Metrics</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class=\"container\">");
		
		// Insert page-specific content 
		out.println("<h1>Date &amp; Time Metrics");
		out.println("<h3><small>The CurrentDateAndTime servlet has been viewed: </small>" + counter + " times</h3>");

		// Link to the current date and time page
		out.print("<a class=\"btn btn-primary\" href=\"CurrentDateAndTime\"Metrics</a>");
		
		
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

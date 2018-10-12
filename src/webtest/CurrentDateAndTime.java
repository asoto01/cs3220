package webtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= {"/CurrentDateAndTime"})
public class CurrentDateAndTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Get a reference to the servlet context (Application Scope)
		ServletContext context = this.getServletContext();
	
		// Create a reference to the servlet context (Application Scope)
		int count = 0;
		
		// Set the initial value of the date/time value to 0
		context.setAttribute("dateTimeCounter", context);

		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get a reference to the servlet context
		ServletContext context = this.getServletContext();
		
		// Get a reference to the current count
		int currentCount = (int) context.getAttribute("dateTimeCounter");
		
		// Update 
		
		
		// Increment the count by 1
		currentCount++;

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
		out.print("<title>Document</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class=\"container\">");
		
		// Insert page-specific content 
		out.print("<h1>Current Date &amp; Time</h1>");
		out.print("<h3><small>The current date and time is: </small>" + new Date() + "</h3>");
		
		// Link to the metrics page
		out.print("<a href=\"DateAndTimeMetrics\"Metrics</a>");
		
		
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

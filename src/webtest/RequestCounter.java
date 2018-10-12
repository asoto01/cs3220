package webtest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/intro/RequestCounter")
public class RequestCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int numberOfVisitors;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		++numberOfVisitors;
		// Set content type
		response.setContentType("text/html");
		
		// Get a reference to the Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate our template text
		out.print("<!DOCTYPE HTML>");
		out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYjz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\" crossorigin=\"anonymous\">");
		out.print("<title>Document</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class=\"container\">");
		
		// Insert page-specific content 
		out.print("<h1>Request Counter</h1>");
		out.print("<p>You are vistor " + numberOfVisitors + "</p>");
		
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

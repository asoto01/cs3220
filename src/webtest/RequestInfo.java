package webtest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		out.print("<h1>Request Info</h1>");
		
		
		// Request Method
		out.print("<h3>");
		out.print("<small>Request Method: </small>");
		out.print(request.getMethod());
		out.print("</h3>");
		
		// Request URI
		out.print("<h3>");
		out.print("<small>Request URI: </small>");
		out.print(request.getRequestURI());
		out.print("</h3>");
		
		// Context Path (What is this?)
		out.print("<h3>");
		out.print("<small>Context Path: </small>");
		out.print(request.getContextPath());
		out.print("</h3>");
		
		// Get the User's IP Address
		out.print("<h3>");
		out.print("<small>Your IP Address: </small>");
		out.print(request.getRemoteAddr());
		out.print("</h3>");
		
		// Determine if the Client supports gzip
		out.print("<h3>");
		out.print("<small>Context Path: </small>");
//		out.print(request.getHeader("Accept-Encoding".indexOf("gzip") >= 0);
		out.print("</h3>");
		
		
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

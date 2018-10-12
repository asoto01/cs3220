package webtest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/html	/SimpleAdder")
public class SimpleAdder extends HttpServlet {
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
		out.print("<h1>Simple Adder</h1>");
		
		// Get the Page-Specific Content
		int num1 = Integer.parseInt(request.getParameter("number1"));
		int num2 = Integer.parseInt(request.getParameter("number2"));
		
		// Add the two values
		int sum = num1 + num2;
		
		out.print("Num1 + num2 = " + sum);
		
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

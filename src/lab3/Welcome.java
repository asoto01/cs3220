package lab3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get attributes
		String name = (String) getServletContext().getAttribute("name");
		String email = (String) getServletContext().getAttribute("email");


		


		
		
		// Set content type
		response.setContentType("text/html");
		
		// Get a reference to the Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate our template text
		out.print("<!DOCTYPE HTML>");
		out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<link rel=\"stylesheet\""+
				"	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\""+
				"	integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\""+
				"	crossorigin=\"anonymous\">"+
				""+
				"<title>Register</title>"+
				"</head>"+
				"<body>"+
				"	<div class=\"container\">"+
				"		<div class=\"page-header\">"+
				"			<h1>Welcome</h1>"+
				"		</div>");
		out.print("<p>Hello, " + name + "!</p>");
		out.print("<p>Your email is " + email + "</p>");

		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

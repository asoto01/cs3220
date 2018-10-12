package midterm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/Midterm/MathPage", loadOnStartup = 1)
public class MathPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set Content Type
		response.setContentType("text/html");

		// Get a reference to the Print Writer
		PrintWriter out = response.getWriter();

		// Opening tag for html, complete header, and opening body tag
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println(
				"    <link rel=\"stylesheet\" "
				+ "href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" "
				+ "integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\" "
				+ "crossorigin=\"anonymous\">");
		out.println("    <title>Math Fundamentals</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		
		// Jumbotron String
		String jumbotron = "<div class=\"jumbotron\">" + "  <h1 class=\"display-2\">Math Fundamentals</h1>"
				+ "  <p class=\"lead\">An educational site for elementary math.</p>"
				+ "  <hr class=\"my-4\">" + "  <p>Please enter your name below to begin practice.</p>"
				+ "<form class=\"form in-line\" action=\"MathPage\" method=\"post\">"
				+ "			<div class=\"form-group\">"
				+ "				<input class=\"form-control\" type=\"text\" name=\"userName\""
				+ "					placeholder=\"Enter your name here\"> <br> <input"
				+ "					class=\"form-control btn btn-primary\" type=\"submit\" value=\"Submit\">"
				+ "			</div>" + "</form>" + "</div>";

		// Display jumbotron
		out.println(jumbotron);


		// close bootstrap class container, body, and html
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get user name
		String userName = request.getParameter("userName");
		if (userName == null || userName.trim().length() == 0 ) {
			getServletContext().setAttribute("userName", "Friend");
			response.sendRedirect("MathQuestions");
		} else {
			getServletContext().setAttribute("userName", userName);
			response.sendRedirect("MathQuestions");
		}
		
		
		
	}

}

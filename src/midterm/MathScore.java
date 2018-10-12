package midterm;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Midterm/MathScore")
public class MathScore extends HttpServlet {
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
		out.print("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\"crossorigin=\"anonymous\">");
		out.print("<title>Results</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class=\"container\">");
		
		// Insert page-specific content 
		// Get user name
		String userName = (String) getServletContext().getAttribute("userName");
		String score = (String) getServletContext().getAttribute("score");

		// Check if user name is null or an empty string
		if (userName == null || userName.trim().length() == 0) {
			getServletContext().setAttribute("userName", "Friend");
		}
		if (score == null || score.trim().length() == 0) {
			getServletContext().setAttribute("score", "Not Attempted");
		}

		// Display Header (user name)
		out.println("<br>");
		out.println("<h1>Welcome, " + userName + "</h1>");
		out.println("<hr>");
		
		// Opening table, with table headings
		out.print("<table class=\"table table-bordered table-striped table-hover\">");
		out.print("<tr>");
		out.print("<th>Name</th>");
		out.print("<th>Score</th>");
		out.print("</tr>");
		
		// table data
		out.print("<tr>");
		out.print("<td>" + userName +"</td>");
		out.print("<td>" + score +"</td>");
		out.print("</tr>");
		
		// close table tag
		out.print("</table>");
		
		out.print("<a href=\"MathQuestions\">Click here to take another quiz</a>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

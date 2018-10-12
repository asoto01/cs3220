package lab4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Lab4/AddTVShow")
public class AddTVShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set Content Type
		response.setContentType("text/html");
		
		// Get a reference to the Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate our template text
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\" crossorigin=\"anonymous\">");
		out.println("    <title>Add TV Show</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		// Insert Page-Specific Content
		out.println("<h1>Add TV Show</h1>");
		
		out.println("<form action=\"AddTVShow\" method=\"post\">");
				
		// Collect the User's name
		out.println("	<div class=\"form-group\">");
		
		
		
//		// Check to see if the name exists in the session
//		HttpSession session = request.getSession();		
//		String name = (String) session.getAttribute("name");
//		
//		// If not, check the request parameter
//		if (name == null)
//			name = request.getParameter("name");
//		
//		// If not, set name to empty string
//		if (name == null)
//			name = "";
		
		
		
		out.println("		 <input class=\"form-control\" type=\"text\" name=\"name\" placeholder=\"Name of TV Show\">");		
		
		if (request.getAttribute("nameError") != null) {
			out.println("<p class=\"text-danger form-text\">");
			out.println(request.getAttribute("nameError"));
			out.println("</p>");
		}		
		out.println("	</div>");
		
		// Collect the User's Description
		out.println("	<div class=\"form-group\">");
		
		String description = request.getParameter("description");
		description = description == null ? "" : description;
		
		out.println("		<textarea class=\"form-control\" name=\"desc\" rows=\"5\" cols=\"40\" placeholder=\"Description\">" + description + "</textarea>");
		
		if (request.getAttribute("DescriptionError") != null) {
			out.println("<p class=\"text-danger form-text\">");
			out.println(request.getAttribute("DescriptionError"));
			out.println("</p>");
		}
		out.println("	</div>");
		
		// Collect the User's URL
		out.println("	<div class=\"form-group\">");
		
		String url = request.getParameter("url");
		url = url == null ? "" : url;
		
		out.println("		<input class=\"form-control\" type=\"text\" name=\"url\" placeholder=\"URL to TV show site\">" + url + "</textarea>");
		
		out.println("	</div>");
		
		
		
		out.println("<input class=\"btn btn-primary\" type=\"submit\">");
		
		
		out.println("</form>");
		out.print("<a href=\"TVShows\" class=\"text-right\">Back to voting page</a>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		// Try to get the name from the session
//		HttpSession session = request.getSession();		
//		String name = (String) session.getAttribute("name");
		
//		// If the cookie doesn't exist, get the name and message from the request
//		if (name == null)
//			name = request.getParameter("name");
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		String url = request.getParameter("url");
		
		// Validate the input
		boolean hasError = false;
		
		if (name == null || name.trim().length() == 0 ) {
			hasError = true;
			request.setAttribute("nameError", "You must provide a valid name.");
		}
		if (desc == null || desc.trim().length() == 0 ) {
			hasError = true;
			request.setAttribute("descError", "You must provide a valid Description.");
		}
		
		
		if (!hasError) {
//			//If we get here, the form data validated, so let's create a session attribute
//			session.setAttribute("name", name);			
			
			// Get a reference to the tVShows ArrayList
			ArrayList<TVShowVotes> tVShows = (ArrayList<TVShowVotes>) getServletContext().getAttribute("tVShows");
			
			// Create a new TVShowVotes, and add it to the tVShows
			tVShows.add(new TVShowVotes(name, desc, url));
			
			getServletContext().setAttribute("tVShows",tVShows);

			// Send the User back to the main page
			response.sendRedirect("TVShows");
		}
		else {
			doGet(request, response);
	}

	}

}

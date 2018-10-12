package webtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.GuestBookEntry;


@WebServlet("/AddGuestBookEntryWithSessions")
public class AddGuestBookEntryWithSessions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

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
		out.println("    <title>Sign Guestbook</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		// Insert Page-Specific Content
		out.println("<h1>Sign Guestbook <small>With Sessions</small></h1>");
		
		out.println("<form action=\"AddGuestbookEntryWithSessions\" method=\"post\">");
				
		// Collect the User's name
		out.println("	<div class=\"form-group\">");
		
		
		
		// Check to see if the name exists in the session
		HttpSession session = request.getSession();		
		String name = (String) session.getAttribute("name");
		
		// If not, check the request parameter
		if (name == null)
			name = request.getParameter("name");
		
		// If not, set name to empty string
		if (name == null)
			name = "";
		
		
		if (name.length() > 0)
			out.println("<strong>" + name + "</strong>");
		else
			out.println("		 <input class=\"form-control\" value=\"" + name + "\" type=\"text\" name=\"name\" placeholder=\"Your Name\">");		
		
		if (request.getAttribute("nameError") != null) {
			out.println("<p class=\"text-danger form-text\">");
			out.println(request.getAttribute("nameError"));
			out.println("</p>");
		}		
		out.println("	</div>");
		
		// Collect the User's message
		out.println("	<div class=\"form-group\">");
		
		String message = request.getParameter("message");
		message = message == null ? "" : message;
		
		out.println("		<textarea class=\"form-control\" name=\"message\" rows=\"5\" cols=\"40\" placeholder=\"Your Message\">" + message + "</textarea>");
		
		if (request.getAttribute("messageError") != null) {
			out.println("<p class=\"text-danger form-text\">");
			out.println(request.getAttribute("messageError"));
			out.println("</p>");
		}
		out.println("	</div>");
		
		out.println("<input class=\"btn btn-primary\" type=\"submit\">");
		
		out.println("</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Try to get the name from the session
		HttpSession session = request.getSession();		
		String name = (String) session.getAttribute("name");
		
		// If the cookie doesn't exist, get the name and message from the request
		if (name == null)
			name = request.getParameter("name");
		String message = request.getParameter("message");
		
		// Validate the input
		boolean hasError = false;
		
		if (name == null || name.trim().length() == 0 ) {
			hasError = true;
			request.setAttribute("nameError", "You must provide a valid name.");
		}
		if (message == null || message.trim().length() == 0 ) {
			hasError = true;
			request.setAttribute("messageError", "You must provide a valid message.");
		}
		
			
		if (!hasError) {
			//If we get here, the form data validated, so let's create a session attribute
			session.setAttribute("name", name);			
			
			// Get a reference to the GuestBook ArrayList
			ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestbookEntries");
			
			// Create a new GuestBookEntry, and add it to the GuestBook
			guestbookEntries.add(new GuestBookEntry(name, message));
			
			// Send the User back to the main page
			response.sendRedirect("GuestBook");
		}
		else
			doGet(request, response);
	}


}

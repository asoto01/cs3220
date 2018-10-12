package webtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;


@WebServlet("/requests/AddGuestBookEntry")
public class AddGuestBookEntry extends HttpServlet {
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
		out.print("<title>Sign Guestbook</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class=\"container\">");
		
		// Insert page-specific content 
		out.print("<h1>Sign Guestbook");
		
		out.print("<form action=\"AddGuestBookEntry\" method=\"post\"");
		out.print("<div class\"form-group\">");
		out.print("<input class=\"form-control\" name=\"name\" type=\"text\" rows=\"5\" cols=\"40\" placeholder=\"Your name\">");
		out.print("</div>");
		out.print("<div class\"form-group\">");
		out.print("<input class=\"form-control\" name=\"message\" type=\"text\" rows=\"5\" cols=\"40\" placeholder=\"Your Message\">");
		
		if (request.getAttribute("nameError") != null) {
			out.print("<p class=\"text-danger form-text\">");
			out.print(request.getAttribute("messageError"));
			out.println("</p>");
			
		}
		
		out.print("</div>");
		out.print("<input class=\"btn btn-primary\" type=\"submit\">");
		out.print("</form>");

		
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the name and message from the request
		String name = request.getParameter("name");
		String message = request.getParameter("name");
		
		// Validate the input
		boolean hasError = false;
		
		if (name == null || name.trim().length() == 0) {
			hasError = true;
			request.setAttribute("nameError", "You must provide a valid name.");
		}
		
		if (name == null || name.trim().length() == 0) {
			hasError = true;
			request.setAttribute("nameError", "You must provide a valid name.");
		}
		
		
		if (!hasError) {
			
		
		
		// Get a reference to the GuesGuestBookEntryt
		ArrayList<GuestBookEntry> guestBookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestBookEntries");
		
		// Create a new GuestBookEntry, and add it to the GuestBook
		guestBookEntries.add(new GuestBookEntry(name, message));
		
		// Send the User back to the main page
		response.sendRedirect("GuestBook");
		} else {
		doGet(request, response);
		}
	}

}

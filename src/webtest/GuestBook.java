package webtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/requests/GuestBook")
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Create dummy data
		ArrayList<GuestBookEntry> guestBookEntries = new ArrayList<GuestBookEntry>();
		guestBookEntries.add(new GuestBookEntry("John Doe", "Hello, World!"));
		guestBookEntries.add(new GuestBookEntry("Mary Jane", "Hi!"));
		guestBookEntries.add(new GuestBookEntry("Joe Boxer", "Yo!"));
		
		getServletContext().setAttribute("guestBookEntries",guestBookEntries);

		
		// 
		
		
	}

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
		out.print("<title>Document</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class=\"container\">");
		
		// Insert page-specific content 
		out.print("<h1>Guestbook</h1>");
		
		// get the guestbook entries
		
		ArrayList<GuestBookEntry> guestBookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestBookEntries");
		
		// Display a table of all guestbook entries
		out.print("<table class=\"table table-bordered table-striped table-hover\">");
		out.print("<tr>");
		out.print("<th>Name</th>");
		out.print("<th>Message</th>");
		out.print("<th>Date</th>");
		out.print("<th>Actions</th>");
		out.print("</tr>");
		
		// create a new row for every guestbook entry
		for(GuestBookEntry guestBookEntry : guestBookEntries) {
			out.print("<tr>");
			out.print("<td>" + guestBookEntry.getName() +"</td>");
			out.print("<td>" + guestBookEntry.getMessage()+"</td>");
			out.print("<td>" + guestBookEntry.getDate() +"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("<a href=\"AddGuestBookEntryWithSessions\">Add Guestbook Entry</a>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

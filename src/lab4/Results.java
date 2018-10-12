package lab4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Lab4/Results")
public class Results extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = (String) getServletContext().getAttribute("title");
		
		
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

		HttpSession session = request.getSession();
		String titleSesh = (String) session.getAttribute("title");
		
		
		if (title != "") 
			out.print("<h1>Congrats you voted for: " + title + "</h1>");
		
		// get the TV show entries
		
		ArrayList<TVShowVotes> tVShows = (ArrayList<TVShowVotes>) getServletContext().getAttribute("tVShows");
		
		
	    Collections.sort(tVShows, new Comparator<TVShowVotes>() {
	        @Override public int compare(TVShowVotes p1, TVShowVotes p2) {
	            return p2.getVotes() - p1.getVotes(); // Ascending
	        }

	    });
		
		// Display a table of all TV show entries
		out.print("<table class=\"table table-bordered table-striped table-hover\">");
		out.print("<tr>");
		out.print("<th>Name</th>");
		out.print("<th>Description</th>");
		out.print("<th>Images</th>");
		out.print("<th>Votes</th>");
		out.print("</tr>");
		
		// create a new row for every TV show entry
		for(TVShowVotes tVShowVotes : tVShows) {
			if(title.equals(tVShowVotes.getName())) {
				out.print("<tr class=\"table-primary\">");
				out.print("<td>" + tVShowVotes.getName() +"</td>");
				out.print("<td>" + tVShowVotes.getDesc() +"</td>");
				out.print("<td>" + tVShowVotes.getUrl() +"</td>");
				out.print("<td>"+ tVShowVotes.getVotes() +"</td>");
				out.print("</tr>");
			} else {
				out.print("<tr>");
				out.print("<td>" + tVShowVotes.getName() +"</td>");
				out.print("<td>" + tVShowVotes.getDesc() +"</td>");
				out.print("<td>" + tVShowVotes.getUrl() +"</td>");
				out.print("<td>"+ tVShowVotes.getVotes() +"</td>");
				out.print("</tr>");
			}
		}
		out.print("</table>");
		out.print("<a href=\"TVShows\">Back to voting page</a>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

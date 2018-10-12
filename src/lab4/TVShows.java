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

@WebServlet(urlPatterns = "/Lab4/TVShows", loadOnStartup = 1)
public class TVShows extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		String title = "";
		getServletContext().setAttribute("title", title);

		
		
		// Create dummy data
		ArrayList<TVShowVotes> tVShows = new ArrayList<TVShowVotes>();
		tVShows.add(new TVShowVotes("Rick and Morty", "oooowweee", "images/rick-and-morty.jpg", 2));
		tVShows.add(new TVShowVotes("Black Mirror", "beep boop", "images/black-mirror.jpg", 1));
		tVShows.add(new TVShowVotes("Game of Thrones", "Bend the knee", "images/got-2019.jpg", 3));
		
		getServletContext().setAttribute("tVShows",tVShows);
		
		
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
		out.print("<title>Vote for a TV Show</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class=\"container\">");
		
		// Insert page-specific content 
		out.print("<h1>TV Shows</h1>");
		
		// get the TV show entries
		
		ArrayList<TVShowVotes> tVShows = (ArrayList<TVShowVotes>) getServletContext().getAttribute("tVShows");
		
		// Display a table of all TV show entries
		out.print("<table class=\"table table-bordered table-striped table-hover\">");
		out.print("<tr>");
		out.print("<th>Name</th>");
		out.print("<th>Description</th>");
		out.print("<th>Images</th>");
		out.print("<th>Vote</th>");
		out.print("</tr>");
		
		// create a new row for every TV show entry
		for(int i = 0; i < tVShows.size(); i++) {
			TVShowVotes tVShowVotes = tVShows.get(i);
			String tempPosition = "" + i;
			out.print("<tr>");
			out.print("<td>" + tVShowVotes.getName() + "</td>");
			out.print("<td>" + tVShowVotes.getDesc() +"</td>");
			out.print("<td>" + "<img src=\""+tVShowVotes.getUrl() + "\">"+"</td>");
			out.print("<td>");
			out.print("<form action=\"TVShows\" method=\"post\">");
			out.print("  <input type=\"hidden\" name=\"tempPosition\" value=\"" + tempPosition + "\"/>\n" + "");
			out.print("<button action=\"TVShows\" class=\"btn btn-primary\" type=\"submit\" >Vote!</button>");
			out.print("</form>");
			out.print("</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("<a href=\"AddTVShow\">Add TV Show</a>");

		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tempPosition = (String) request.getParameter("tempPosition");
		
		if (tempPosition != null) {		
		Integer pos = Integer.parseInt(tempPosition);
		ArrayList<TVShowVotes> tVShows = (ArrayList<TVShowVotes>) getServletContext().getAttribute("tVShows");
		TVShowVotes tVShowVotes = tVShows.get(pos);
		tVShowVotes.incrementVotes();
		
		String title = (String) getServletContext().getAttribute("title");
		title = tVShowVotes.getName();
		
		getServletContext().setAttribute("title", title);
		
		getServletContext().setAttribute("tVShows",tVShows);
		
		response.sendRedirect("Results");
		}
		else {
			System.out.println("test: " + tempPosition + " ");

			doGet(request, response);
	}

		



	}

}

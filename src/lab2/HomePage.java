package lab2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/HomePage", loadOnStartup = 1)
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		int counter = 0, counter1 = 0, counter2 = 0;
		double sum = 0.0;
		double percent = 0.0, percent1 = 0.0, percent2 = 0.0;
		getServletContext().setAttribute("counter", counter);
		getServletContext().setAttribute("counter1", counter1);
		getServletContext().setAttribute("counter2", counter2);
		getServletContext().setAttribute("sum", sum);
		getServletContext().setAttribute("percent", percent);
		getServletContext().setAttribute("percent1", percent1);
		getServletContext().setAttribute("percent2", percent2);

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get the counter
		Integer counter = (Integer) getServletContext().getAttribute("counter");
		Integer counter1 = (Integer) getServletContext().getAttribute("counter1");
		Integer counter2 = (Integer) getServletContext().getAttribute("counter2");
		Double sum = (Double) getServletContext().getAttribute("sum");
		Double percent = (Double) getServletContext().getAttribute("percent");
		Double percent1 = (Double) getServletContext().getAttribute("percent1");
		Double percent2 = (Double) getServletContext().getAttribute("percent2");

		// define sum
		sum = (double) (counter + counter1 + counter2);

		// define percents
		if (sum != 0) {
			percent = (double) (counter / sum) * 100;
			percent1 = (double) (counter1 / sum) * 100;
			percent2 = (double) (counter2 / sum) * 100;
		}

		// save it back to the application scope
		getServletContext().setAttribute("counter", counter);
		getServletContext().setAttribute("counter1", counter1);
		getServletContext().setAttribute("counter2", counter2);
		getServletContext().setAttribute("sum", sum);
		getServletContext().setAttribute("percent", percent);
		getServletContext().setAttribute("percent1", percent1);
		getServletContext().setAttribute("percent2", percent2);

		// Set content type
		response.setContentType("text/html");

		// Get a reference to the Print Writer
		PrintWriter out = response.getWriter();

		// Generate our template text
		out.print("<!DOCTYPE HTML>");
		out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print(
				"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\"crossorigin=\"anonymous\">");
		out.print("<link rel=\"stylesheet\" href=\"css/styles.css\">");
		out.print("<title>Favorite TV Show</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class=\"container\">");

		// Insert page-specific content
		out.print("<div class=\"jumbotron jumbotron-fluid\">");
		out.print("<div class=\"container\">");
		out.print("<h1 class=\"display-4\">Favorite TV Show</h1>");
		out.print("<p class=\"lead\">Vote for your favorite TV show below!</p>");
		out.print("</div>");
		out.print("</div> ");

		out.print("<div class=\"container\">");


		out.print("<div class=\"row\">");
		// GOT card
		out.print("<div class=\"col\">");
		out.print("<div class=\"card\" style=\"width: 18rem;\" >");
		out.print("<form action=\"HomePage\" method=\"post\">");
		out.print("<button action=\"HomePage\" name=\"vote\"><img class=\"card-img-top\" src=\"images/got-2019.jpg\" alt=\"Game of Thrones\"></button>");
		out.print("</form>");
		out.print("<div class=\"card-body\">");
		out.print("<h5 class=\"card-title\">Game of Thrones</h5>");
		out.print("<p class=\"card-text text-left\">Click on the image or the button to vote for this TV Show!</p>");
		out.print("<form action=\"HomePage\" method=\"post\">");
		out.print("<button type=\"submit\" class=\"btn btn-primary\" name=\"vote\" placeholder=\"1\">Submit vote</button>");
		out.print("</form>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		// Rick and Morty card
		out.print("<div class=\"col\">");
		out.print("<div class=\"card\" style=\"width: 18rem;\">");
		out.print("<form action=\"HomePage\" method=\"post\">");
		out.print("<button action=\"HomePage\" name=\"vote1\"><img class=\"card-img-top\" src=\"images/rick-and-morty.jpg\" alt=\"Rick and Morty\"></button>");
		out.print("</form>");
		out.print("<div class=\"card-body\">");
		out.print("<h5 class=\"card-title\">Rick and Morty</h5>");
		out.print("<p class=\"card-text text-left\">Click on the image or the button to vote for this TV Show!</p>");
		out.print("<form action=\"HomePage\" method=\"post\">");
		out.print("<button type=\"submit\" class=\"btn btn-primary\" name=\"vote1\" placeholder=\"1\">Submit vote</button>");
		out.print("</form>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		// Black Mirror card
		out.print("<div class=\"col\">");
		out.print("<div class=\"card\" style=\"width: 18rem;\">");
		out.print("<form action=\"HomePage\" method=\"post\">");
		out.print("<button action=\"HomePage\" name=\"vote2\"><img class=\"card-img-top\" src=\"images/black-mirror.jpg\" alt=\"Game of Thrones\"></button>");
		out.print("</form>");
		out.print("<div class=\"card-body\">");
		out.print("<h5 class=\"card-title\">Black Mirror</h5>");
		out.print("<p class=\"card-text text-left\">Click on the image or the button to vote for this TV Show!</p>");
		out.print("<form action=\"HomePage\" method=\"post\">");
		out.print("<button type=\"submit\" class=\"btn btn-primary\" name=\"vote2\" placeholder=\"1\">Submit vote</button>");
		out.print("</form>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vote = request.getParameter("vote");
		if (vote != null) {
			Integer counter = (Integer) getServletContext().getAttribute("counter");
			counter++;
			getServletContext().setAttribute("counter", counter);
			response.sendRedirect("GOTPage");
		}
		String vote1 = request.getParameter("vote1");
		if (vote1 != null) {
			Integer counter1 = (Integer) getServletContext().getAttribute("counter1");
			counter1++;
			getServletContext().setAttribute("counter1", counter1);
			response.sendRedirect("RickAndMortyPage");
		}
		String vote2 = request.getParameter("vote2");
		if (vote2 != null) {
			Integer counter2 = (Integer) getServletContext().getAttribute("counter2");
			counter2++;
			getServletContext().setAttribute("counter2", counter2);
			response.sendRedirect("BlackMirrorPage");
		}
		doGet(request, response);
	}

}

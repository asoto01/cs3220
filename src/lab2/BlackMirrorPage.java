package lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BlackMirrorPage")
public class BlackMirrorPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get counter
		Integer counter = (Integer) getServletContext().getAttribute("counter");
		Integer counter1 = (Integer) getServletContext().getAttribute("counter1");
		Integer counter2 = (Integer) getServletContext().getAttribute("counter2");
		Double sum = (Double) getServletContext().getAttribute("sum");
		Double percent = (Double) getServletContext().getAttribute("percent");
		Double percent1 = (Double) getServletContext().getAttribute("percent1");
		Double percent2 = (Double) getServletContext().getAttribute("percent2");

		// to format percentage
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		DecimalFormat df1 = new DecimalFormat();
		df1.setMaximumFractionDigits(0);

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
		out.print("<title>Black Mirror Page</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class=\"container\">");

		// Insert page-specific content
		out.print("<div class=\"jumbotron jumbotron-fluid\">");
		out.print("<div class=\"container\">");
		out.print("<h1 class=\"display-4\">You Voted for Black Mirror</h1>");
		out.print("<p class=\"lead\">Check out the analytics below!</p>");
		out.print("</div>");
		out.print("</div> ");

		out.print("<div class=\"container\">");
		out.print("<h2 class=\"text-left\">Black Mirror</h2>");
		out.print("<div class=\"row\">");

		out.print("<img src=\"images/black-mirror.jpg\" class=\"col-md-6 pull-left\">");

		out.print("<div class=\"col-md-6\">");
		out.print("<h2 class=\"text-left\">Total votes: " + df1.format(sum) + "</h2>");


		out.print("<strong>Game of Thrones (" + counter + ")</strong>");
		out.print("<div class=\"progress\">");
		out.print("<div class=\"progress-bar bg-success\" role=\"progressbar\" style=\"width:" + percent
				+ "%\" aria-valuenow=\"" + percent + "\" aria-valuemin=\"0\" aria-valuemax=\"100\">"
				+ df.format(percent) + "%</div>");
		out.print("</div>");

		out.print("<strong>Rick and Morty (" + counter1 + ")</strong>");
		out.print("<div class=\"progress\">");
		out.print("<div class=\"progress-bar bg-info\" role=\"progressbar\" style=\"width:" + percent1
				+ "%\" aria-valuenow=\"" + percent1 + "\" aria-valuemin=\"0\" aria-valuemax=\"100\">" 
				+ df.format(percent1) + "%</div>");
		out.print("</div>");

		out.print("<strong>Black Mirror ("+ counter2 + ")</strong>");
		out.print("<div class=\"progress\">");
		out.print("<div class=\"progress-bar bg-warning\" role=\"progressbar\" style=\"width:" + percent2
				+ "%\" aria-valuenow=\"" + percent2 + "\" aria-valuemin=\"0\" aria-valuemax=\"100\">" 
				+ df.format(percent2) + "%</div>");
		out.print("</div>");
		out.print("<p class=\"text-right\"><a href=\"HomePage\">Back to Home Page</a></p>");

		
		out.print("</div>");
		out.print("</div>");
		out.print("</div>");

		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

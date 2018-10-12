package lab5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab4.TVShowVotes;

@WebServlet(urlPatterns = "/Lab5/QuotePage", loadOnStartup = 1)
public class QuotePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Create dummy data
		ArrayList<Quote> quotes = new ArrayList<Quote>();
		quotes.add(new Quote("If you ain't first you're last.", "Ricky Bobby", 0, 0, 0));
		quotes.add(new Quote("A computer is like air conditioning; it becomes useless when you open windows.", "Linus Torvlads", 0, 0, 1));
		quotes.add(new Quote("Life would be tragic if it weren't funny.", "Stephen Hawking", 0, 0, 2));
		
		getServletContext().setAttribute("quotes",quotes);
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Quote> quotes = (ArrayList<Quote>) getServletContext().getAttribute("quotes");
		Random rand = new Random();
		int randNum = rand.nextInt(quotes.size());
		getServletContext().setAttribute("randNum", randNum);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/QuotePage.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}

package lab5;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Lab5/AddQuote")
public class AddQuote extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Quote user = (Quote) request.getSession().getAttribute("authorizedUser");
		request.setAttribute("user", user);
		
		//get parameters
		String quote, author;
		
		quote = request.getParameter("quote");
		author = request.getParameter("author");
		
		if (quote != null && author != null) {
			ArrayList<Quote> quotes = (ArrayList<Quote>) getServletContext().getAttribute("quotes");
			quotes.add(new Quote(quote, author, 0, 0, quotes.size()));
			getServletContext().setAttribute("quotes",quotes);
			response.sendRedirect("AdminPage");
		} else {
			response.sendRedirect("AdminPage");

		}
		
		
		
		
		
		
		
	}

}

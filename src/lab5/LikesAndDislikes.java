package lab5;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Lab5/LikesAndDislikes")
public class LikesAndDislikes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get parameters
		String like =  request.getParameter("like");
		String dislike =  request.getParameter("dislike");


		if (like != null) {
			Integer id = Integer.parseInt(like);
			int identification = id;
			ArrayList<Quote> quotes = (ArrayList<Quote>) getServletContext().getAttribute("quotes");
			Quote quotation = quotes.get(identification);
			quotation.incrementLike();
			getServletContext().setAttribute("quotes",quotes);
			response.sendRedirect("QuotePage");
		} else if (dislike != null) {
			Integer id = Integer.parseInt(dislike);
			int identification = id;
			ArrayList<Quote> quotes = (ArrayList<Quote>) getServletContext().getAttribute("quotes");
			Quote quotation = quotes.get(identification);
			quotation.incrementDislike();
			response.sendRedirect("QuotePage");

		}
		doGet(request, response);
	}

}

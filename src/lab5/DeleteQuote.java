package lab5;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Lab5/DeleteQuote")
public class DeleteQuote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get parameters
		String delete =  request.getParameter("delete");

		if (delete != null) {
			Integer id = Integer.parseInt(delete);
			int identification = id;
			ArrayList<Quote> quotes = (ArrayList<Quote>) getServletContext().getAttribute("quotes");
			quotes.remove(identification);
			getServletContext().setAttribute("quotes",quotes);
			response.sendRedirect("AdminPage");
		} else {
			response.sendRedirect("AdminPage");

		}
	}

}

package appstore;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab5.Quote;


@WebServlet("/AppDescriptionController")
public class AppDescriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<App> results = (ArrayList<App>) getServletContext().getAttribute("results");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AppDescription.jsp");
		dispatcher.forward(request, response);	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

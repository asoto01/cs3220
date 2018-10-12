package webtest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;


@WebServlet("/requests/EditGuestBookEntry")
public class EditGuestBookEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Fetch the Guest Book Entry being edited
		ArrayList<GuestBookEntry> guestBookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestBookEntries");
		
		// Get the index of the entry we aer editing
		int index = Integer.parseInt(request.getParameter("id"));
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

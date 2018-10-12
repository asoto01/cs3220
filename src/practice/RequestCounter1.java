package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/RequestCounter1", loadOnStartup=1)
public class RequestCounter1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		int counter = 0;
		getServletContext().setAttribute("counter", counter);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get the counter
		Integer counter = (Integer) getServletContext().getAttribute("counter");
		// increment the counter
		++counter;
		// save it back the application scope
		getServletContext().setAttribute("counter", counter);
		
		// display the message "The counter is incremented"
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<!DOCTYPE><html lang=\"en\"><head><title>Request Counter</title></head><body>"
				+ "<p>The counter is incrememented</p></body></html>");
	}

}

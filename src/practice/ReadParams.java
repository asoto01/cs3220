package practice;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/ReadParams")
// Extend HttpServlet class
public class ReadParams extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Method to handle GET method request.
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String title = "Reading All Form Parameters";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

		String myvar = "<form action = \"ReadParams\" method = \"POST\">"
				+ "         <input type = \"checkbox\" name = \"maths\" checked = \"checked\" /> Maths"
				+ "         <input type = \"checkbox\" name = \"physics\"  /> Physics"
				+ "         <input type = \"checkbox\" name = \"chemistry\" checked = \"checked\" /> Chem"
				+ "         <input type = \"submit\" value = \"Select Subject\" />" + "      </form>";

		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n"
				+ "<table width = \"100%\" border = \"1\" align = \"center\">\n" + "<tr bgcolor = \"#949494\">\n"
				+ "<th>Param Name</th>" + "<th>Param Value(s)</th>\n" + "</tr>\n" + myvar);

		Enumeration paramNames = request.getParameterNames();

		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			out.print("<tr><td>" + paramName + "</td>\n<td>");
			String[] paramValues = request.getParameterValues(paramName);

			// Read single valued data
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() == 0)
					out.println("<i>No Value</i>");
				else
					out.println(paramValue);
			} else {
				// Read multiple valued data
				out.println("<ul>");

				for (int i = 0; i < paramValues.length; i++) {
					out.println("<li>" + paramValues[i]);
				}
				out.println("</ul>");
			}
		}
		out.println("</tr>\n</table>\n</body></html>");
	}

	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
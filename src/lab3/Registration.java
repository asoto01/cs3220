package lab3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lab3/Register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String name = "";
		String email = "";
		String password = "";
		String passwordRetry = "";
		int error = 0, error1 = 0, error2 = 0;
		
		getServletContext().setAttribute("name", name);
		getServletContext().setAttribute("email", email);
		getServletContext().setAttribute("password", password);
		getServletContext().setAttribute("passwordRetry", passwordRetry);
		getServletContext().setAttribute("error", error);
		getServletContext().setAttribute("error1", error1);
		getServletContext().setAttribute("error2", error2);


		
	}
	
	public boolean nameValid(String name) {
		if (name == "") 
			return false;
		else if (name.indexOf(' ') == -1)
			return false;
		return true;
	}
	
	
	public boolean emailValid(String email) {
		if (email == "") 
			return false;
		else if (email.indexOf('@') == -1)
			return false;
		else 
			return true;
	}
	
	public boolean passwordValid(String password, String passwordRetry) {
		if(!(password.equals(passwordRetry)))
			return false;
		else if (password.length() == 0)
			return false;
		else
			return true;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get attributes
		String name = (String) getServletContext().getAttribute("name");
		String email = (String) getServletContext().getAttribute("email");
		String password = (String) getServletContext().getAttribute("password");
		String passwordRetry = (String) getServletContext().getAttribute("passwordRetry");
		Integer error = (Integer) getServletContext().getAttribute("error");
		Integer error1 = (Integer) getServletContext().getAttribute("error1");
		Integer error2 = (Integer) getServletContext().getAttribute("error2");

		
		// Save it back to the application scope
		getServletContext().setAttribute("name", name);
		getServletContext().setAttribute("email", email);
		getServletContext().setAttribute("password", password);
		getServletContext().setAttribute("passwordRetry", passwordRetry);
		getServletContext().setAttribute("error", error);
		getServletContext().setAttribute("error1", error1);
		getServletContext().setAttribute("error2", error2);

		
		
		// Set content type
		response.setContentType("text/html");
		
		// Get a reference to the Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate our template text
		out.print("<!DOCTYPE HTML>");
		out.print("<html lang=\"en\">");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<link rel=\"stylesheet\""+
				"	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\""+
				"	integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\""+
				"	crossorigin=\"anonymous\">"+
				""+
				"<title>Register</title>"+
				"</head>"+
				"<body>"+
				"	<div class=\"container\">"+
				"		<div class=\"page-header\">"+
				"			<h1>Register</h1>"+
				"		</div>"+
				"		<form action=\"Register\" method=\"post\">");
		// name
		if (error == 0) {
			out.print(
					"			<div class=\"form-group\">"+
							"				<label>Full Name</label> <input class=\"form-control\""+
							"					type=\"text\" name=\"fullName\" placeholder=\"Full Name\" value=\""+ name +" \">"+
					"			</div>");
		} else {
			out.print(
					"<p> Enter a valid name.</p>"+
					"			<div class=\"form-group\">"+
							"				<label>Full Name</label> <input class=\"form-control\""+
							"					type=\"text\" name=\"fullName\" placeholder=\"Full Name\" value=\""+ name +" \">"+
					"			</div>");
		}
		// email
		if (error1 == 0) {
		out.print(
				"			<div class=\"form-group\">"+
				"				<label>E-mail Address</label> <input class=\"form-control\""+
				"					type=\"text\" name=\"emailInput\" placeholder=\"E-mail\" value=\""+ email +  "\">"+
				"			</div>");
		} else {
			out.print(
					"<p> Enter a valid email.</p>"+
					"			<div class=\"form-group\">"+
					"				<label>E-mail Address</label> <input class=\"form-control\""+
					"					type=\"text\" name=\"emailInput\" placeholder=\"E-mail\" value=\""+ email +  "\">"+
					"			</div>");
		}
		// password
		if (error2 == 0) {
		out.print(
				"			<div class=\"form-group\">"+
				"				<label>Password</label> <input class=\"form-control\" type=\"password\""+
				"					name=\"passwordInput\" placeholder=\"Password\">"+
				"             </div>"+
				"			<div class=\"form-group\">"+
				"				<label>Confirm Password</label> <input class=\"form-control\" type=\"password\""+
				"					name=\"confirmPasswordInput\" placeholder=\"Confirm Password\"> <br>"+
				"				<button type=\"submit\" class=\"btn btn-primary\">Login</button>"+
				"             </div>");
		} else {
			out.print(
					"<p>Your passwords did not match or you did not type in a password.</p>"+
					"			<div class=\"form-group\">"+
					"				<label>Password</label> <input class=\"form-control\" type=\"password\""+
					"					name=\"passwordInput\" placeholder=\"Password\">"+
					"             </div>"+
					"			<div class=\"form-group\">"+
					"				<label>Confirm Password</label> <input class=\"form-control\" type=\"password\""+
					"					name=\"confirmPasswordInput\" placeholder=\"Confirm Password\"> <br>"+
					"				<button type=\"submit\" class=\"btn btn-primary\">Login</button>"+
					"             </div>");
		}
		out.print(
				"		</form>"+
				""+
				"	</div>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// name
		String fullName = request.getParameter("fullName");
		if (nameValid(fullName) == true ) {
			String name = (String) getServletContext().getAttribute("name");
			Integer error = (Integer) getServletContext().getAttribute("error");
			name = fullName;
			error = 0;
			getServletContext().setAttribute("name", name);
			getServletContext().setAttribute("error", error);
		} else {
			Integer error = (Integer) getServletContext().getAttribute("error");
			error = 1;
			getServletContext().setAttribute("error", error);
		}
		// email
		String emailInput = request.getParameter("emailInput");
		if (emailValid(emailInput) == true ) {
			String email = (String) getServletContext().getAttribute("email");
			Integer error1 = (Integer) getServletContext().getAttribute("error1");
			email = emailInput;
			error1 = 0;
			getServletContext().setAttribute("email", email);
			getServletContext().setAttribute("error1", error1);
		} else {
			Integer error1 = (Integer) getServletContext().getAttribute("error1");
			error1 = 1;
			getServletContext().setAttribute("error1", error1);
		}
		// password
		String passwordInput = request.getParameter("passwordInput");
		String confirmPasswordInput = request.getParameter("confirmPasswordInput");
		if (passwordValid(passwordInput, confirmPasswordInput) == true ) {
			String password = (String) getServletContext().getAttribute("password");
			Integer error2 = (Integer) getServletContext().getAttribute("error2");
			password = passwordInput;
			error2 = 0;
			getServletContext().setAttribute("password", password);
			getServletContext().setAttribute("error2", error2);
		} else {
			Integer error2 = (Integer) getServletContext().getAttribute("error2");
			error2 = 1;
			getServletContext().setAttribute("error2", error2);
		}	
		Integer error = (Integer) getServletContext().getAttribute("error");
		Integer error1 = (Integer) getServletContext().getAttribute("error1");
		Integer error2 = (Integer) getServletContext().getAttribute("error2");
		int errorSum = error + error1 + error2;
		if (errorSum == 0) {
			response.sendRedirect("Welcome");
		}


		doGet(request, response);
	}

}

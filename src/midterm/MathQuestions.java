package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Midterm/MathQuestions")
public class MathQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// Create four MathProblems
		ArrayList<MathProblems> maths = new ArrayList<MathProblems>();
		maths.add(new MathProblems());
		maths.add(new MathProblems());
		maths.add(new MathProblems());
		maths.add(new MathProblems());

		getServletContext().setAttribute("maths", maths);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get MathProblems
		ArrayList<MathProblems> maths = (ArrayList<MathProblems>) getServletContext().getAttribute("maths");

		// Get four MathProblem objects
		MathProblems mathAdd = maths.get(0);
		MathProblems mathSub = maths.get(1);
		MathProblems mathMult = maths.get(2);
		MathProblems mathDiv = maths.get(3);

		// Generate addition problem
		mathAdd.setProblem("");
		String addition = mathAdd.generateAddProb();
		Double addAnswer = mathAdd.getAnswer();
		DecimalFormat format = new DecimalFormat("0.#");
		String answer0 = "" + format.format(addAnswer);
		;
		getServletContext().setAttribute("answer0", answer0);

		// Generate subtraction problem
		mathSub.setProblem("");
		String subtraction = mathSub.generateSubProb();
		Double subAnswer = mathSub.getAnswer();
		String answer1 = "" + format.format(subAnswer);
		getServletContext().setAttribute("answer1", answer1);

		// Generate multiplication problem
		mathMult.setProblem("");
		String multiplication = mathMult.generateMultProb();
		Double multAnswer = mathMult.getAnswer();
		String answer2 = "" + format.format(multAnswer);
		getServletContext().setAttribute("answer2", answer2);

		// Generate division problem
		mathDiv.setProblem("");
		String division = mathDiv.generateDivProb();
		Double divAnswer = mathDiv.getAnswer();
		String answer3 = "" + format.format(divAnswer);
		getServletContext().setAttribute("answer3", answer3);

		// Set Content Type
		response.setContentType("text/html");

		// Get a reference to the Print Writer
		PrintWriter out = response.getWriter();

		// Opening tag for html, complete header, and opening body tag
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <link rel=\"stylesheet\" "
				+ "href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" "
				+ "integrity=\"sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB\" "
				+ "crossorigin=\"anonymous\">");
		out.println("    <title>Math Fundamentals</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		// Get user name
		String userName = (String) getServletContext().getAttribute("userName");

		// Check if user name is null or an empty string
		if (userName == null || userName.trim().length() == 0) {
			getServletContext().setAttribute("userName", "Friend");
			response.sendRedirect("MathQuestions");
		}

		// Display Header (user name)
		out.println("<br>");
		out.println("<h1>Welcome, " + userName + "</h1>");
		out.println("<hr>");

		// Form with action, and method
		out.println("<form action=\"MathQuestions\" method=\"post\">");

		// Display addition question
		out.println("	<div class=\"form-group\">");
		out.println("<p>Addition Problem: </p>");
		out.println("<p> " + addition + " " + " </p>");
		out.println("<input class=\"form-control\" type=\"text\" name=\"add\" placeholder=\"Answer\">");
		// Error message for addition
		if (request.getAttribute("addError") != null) {
			out.println("<p class=\"text-danger form-text\">");
			out.println(request.getAttribute("addError"));
			out.println("</p>");
		}
		out.println("	</div>");

		// Display subtraction question
		out.println("	<div class=\"form-group\">");
		out.println("<p>Subtraction Problem: </p>");
		out.println("<p> " + subtraction + " </p>");
		out.println("<input class=\"form-control\" type=\"text\" name=\"sub\" placeholder=\"Answer\">");
		// Error message for subtraction
		if (request.getAttribute("subError") != null) {
			out.println("<p class=\"text-danger form-text\">");
			out.println(request.getAttribute("subError"));
			out.println("</p>");
		}
		out.println("	</div>");

		// Display multiplication question
		out.println("	<div class=\"form-group\">");
		out.println("<p>Multiplication Problem: </p>");
		out.println("<p> " + multiplication + " </p>");
		out.println("<input class=\"form-control\" type=\"text\" name=\"mult\" placeholder=\"Answer\">");
		// Error message for multiplication
		if (request.getAttribute("multError") != null) {
			out.println("<p class=\"text-danger form-text\">");
			out.println(request.getAttribute("multError"));
			out.println("</p>");
		}
		out.println("	</div>");

		// Display division question
		out.println("	<div class=\"form-group\">");
		out.println("<p>Division Problem: </p>");
		out.println("<p> " + division +  " </p>");
		out.println("<input class=\"form-control\" type=\"text\" name=\"div\" placeholder=\"Answer\">");
		// Error message for division
		if (request.getAttribute("divError") != null) {
			out.println("<p class=\"text-danger form-text\">");
			out.println(request.getAttribute("divError"));
			out.println("</p>");
		}
		out.println("	</div>");

		// Button for submitting
		out.println("<input class=\"btn btn-primary\" type=\"submit\">");

		// close for Form
		out.println("</form>");

		
		// Redirect to home page for easy navigation
		out.println("<br>");
		out.println("<a href=\"MathPage\">Go to homepage</a>");
		
		// close bootstrap class container, body, and html
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		// Get inputs
		String add = request.getParameter("add");
		String sub = request.getParameter("sub");
		String mult = request.getParameter("mult");
		String div = request.getParameter("div");

		// Validate the input
		boolean hasError = false;

		if (add == null || add.trim().length() == 0) {
			hasError = true;
			request.setAttribute("addError", "You must provide a valid answer.");
		}
		if (sub == null || sub.trim().length() == 0) {
			hasError = true;
			request.setAttribute("subError", "You must provide a valid answer.");
		}
		if (mult == null || mult.trim().length() == 0) {
			hasError = true;
			request.setAttribute("multError", "You must provide a valid answer.");
		}
		if (div == null || div.trim().length() == 0) {
			hasError = true;
			request.setAttribute("divError", "You must provide a valid answer.");
		}

		if (!hasError) {
			
			// Get answers
			String answer0 = (String) getServletContext().getAttribute("answer0");
			String answer1 = (String) getServletContext().getAttribute("answer1");
			String answer2 = (String) getServletContext().getAttribute("answer2");
			String answer3 = (String) getServletContext().getAttribute("answer3");
			
			// Total score
			int totalScore = 0;
			
			// Total answers
			double totalAnswers = 4.0;
			
			// Check each answer
			if (add.equals(answer0)) {
				totalScore++;
			}
			if (sub.equals(answer1)) {
				totalScore++;
			}
			if (mult.equals(answer2)) {
				totalScore++;
			}
			if (div.equals(answer3)) {
				totalScore++;
			}

			// Compute and format score
			DecimalFormat format = new DecimalFormat("0.#");
			Double computeScore = totalScore / totalAnswers * 100;

			// Set score
			String score = "" + format.format(computeScore) + "%";
			getServletContext().setAttribute("score", score);

			// Redirect to MathScore
			response.sendRedirect("MathScore");
		} else {
			doGet(request, response);
		}
	}

}

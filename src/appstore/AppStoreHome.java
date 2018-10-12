package appstore;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AppStoreHome")
public class AppStoreHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		throw new ServletException(e);
	}
	
	ArrayList<App> apps = new ArrayList<App>();
	java.sql.Connection c = null;
	try {
		String username = "cs3220stu23";
		String password = "UcGpJ6tM";
		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu23";
		c = DriverManager.getConnection(url, username, password);
		java.sql.Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("select * from apps");
		while (rs.next()) {
			App app = new App(rs.getInt("id"), rs.getString("name"), rs.getInt("size_bytes"),
					rs.getDouble("price"), rs.getDouble("rating"), rs.getString("genre"));
			apps.add(app);
		}
		getServletContext().setAttribute("apps", apps);
	} catch (SQLException e) {
		throw new ServletException(e);
	} finally {
		try {
			if (c != null)
				c.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AppStoreHome.jsp");
		dispatcher.forward(request, response);	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

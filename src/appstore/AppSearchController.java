package appstore;

import java.io.IOException;
import java.sql.Connection;
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

import com.mysql.jdbc.Statement;


/**
 * Servlet implementation class AppSearchController
 */
@WebServlet(urlPatterns ="/AppSearchController", loadOnStartup =1)
public class AppSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
    	
    	
    }
  
    public AppSearchController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("test");
		
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AppStoreHome.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("query");
		
		ArrayList<App> apps = (ArrayList<App>) getServletContext().getAttribute("apps");
		
		
		ArrayList<App> results = hasMatches(apps, query);
				

		request.setAttribute("results", results);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/AppStoreHome.jsp");
		dispatcher.forward(request, response);

	}
	
	private ArrayList<App> hasMatches(ArrayList<App> apps, String comparater) {
		
		ArrayList<App> results = new ArrayList<>();
		for ( App app : apps ) {
			if ( isMatch(app, comparater) ) {
				results.add(app);
				System.out.println("match: ID = " + app.getId() + " Title: "  + app.getName() );
			}
		}
		return results;
	}
	
	private boolean isMatch( App app, String comparater ) {
				
		if ( comparater.trim().length() == 0 || comparater == null )
			return false;
		
		String query = comparater.toLowerCase();
		
			if ( app.getName().toLowerCase().contains( query ) )
				return true;
			if ( app.getGenre().toLowerCase().contains( query ) )
				return true;
		
		return false;
	}
}

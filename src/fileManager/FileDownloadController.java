package fileManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FileDownloadController")
public class FileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String path = getServletContext().getRealPath("/uploads");
		String downLoadName = request.getParameter("fileName");

		
		
		//String file_name = (String)servletContext.getAttribute("fname"); //"donkey.jpg"; 
		//String file_path = (String)servletContext.getAttribute("fpath"); //"/Users/Asiri/Desktop/donkey.jpg";
		
		// Set content type as JPG
		//response.setContentType("image/png"); //----setting content type not required??----//
		
		// Set Content-Disposition Header to force download
		response.setHeader("Content-Disposition", "attachment; filename=" + downLoadName + ""); 
		
		// Read the contents of the image, and send it to the requester
		FileInputStream in = new FileInputStream(path + File.separator + downLoadName);
		OutputStream out = response.getOutputStream();
		
		byte buffer[] = new byte[8192];
		int bytesread;
		
		while((bytesread = in.read(buffer)) > 0)
		{
			out.write(buffer, 0, bytesread);
		}
		
		in.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

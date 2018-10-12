package fileManager;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;


@MultipartConfig
@WebServlet("/FileControllerServlet")
public class FileControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FileDbUtil fileDbUtil;
	
	@Resource(name="jdbc/web_file_tracker")
	
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			fileDbUtil = new FileDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing files
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listFiles(request, response);
				break;
				
			case "ADD":
				addFile(request, response);
				break;
				
			case "LOAD":
				loadFile(request, response);
				break;
				
			case "UPDATE":
				updateFile(request, response);
				break;
			
			case "DELETE":
				deleteFile(request, response);
				break;
				
			case "SEARCH":
	            searchFiles(request, response);
	            break;
			
			case "DOWNLOAD":
				downloadFile(request, response);
				break;
				
			default:
				listFiles(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		final String path = getServletContext().getRealPath("/uploads");
		final Part filePart = request.getPart("file");
		String fileN = getFileName(filePart);
		getServletContext().setAttribute("fileN", fileN);
		
		String fName = request.getParameter("fileName");
		

		OutputStream out = null;
		InputStream filecontent = null;
		final PrintWriter writer = response.getWriter();
		
		try {
						
			out = new FileOutputStream(new File(path + File.separator + fName));
			filecontent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			System.out.println("New file " + fName + " created at " + path);

			addFile(request, response);
		} catch (FileNotFoundException fne) {
			writer.println(
					"You either did not sepcify a file to upload or are trying to upload a file to a protected or nonexistent location.");
			writer.println("</br> ERROR: " + fne.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
		
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	private void deleteFile(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read file id from form data
		String theFileId = request.getParameter("fileId");
		
		// delete file from database
		fileDbUtil.deleteFile(theFileId);
		
		// send them back to "list files" page
		listFiles(request, response);
	}
	
	private void downloadFile(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			// read file info from form data
			String downLoadName = request.getParameter("fileName");
			request.setAttribute("downLoadName", downLoadName);
			

			// create a new file object
			response.sendRedirect("FileDownloadController");

						
		}

	private void updateFile(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read file info from form data
		int id = Integer.parseInt(request.getParameter("fileId"));
		String fileName = request.getParameter("fileName");
		String pathName = request.getParameter("pathName");
		String date = request.getParameter("date");
		
		// create a new file object
		fileManager.File theFile = new fileManager.File(id, fileName, pathName, date);
		
		// perform update on database
		fileDbUtil.updateFile(theFile);
		
		// send them back to the "list files" page
		listFiles(request, response);
		
	}

	private void loadFile(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read file id from form data
		String theFileId = request.getParameter("fileId");
		
		// get file from database (db util)
		fileManager.File theFile = fileDbUtil.getFile(theFileId);
		
		// place file in the request attribute
		request.setAttribute("THE_FILE", theFile);
		
		// send to jsp page: update-files-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/update-files-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addFile(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read file info from form data
		String fName = (String) getServletContext().getAttribute("fileN");
		String fileName = request.getParameter("fileName");
		String pathName = request.getParameter("pathName");
		String date = request.getParameter("date");		
		
		if (fileName.length() == 0) {
			fileManager.File theFile = new fileManager.File(fName, pathName, date);
			fileDbUtil.addFile(theFile);
		} else {
			fileManager.File theFile = new fileManager.File(fileName, pathName, date);
			fileDbUtil.addFile(theFile);
		}

		
				
		// send back to main page (the file list)
		listFiles(request, response);
	}

	private void listFiles(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get files from db util
		List<fileManager.File> files = fileDbUtil.getFiles();
		
		// add files to the request
		request.setAttribute("FILE_LIST", files);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/list-files.jsp");
		dispatcher.forward(request, response);
	}
	
	private void searchFiles(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read search name from form data
        String theSearchName = request.getParameter("theSearchName");

        // search files from db util
        List<fileManager.File> files = fileDbUtil.searchFile(theSearchName);

        // add files to the request
        request.setAttribute("FILE_LIST", files);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/list-files.jsp");
        dispatcher.forward(request, response);
    }
	
	
	
	
	

}














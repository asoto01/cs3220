package upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/UploadController")
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		final String path = getServletContext().getRealPath("/uploads");
		final Part filePart = request.getPart("file");
		String fileName = getFileName(filePart);
		
		

		OutputStream out = null;
		InputStream filecontent = null;
		final PrintWriter writer = response.getWriter();
		
		try {
						
			out = new FileOutputStream(new File(path + File.separator + fileName));
			filecontent = filePart.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			System.out.println("Uploaded");
//			writer.println("New file " + fileName + " created at " + path);
			response.sendRedirect("ListUploadHome");
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

}

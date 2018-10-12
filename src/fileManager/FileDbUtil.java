package fileManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class FileDbUtil {

	public DataSource dataSource;

	public FileDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<File> getFiles() throws Exception {

		List<File> files = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// get a connection
			myConn = dataSource.getConnection();

			// create sql statement
			String sql = "select * from file order by file_name";

			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String fileName = myRs.getString("file_name");
				String pathName = myRs.getString("path_name");
				String date = myRs.getString("date");

				// create new file object
				File tempFile = new File(id, fileName, pathName, date);

				// add it to the list of files
				files.add(tempFile);
			}

			return files;
		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close(); // doesn't really close it ... just puts back in connection pool
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addFile(File theFile) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "insert into file " + "(file_name, path_name, date) " + "values (?, ?, CURDATE())";

			myStmt = myConn.prepareStatement(sql);

			// set the param values for the file
			myStmt.setString(1, theFile.getFileName());
			myStmt.setString(2, theFile.getPathName());

			// execute sql insert
			myStmt.execute();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public File getFile(String theFileId) throws Exception {

		File theFile = null;

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int fileId;

		try {
			// convert file id to int
			fileId = Integer.parseInt(theFileId);

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to get selected file
			String sql = "select * from file where id=?";

			// create prepared statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, fileId);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result set row
			if (myRs.next()) {
				String fileName = myRs.getString("file_name");
				String pathName = myRs.getString("path_name");
				String date = myRs.getString("date");

				// use the fileId during construction
				theFile = new File(fileId, fileName, pathName, date);
			} else {
				throw new Exception("Could not find file id: " + fileId);
			}

			return theFile;
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateFile(File theFile) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create SQL update statement
			String sql = "update file " + "set file_name=?, path_name=?, date=? " + "where id=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theFile.getFileName());
			myStmt.setString(2, theFile.getPathName());
			myStmt.setString(3, theFile.getDate());
			myStmt.setInt(4, theFile.getId());

			// execute SQL statement
			myStmt.execute();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteFile(String theFileId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// convert file id to int
			int fileId = Integer.parseInt(theFileId);

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to delete file
			String sql = "delete from file where id=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, fileId);

			// execute sql statement
			myStmt.execute();
		} finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}
	}
	

	public List<File> searchFile(String theFileName) throws Exception {
		List<File> files = new ArrayList<>();

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int fileId;

		try {
			// get connection to database

			myConn = dataSource.getConnection();
			// search by name unless thesearchname is not empty

			if (theFileName != null && theFileName.trim().length() > 0) {
				// create the sql seach for files by the name

				String sql = "select * from file where lower(file_name) like ? or lower(path_name) like ?";
				myStmt = myConn.prepareStatement(sql);
				// setting up the paramas
				String theSearchNameLike = "%" + theFileName.toLowerCase() + "%";
				myStmt.setString(1, theSearchNameLike);
				myStmt.setString(2, theSearchNameLike);

			} else {

				// create the sql to get all files
				String sql = "select * from file order by fileName";
				myStmt = myConn.prepareStatement(sql);
			} // preapared stament

			// execute the statement
			myRs = myStmt.executeQuery();
			// retrieve data from set row
			while (myRs.next()) {

				int id = myRs.getInt("id");
				String firstName = myRs.getString("file_name");
				String lastName = myRs.getString("path_name");
				String email = myRs.getString("date");

				// create new file object
				File tempFile = new File(id, firstName, lastName, email);

				files.add(tempFile);
			}

			return files;
		} finally {
			close(myConn, myStmt, myRs);
		}
	}

}

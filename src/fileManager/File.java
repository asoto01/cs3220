package fileManager;

public class File {

	private int id;
	private String fileName;
	private String pathName;
	private String date;

	public File(String fileName, String pathName, String date) {
		this.fileName = fileName;
		this.pathName = pathName;
		this.date = date;
	}
	

	public File(int id, String fileName, String pathName, String date) {
		this.id = id;
		this.fileName = fileName;
		this.pathName = pathName;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fileName=" + fileName + ", pathName=" + pathName + ", date=" + date + "]";
	}	
}

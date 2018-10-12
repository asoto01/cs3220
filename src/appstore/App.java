package appstore;

public class App {
	int id;
	String name;
	int size_bytes;
	double price;
	double rating;
	String genre;
	
	public App(int id, String name, int size_bytes, double price, double rating, String genre) {
		super();
		this.id = id;
		this.name = name;
		this.size_bytes = size_bytes;
		this.price = price;
		this.rating = rating;
		this.genre = genre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize_bytes() {
		return size_bytes;
	}
	public void setSize_bytes(int size_bytes) {
		this.size_bytes = size_bytes;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

}

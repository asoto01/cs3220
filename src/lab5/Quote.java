package lab5;

public class Quote {

	String quote;
	String Author;
	int like;
	int dislike;
	int id;
	
	public Quote(String quote, String author, int like, int dislike, int id) {
		super();
		this.quote = quote;
		Author = author;
		this.like = like;
		this.dislike = dislike;
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getLike() {
		return like;
	}

	public void incrementLike() {
		this.like++;
	}

	public int getDislike() {
		return dislike;
	}

	public void incrementDislike() {
		this.dislike++;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
	
	
}

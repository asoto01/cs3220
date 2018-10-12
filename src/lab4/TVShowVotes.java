package lab4;

public class TVShowVotes {
	String name;
	String desc;
	String url;
	int votes;

	public TVShowVotes(String name, String desc, String url, int votes) {
		super();
		this.name = name;
		this.desc = desc;
		this.url = url;
		this.votes = votes;
	}
	
	public TVShowVotes(String name, String desc, String url) {
		super();
		this.name = name;
		this.desc = desc;
		this.url = url;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getVotes() {
		return votes;
	}

	public void incrementVotes() {
		votes++;
	}
	
	

}
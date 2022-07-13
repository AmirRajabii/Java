package model;

public class RelUserPage {
	// private User user;
	private String name;
	private long creationDate;
	private Page page;

	public RelUserPage() {
		super();
	}

	public RelUserPage(String name, long creationDate, Page page) {
		super();
		this.name = name;
		this.creationDate = creationDate;
		this.page = page;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
